package com.myfin.service;

/**
 * @author Zihang Gao 
 */
public interface LoginService {
    /**
     * log the user into system
     * @param userId user id
     * @param password account password
     * @return result of login
     */
    public String login(int userId, String password);
}
