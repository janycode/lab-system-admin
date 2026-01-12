package com.jerry.labsystem.service.impl;

import com.jerry.labsystem.dao.RightMapper;
import com.jerry.labsystem.pojo.Right;
import com.jerry.labsystem.service.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightServiceImpl implements RightService<Right> {

    @Autowired
    private RightMapper<Right> rightMapper;

    @Override
    public List<Right> getRightList() {
        return rightMapper.getRightList();
    }

    @Override
    public void updateRightList(Right right) {
        rightMapper.updateRightList(right);
    }

    @Override
    public void deleteRightList(Integer id) {
        rightMapper.deleteRightList(id);
    }
}
