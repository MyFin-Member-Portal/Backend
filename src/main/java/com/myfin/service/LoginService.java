package com.myfin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myfin.entity.User;


/**
 * @author Zihang Gao 
 */
public interface LoginService extends IService<User> {
    /**
     * log the user into system
     * @param userId user id
     * @param password account password
     * @return result of login
     */
    String login(int userId, String password);
    
    User findUserById(int userId);
}
