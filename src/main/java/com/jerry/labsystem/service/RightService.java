package com.jerry.labsystem.service;

import java.util.List;

public interface RightService<Right> {
    List<Right> getRightList();

    void updateRightList(Right right);

    void deleteRightList(Integer id);
}
