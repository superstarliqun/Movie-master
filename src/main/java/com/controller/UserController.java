package com.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.util.RestResult;
import com.util.UploadUtils;
import com.vo.UserVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.entity.User;
import com.github.pagehelper.PageInfo;
import com.service.UserService;

/**
 * 用户模块
 */
@RestController
@RequestMapping("/user/api")
public class UserController {

	@Resource
	private UserService userService;

	/**
	 * 用户登录接口
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/login")
	public RestResult login(User user){
		User data = userService.login(user);
		if(data!=null){
			return RestResult.ok(data);
		}else{
			return RestResult.build(500,"登录用户名不存在");
		}
	}

	/**
	 * 管理员添加用户  与 前台注册 公用一个接口
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/register")
	public RestResult register(UserVo user, HttpServletRequest request){
		if(user.getFile()!=null){
			user.setImg(UploadUtils.getImgUrl(user.getFile(),request));
		}
 		if(userService.register(user)!=-1){
			return RestResult.ok();
		}else{
			return RestResult.build(500,"用户已经存在，请更换名称");
		}
	}

	/**
	 * 用户分页查询接口
	 * @param user
	 * @param pageInfo
	 * @return
	 */
	@PostMapping(value = "/findUserPage")
	public RestResult findUserPage(User user,PageInfo pageInfo){
		PageInfo userPage = userService.findUserPage(user, pageInfo);
		return RestResult.ok(userPage);
	}


	/**
	 * 删除用户信息
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/delUser")
	public RestResult delUser(Integer id){
		if(userService.deleteByPrimaryKey(id)!=0){
			return RestResult.ok();
		}else{
			return RestResult.build(500,"删除失败");
		}

	}

	/**
	 * 查询个人信息
	 */
	@PostMapping(value = "/findOneUser")
	public RestResult findOneUser(Integer id){
		return RestResult.ok(userService.findOneUser(id));
	}


	/**
	 * 修改用户基本信息
	 * @param userVo
	 * @return
	 */
	@PostMapping(value = "/updateUser")
	public RestResult updateUser(UserVo userVo,HttpServletRequest request){
		if(userVo.getFile()!=null){
			userVo.setImg(UploadUtils.getImgUrl(userVo.getFile(), request));
		}
		try {
			if(userService.updateByPrimaryKeySelective(userVo)>0){
				return RestResult.ok();
			}else{
				return RestResult.build(404,"原密码错误");
			}
		}catch (Exception e){
			e.printStackTrace();
			return RestResult.build(500,"修改失败");
		}
	}

	@GetMapping(value = "/defaultUserDropDown")
	public RestResult defaultUserDropDown(){
		return RestResult.ok(userService.defaultUserDropDown());
	}



}
