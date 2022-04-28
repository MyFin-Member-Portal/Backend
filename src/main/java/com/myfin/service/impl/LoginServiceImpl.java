package com.myfin.service.impl;

import com.myfin.entity.Account;
import com.myfin.entity.User;
import com.myfin.mapper.AccountMapper;
import com.myfin.mapper.UserMapper;
import com.myfin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Zihang Gao, Yuhzhuo Ma
 */
@Service
public class LoginServiceImpl implements LoginService {
    
    @Resource
    private UserMapper userMapper;
    
    @Resource
    private AccountMapper accountMapper;
    
    @Override
    public User findUserByEmail(String userEmail) {
        return userMapper.findUserByEmail(userEmail);
    }

    @Override
    public User findUserById(int userId) {
        return userMapper.findUserById(userId);
    }
    
    @Override
    public Account findAccountByUserId(int userId) {
        return accountMapper.findAccountByUserId(userId);
    }

    @Override
    public int addUser(String userName, String email, String password) {
        // add a new user
        userMapper.addUser(userName, email);
        // get the user id of this user
        int maxUserId = userMapper.findMaxId();
        accountMapper.addPassword(maxUserId, password);
        return maxUserId;
    }
}
