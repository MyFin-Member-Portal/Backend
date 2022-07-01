package com.myfin.service.impl;

import com.myfin.entity.User;
import com.myfin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.myfin.entity.User;
import com.myfin.service.UserService;

/**
 * @author Zihang Gao, Yuhzhuo Ma
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserById(int userId) {
        return userMapper.findUserById(userId);
    }
}
