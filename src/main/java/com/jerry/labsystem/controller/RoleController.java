package com.jerry.labsystem.controller;

import com.jerry.labsystem.pojo.Role;
import com.jerry.labsystem.service.RoleService;
import com.jerry.labsystem.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/roles")
public class RoleController {

    @Autowired
    private RoleService<Role> roleService;

    @GetMapping("/list")
    public List<Role> getRoleList() {
        return roleService.getRoleList();
    }

    // /admin/rols/3
    @PutMapping(value = "/{id}")
    public ResultObj updateRoleList(@PathVariable Integer id, @RequestBody Role role) {
        try {
            role.setId(id);
            roleService.updateRoleList(role);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.UPDATE_ERROR;
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResultObj deleteRoleList(@PathVariable Integer id) {
        try {
            roleService.deleteRoleList(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.DELETE_ERROR;
        }
    }

}
