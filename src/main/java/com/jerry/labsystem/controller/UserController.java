package com.jerry.labsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jerry.labsystem.config.JwtConfig;
import com.jerry.labsystem.pojo.User;
import com.jerry.labsystem.service.UserService;
import com.jerry.labsystem.utils.ResultObj;
import com.jerry.labsystem.utils.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserService<User> userService;
    @Autowired
    private JwtConfig jwtConfig;

    @GetMapping("/list")
    public List<User> getUserList(User user) {
        return userService.getUserList(user);
    }

    @GetMapping("/listPage")
    public PageInfo<User> getUserListPage(User user,
                                          @RequestParam(defaultValue = "1") Integer pageNum,
                                          @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        //添加 PageHelper 的页码和页长的注入，后面sql查询时会自动追加 limit 页码,页长
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userService.getUserList(user);
        //返回PageInfo对象
        return new PageInfo<>(userList);
    }

    @PostMapping("/add")
    public ResultObj addUserList(@RequestBody User user) {
        try {
            userService.addUserList(user);
            return ResultObj.ADD_SUCCESS;
        } catch (RuntimeException e) {
            return ResultObj.ADD_ERROR;
        }
    }

    // /admin/rols/3
    @PutMapping(value = "/{id}")
    public ResultObj updateUserList(@PathVariable Integer id, @RequestBody User user) {
        try {
            user.setId(id);
            userService.updateUserList(user);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.UPDATE_ERROR;
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResultObj deleteUserList(@PathVariable Integer id) {
        try {
            userService.deleteUserList(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.DELETE_ERROR;
        }
    }

    @PostMapping("/login")
    public ResultObj login(@RequestBody User user) {
        try {
            List<User> userList = userService.getUserList(user);
            if (CollectionUtils.isEmpty(userList)) {
                throw new RuntimeException();
            }
            //登陆用户
            User loginUser = userList.get(0);
            String token = jwtConfig.createToken(loginUser.getUsername());
            loginUser.setToken(token);

            return new ResultObj(SysConstant.CODE_SUCCESS, SysConstant.LOGIN_SUCCESS, loginUser);
        } catch (RuntimeException e) {
            return new ResultObj(SysConstant.CODE_ERROR, SysConstant.LOGIN_ERROR);
        }
    }

}
