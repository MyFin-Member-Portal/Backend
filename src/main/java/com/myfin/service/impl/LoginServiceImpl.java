package com.myfin.service.impl;

import ch.qos.logback.classic.Logger;
import com.myfin.entity.Account;
import com.myfin.entity.User;
import com.myfin.mapper.AccountMapper;
import com.myfin.mapper.UserMapper;
import com.myfin.service.LoginService;
import com.myfin.util.Md5Encryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Zihang Gao, Yuhzhuo Ma
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    
    @Resource
    private UserMapper userMapper;
    
    @Resource
    private AccountMapper accountMapper;
    
    @Override
    public int findUserByEmail(String userEmail) {
        return userMapper.findUserIdByEmail(userEmail);
    }

    @Override
    public User findUserById(int userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public String getMd5Password(String password) {

        return  Md5Encryption.encode(password);
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
        String cipherText = Md5Encryption.encode(password);
        log.info("Cipher text of password: " + cipherText);
        accountMapper.addPassword(maxUserId, cipherText);
        return maxUserId;
    }
}
