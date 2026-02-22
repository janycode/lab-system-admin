package com.jerry.labsystem.controller;

import com.jerry.labsystem.pojo.Lab;
import com.jerry.labsystem.service.LabService;
import com.jerry.labsystem.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 实验室接口
 *
 * @author Jerry(姜源)
 * @since 2026/02/22
 */
@RestController
@RequestMapping("/admin/labs")
public class LabController {
    @Resource
    private LabService<Lab> labService;

    @GetMapping("/list")
    public List<Lab> getLabList(Lab lab) {
        return labService.getLabList(lab);
    }

    @PostMapping("/add")
    public ResultObj addLabList(@RequestBody Lab lab) {
        try {
            labService.addLabList(lab);
            return ResultObj.ADD_SUCCESS;
        } catch (RuntimeException e) {
            return ResultObj.ADD_ERROR;
        }
    }

    // /admin/roles/3
    @PutMapping(value = "/{id}")
    public ResultObj updateLabList(@PathVariable Integer id, @RequestBody Lab lab) {
        try {
            lab.setId(id);
            labService.updateLabList(lab);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.UPDATE_ERROR;
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResultObj deleteLabList(@PathVariable Integer id) {
        try {
            labService.deleteLabList(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.DELETE_ERROR;
        }
    }

}
