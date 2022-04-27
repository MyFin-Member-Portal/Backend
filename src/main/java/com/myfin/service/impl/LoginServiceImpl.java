package com.myfin.service.impl;

import com.myfin.entity.User;
import com.myfin.mapper.AccountMapper;
import com.myfin.mapper.UserMapper;
import com.myfin.service.LoginService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Zihang Gao
 */
@Service
public class LoginServiceImpl implements LoginService {
    
    @Resource
    private UserMapper userMapper;
    
    @Resource
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
    public int addUser(String userName, String email, String password) {
        // add a new user
        userMapper.addUser(userName, email);
        // get the user id of this user
        int maxUserId = userMapper.findMaxId();
        accountMapper.addPassword(maxUserId, password);
        return maxUserId;
    }
}
