package com.jerry.labsystem;

import com.jerry.labsystem.config.JwtConfig;
import com.jerry.labsystem.dao.LabMapper;
import com.jerry.labsystem.dao.RightMapper;
import com.jerry.labsystem.dao.RoleMapper;
import com.jerry.labsystem.dao.UserMapper;
import com.jerry.labsystem.pojo.Lab;
import com.jerry.labsystem.pojo.Right;
import com.jerry.labsystem.pojo.Role;
import com.jerry.labsystem.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JwtTests {

    @Autowired
    private JwtConfig jwtConfig;

    /**
     * 测试JWT
     */
    @Test
    void testJwt() throws InterruptedException {
        // 生成token
        String token = jwtConfig.createToken("adminXxx");
        System.out.println("token = " + token);

        System.out.println("subject1 = " + jwtConfig.getSubject(token)); //subject1 = adminXxx

        Thread.sleep(6000); // application.yml 中配置是 60s 过期
        // 通过 token 解密出内容
        try {
            System.out.println("subject2 = " + jwtConfig.getSubject(token));
        } catch (Exception e) {
            System.out.println("token 已过期：" + e.getMessage());
        }
    }


}
