package com.jerry.labsystem.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper<Role> {
    List<Role> getRoleList();
    void updateRoleList(Role role);
    void deleteRoleList(Integer id);
}
