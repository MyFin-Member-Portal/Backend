package com.myfin.service;

import com.myfin.entity.User;


/**
 * @author Zihang Gao 
 */
public interface LoginService{
    /**
     * log the user into system
     * @param userId user id
     * @param password account password
     * @return result of login
     */
    String login(int userId, String password);
    
    User findUserById(int userId);
}
