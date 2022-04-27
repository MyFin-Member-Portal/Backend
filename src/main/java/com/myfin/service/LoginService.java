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

    /**
     * find the user information from the user id
     * 
     * @param userId user id
     * @return the user information 
     */
    User findUserById(int userId);

    int addUser(String userName, String email, String password);
}
