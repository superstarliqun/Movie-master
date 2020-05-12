package com.mapper;

import com.entity.UserRoleMiddle;

public interface UserRoleMiddleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleMiddle record);

    int insertSelective(UserRoleMiddle record);

    UserRoleMiddle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleMiddle record);

    int updateByPrimaryKey(UserRoleMiddle record);
}