package com.myfin.service;

import com.myfin.entity.Account;
import com.myfin.entity.User;


/**
 * @author Zihang Gao, Yuhzhuo Ma
 */
public interface LoginService{
    /**
     * log the user into system
     * @return result of login
     */

    int findUserByEmail(String userEmail);

    Account findAccountByUserId(int userId);

    /**
     * find the user information from the user id
     * 
     * @param userId user id
     * @return the user information 
     */
    User findUserById(int userId);

    int addUser(String userName, String email, String password);
}
