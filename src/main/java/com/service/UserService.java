package com.service;



import com.entity.User;
import com.github.pagehelper.PageInfo;
import com.vo.UserVo;

import java.util.List;

public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserVo userVo);

    int updateByPrimaryKey(User record);

    int register(UserVo user);

    User login(User user);

    PageInfo findUserPage(User user,PageInfo pageInfo);

    User findOneUser(Integer id);

    List<User> defaultUserDropDown();


}

