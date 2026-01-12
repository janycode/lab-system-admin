package com.jerry.labsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private Integer labId;
    private Date bookTime;
    private Integer bookClass;
    private String bookUsername;
    private String bookReason;
    private Integer bookState;
    private Lab lab;
}
