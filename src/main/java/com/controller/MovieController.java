package com.controller;


import com.entity.MovieInfo;
import com.github.pagehelper.PageInfo;
import com.google.protobuf.RpcUtil;
import com.service.MovieInfoService;
import com.util.RestResult;
import com.util.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 电影详情管理模块
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieInfoService movieInfoService;

	/**
	 * 查询电影主页数据
	 * 显示正在热映数8条 显示即将上映8条数据
	 */
	@GetMapping("/pageMainMovie")
	public RestResult pageMainMovie(){
		HashMap<String,Object> map = new HashMap<>();
		//查询正在热映数8条 显示即将上映8条数据
		List<MovieInfo> list =  movieInfoService.pageMainMovie();
		//查询票房最高列表
		List<MovieInfo> Highest =  movieInfoService.Highest();
		//查询推进电影
		List<MovieInfo> recommend =  movieInfoService.recommend();
		map.put("index",list);
		map.put("high",Highest);
		map.put("recommend",recommend);
		return RestResult.ok(map);
	}

	/**
	 * 电影列表分页显示
	 * @param movieInfo
	 * @param pageInfo
	 * @return
	 */
	@GetMapping("/findMoviePage")
	public RestResult findMoviePage(MovieInfo movieInfo,PageInfo pageInfo){
		return RestResult.ok(movieInfoService.findMoviePage(movieInfo,pageInfo));
	}

	/**
	 * 电影添加接口  /  修改接口
	 * @param movieInfo
	 * @return
	 */
	@PostMapping(value = "/editMovie")
	public RestResult editMovie(MovieInfo movieInfo,HttpServletRequest request){
		try {
			if(movieInfo.getMovieFile()!=null){
				movieInfo.setMovieImgUrl(UploadUtils.getImgUrl(movieInfo.getMovieFile(),request));
				movieInfo.setMovieImgName(movieInfo.getMovieFile().getOriginalFilename());
			}
			if(movieInfo.getDirectorFile()!=null){
				movieInfo.setDirectorImgUrl(UploadUtils.getImgUrl(movieInfo.getDirectorFile(),request));
			}
			movieInfoService.editMovie(movieInfo);
			return RestResult.ok();
		}catch (Exception e){
			e.printStackTrace();
			return RestResult.build(500,"请求失败");
		}
	}


	/**
	 * 电影删除接口
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/delMovie")
	public RestResult delMovie(Integer id){
		try {
			if(movieInfoService.deleteByPrimaryKey(id)>0){
				return RestResult.ok();
			}else{
				return RestResult.build(400,"删除失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			return RestResult.build(500,"删除失败");
		}
	}

	/**
	 * 查询电影详情
	 * @param movieInfo
	 * @return
	 */
	@GetMapping(value = "/findOneMovie")
	public RestResult findOneMovie(MovieInfo movieInfo){
		return RestResult.ok(movieInfoService.selectByPrimaryKey(movieInfo));
	}


	/**
	 *查询电影列表，可以根据电影类型
	 */
	@GetMapping(value = "/findTypeMovie")
	public RestResult findTypeMovie(String type,String stauts){
		return RestResult.ok(movieInfoService.findTypeMovie(type,stauts));
	}
}
