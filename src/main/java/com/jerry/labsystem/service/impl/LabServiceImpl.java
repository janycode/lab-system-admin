package com.jerry.labsystem.service.impl;

import com.jerry.labsystem.dao.LabMapper;
import com.jerry.labsystem.pojo.Lab;
import com.jerry.labsystem.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 实验室服务 impl
 *
 * @author Jerry(姜源)
 * @since 2026/02/22
 */
@Service
public class LabServiceImpl implements LabService<Lab> {
    @Resource
    private LabMapper<Lab> labMapper;

    @Override
    public List<Lab> getLabList(Lab lab) {
        return labMapper.getLabList(lab);
    }

    @Override
    public void updateLabList(Lab lab) {
        labMapper.updateLabList(lab);
    }

    @Override
    public void deleteLabList(Integer id) {
        labMapper.deleteLabList(id);
    }

    @Override
    public void addLabList(Lab lab) {
        labMapper.addLabList(lab);
    }
}
