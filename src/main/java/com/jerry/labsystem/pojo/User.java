package com.jerry.labsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer roleId;
    private Integer isDefault;
    private Role role;
    /**
     * 补充 token 字段
     */
    private String token;
}
