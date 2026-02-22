package com.jerry.labsystem.service.impl;

import com.jerry.labsystem.dao.RoleMapper;
import com.jerry.labsystem.pojo.Role;
import com.jerry.labsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色服务impl
 *
 * @author Jerry(姜源)
 * @since 2026/02/22
 */
@Service
public class RoleServiceImpl implements RoleService<Role> {
    @Resource
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
