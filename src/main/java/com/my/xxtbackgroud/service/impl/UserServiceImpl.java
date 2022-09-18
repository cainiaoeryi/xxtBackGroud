package com.my.xxtbackgroud.service.impl;

import com.my.xxtbackgroud.mapper.UserMapper;
import com.my.xxtbackgroud.pojo.userBean;
import com.my.xxtbackgroud.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    final
    UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public userBean login(String stuid) {

        return userMapper.checkUser(stuid);
    }
}
