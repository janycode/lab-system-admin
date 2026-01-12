package com.jerry.labsystem.service;

import java.util.List;

public interface LabService<Lab> {
    List<Lab> getLabList(Lab lab);
    void updateLabList(Lab lab);
    void deleteLabList(Integer id);
    void addLabList(Lab lab);
}
