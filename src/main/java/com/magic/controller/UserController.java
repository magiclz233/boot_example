package com.magic.controller;

import com.magic.service.UserService;
import com.magic.utils.ApiResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DecimalStyle;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName UserController
 * @date 2020/1/17 15:36
 */

@RestController
@Api(value = "user测试",tags = "user测试使用")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    @Cacheable(value = "boot_example_user",keyGenerator = "myKeyGenerator" )
    public ApiResult getAllUser(){
        return userService.getAllUser();
    }
}
