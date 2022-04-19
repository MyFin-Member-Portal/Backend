package com.myfin.service.impl;

import com.myfin.entity.User;
import com.myfin.mapper.UserMapper;
import com.myfin.service.LoginService;
import com.myfin.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;


/**
 * @author Zihang Gao
 */
@Service
public class LoginServiceImpl implements LoginService {

    private UserMapper userMapper;
    
    @Override
    public String login(int userId, String password) {
        return null;
    }

    @Override
    public User findUserById(int userId) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.findUserById(userId);
    }
}
