package com.jerry.labsystem;

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
class LabsystemApplicationTests {

    @Autowired
    private RightMapper<Right> rightMapper;
    @Autowired
    private RoleMapper<Role> roleMapper;
    @Autowired
    private UserMapper<User> userMapper;
    @Autowired
    private LabMapper<Lab> labMapper;

    @Test
    void testRightMapper() {
        List<Right> rightList = rightMapper.getRightList();
        System.out.println("rightList = " + rightList);
    }

    @Test
    void testRoleMapper() {
        List<Role> roleList = roleMapper.getRoleList();
        System.out.println("roleList = " + roleList);
    }

    @Test
    void testUserMapper() {
        User user = new User();
        user.setUsername("admin");
        List<User> userList = userMapper.getUserList(user);
        System.out.println("userList = " + userList);
    }

    @Test
    void testLabMapper() {
        Lab lab = new Lab();
        List<Lab> labList = labMapper.getLabList(lab);
        System.out.println("labList = " + labList);
    }

    @Test
    void testAddLabMapper() {
        Lab lab = new Lab();
        lab.setTitle("aaa");
        lab.setCapacity(10);
        lab.setLabType(1);
        lab.setCollegeType(2);
        lab.setX(520);
        lab.setY(520);
        labMapper.addLabList(lab);
        testLabMapper();
    }

}
