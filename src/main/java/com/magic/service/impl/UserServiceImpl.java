package com.magic.service.impl;

import com.magic.dto.User;
import com.magic.mapper.UserMapper;
import com.magic.service.UserService;
import com.magic.utils.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName UserServiceImpl
 * @date 2020/1/17 15:31
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public ApiResult getAllUser() {
        return ApiResult.success(userMapper.selectAll());
    }
}
