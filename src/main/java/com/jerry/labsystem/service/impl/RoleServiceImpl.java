package com.jerry.labsystem.service.impl;

import com.jerry.labsystem.dao.RoleMapper;
import com.jerry.labsystem.pojo.Role;
import com.jerry.labsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService<Role> {
    @Autowired
    private RoleMapper<Role> roleMapper;

    @Override
    public List<Role> getRoleList() {
        return roleMapper.getRoleList();
    }

    @Override
    public void updateRoleList(Role role) {
        roleMapper.updateRoleList(role);
    }

    @Override
    public void deleteRoleList(Integer id) {
        roleMapper.deleteRoleList(id);
    }
}
