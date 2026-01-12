package com.jerry.labsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Right {
    private Integer id;
    private String title;
    private String icon;
    private String path;
    private List<Right> children;
}
