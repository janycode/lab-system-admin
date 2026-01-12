package com.jerry.labsystem.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RightMapper<Right> {

    List<Right> getRightList();

    boolean updateRightList(Right right);

    void deleteRightList(Integer id);
}
