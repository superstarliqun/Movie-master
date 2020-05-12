package com.mapper;

import com.entity.User;import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int register(User user);

    User login(User user);

    List<User> findPageMovie(User user);

    User findOneUser(Integer id);

    int exitName(String name);

    int fingUserexit(User user);

    List<User> defaultUserDropDown();
}