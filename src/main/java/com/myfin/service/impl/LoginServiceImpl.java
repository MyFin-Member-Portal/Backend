package com.myfin.service.impl;

import com.myfin.entity.Account;
import com.myfin.entity.User;
import com.myfin.mapper.AccountMapper;
import com.myfin.mapper.UserMapper;
import com.myfin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Zihang Gao, Yuhzhuo Ma
 */
@Service
public class LoginServiceImpl implements LoginService {
    
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AccountMapper accountMapper;
    
    @Override
    public String login(int userId, String password) {
        return null;
    }

    @Override
    public User findUserById(int userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public User findUserByEmail(String userEmail) {
        return userMapper.findUserByEmail(userEmail);
    }

    @Override
    public Account findPasswordByUserId(int userId) {
        System.out.println("-------------"+userId);
        return accountMapper.findPasswordByUserId(userId);
    }
}
