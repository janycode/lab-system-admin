package com.jerry.labsystem.service;

import java.util.List;

public interface RoleService<Role> {
    List<Role> getRoleList();
    void updateRoleList(Role role);
    void deleteRoleList(Integer id);
}
