package com.jerry.labsystem.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LabMapper<Lab> {
    List<Lab> getLabList(Lab lab);
    void updateLabList(Lab lab);
    void deleteLabList(Integer id);
    void addLabList(Lab lab);
}
