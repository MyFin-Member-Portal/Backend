package com.myfin.service;

import com.myfin.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

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
    String login(int userId, String password);
    
    List<User> findUserById(int userId);
}
