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

    User findUserByEmail(String userEmail);

    Account findAccountByUserId(int userId);
}
