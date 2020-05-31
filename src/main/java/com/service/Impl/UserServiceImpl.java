package com.service.Impl;

import com.entity.UserRoleMiddle;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UserRoleMiddleMapper;
import com.util.MD5Util;
import com.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMiddleMapper userRoleMiddleMapper;



    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer id) {
        userRoleMiddleMapper.deleteByPrimaryKey(id);
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserVo userVo) {
        User record = new User();
        BeanUtils.copyProperties(userVo,record);
        if(record.getOld_password()!=null&&record.getOld_password()!=""&&!record.getOld_password().equals("bW92aWU=")){
            record.setOld_password(MD5Util.getMD5(record.getOld_password()));
            if(userMapper.fingUserexit(record)>0){
                record.setPassword(MD5Util.getMD5(record.getPassword()));
                return userMapper.updateByPrimaryKeySelective(record);
            }else{
                return 0;
            }
        }else{
            if(record.getOld_password().equals("bW92aWU=")){
                if(record.getPassword()!=null&&record.getPassword()!=""){
                    record.setPassword(MD5Util.getMD5(record.getPassword()));
                }
            }
            return userMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional
    public int register(UserVo user) {
        try {
            User Newuser = new User();
            if(user.getUserName()!=null){
                Newuser.setUserName(user.getUserName());
            }
            if(user.getPhone()!=null){
                Newuser.setPhone(user.getPhone());
            }
            if(user.getEmail()!=null){
                Newuser.setEmail(user.getEmail());
            }
            if(user.getImg()!=null){
                Newuser.setImg(user.getImg());
            }
            if(user!=null&&userMapper.exitName(user.getUserName())==0){
                //添加用户表
                Newuser.setCreateTime(new Date());
                Newuser.setPassword(MD5Util.getMD5(user.getPassword()));
               int id =  userMapper.register(Newuser);
                //添加中间表
                UserRoleMiddle userRoleMiddle = new UserRoleMiddle();
                userRoleMiddle.setUserId(Newuser.getId());
                userRoleMiddle.setRoleId(user.getRoleId());
                return userRoleMiddleMapper.insert(userRoleMiddle);
            }else{
                return -1;
            }
        }catch (Exception e){
                e.printStackTrace();
                return -1;
        }
    }

    @Override
    public User login(User user) {
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        return userMapper.login(user);
    }

    @Override
    public PageInfo findUserPage(User user, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<User> pageUser = userMapper.findPageMovie(user);
        return new PageInfo(pageUser);
    }

    @Override
    public User findOneUser(Integer id) {
        return userMapper.findOneUser(id);
    }

    @Override
    public List<User> defaultUserDropDown() {
        return userMapper.defaultUserDropDown();
    }
}
