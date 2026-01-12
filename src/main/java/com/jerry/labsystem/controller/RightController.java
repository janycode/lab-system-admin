package com.jerry.labsystem.controller;

import com.jerry.labsystem.pojo.Right;
import com.jerry.labsystem.service.RightService;
import com.jerry.labsystem.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/rights")
public class RightController {

    @Autowired
    private RightService<Right> rightService;
    @GetMapping("/list")
    public List<Right> getRightList() {
        return rightService.getRightList();
    }

    // /admin/rights/3
    @PutMapping(value = "/{id}")
    public ResultObj updateRightList(@PathVariable Integer id, @RequestBody Right right) {
        try {
            right.setId(id);
            rightService.updateRightList(right);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.UPDATE_ERROR;
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResultObj deleteRightList(@PathVariable Integer id) {
        try {
            rightService.deleteRightList(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.DELETE_ERROR;
        }
    }

}
