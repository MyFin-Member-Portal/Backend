package com.myfin.service;


/**
 * @author Zihang Gao, Yuhzhuo Ma
 */
public interface LoginService{
    /**
     * log the user into system
     * @return result of login
     */

    int findUserByEmail(String userEmail);

    String getAccountPassword(int userId);

    String getMd5Password(String password);


    int addUser(String userName, String email, String password);
}
