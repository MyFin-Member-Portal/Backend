package com.myfin.service.impl;

import com.myfin.entity.User;
import com.myfin.mapper.UserMapper;
import com.myfin.service.LoginService;
import com.myfin.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Zihang Gao
 */
@Service
public class LoginServiceImpl implements LoginService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public String login(int userId, String password) {
        return null;
    }

    @Override
    public User findUserById(int userId) {
        return userMapper.findUserById(userId);
    }
}
