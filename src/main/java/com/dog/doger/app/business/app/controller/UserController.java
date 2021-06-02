package com.dog.doger.app.business.app.controller;

import com.dog.doger.app.business.app.service.system.UserService;
import com.dog.doger.app.business.util.data.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: UserController
 * @Description: 用户控制层
 * @Date: 2020/4/21 14:27
 */
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ApiResult addUser(
            @RequestParam(value = "oid") String oid) {
        return userService.addUser(oid);
    }

}
