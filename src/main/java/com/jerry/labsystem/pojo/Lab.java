package com.jerry.labsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lab {
    private Integer id;
    private String title;
    private Integer capacity;
    private Integer labType;
    private Integer collegeType;
    private Integer x;
    private Integer y;
}
