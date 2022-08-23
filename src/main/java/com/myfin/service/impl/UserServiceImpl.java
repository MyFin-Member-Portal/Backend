package com.myfin.service.impl;


import com.myfin.entity.User;
import com.myfin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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


    @Override
    public int updateUserProfile(String phoneNumber, String Address, String Gender,
                                 String Nationality, String Heritage, String Language,
                                 String Name, String Email, int userId) {
        userMapper.updateUserProfile(
                phoneNumber, Address, Gender, Nationality, Heritage, Language, Name, Email, userId
        );
        return userId;
    }

    @Override
    public Boolean isAdmin(int userId) {
        return userMapper.findIsAdmin(userId) != 0;
    }


}
