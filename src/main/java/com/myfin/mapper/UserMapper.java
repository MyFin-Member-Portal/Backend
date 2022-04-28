package com.myfin.mapper;

import com.myfin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Zihang Gao, Yuzhuo Ma
 */
@Mapper
@Repository
public interface UserMapper{
    /**
     * Find the user information by user id 
     * 
     * @param userId the user id
     * @return the data of the user 
     */
    User findUserById(Integer userId);
    User findUserByEmail(String userEmail);

    /**
     * Add a new user into DB
     * 
     * @param userName the name of user 
     * @param email the email address of user
     * @return null
     */
    int addUser(String userName, String email);

    /**
     * find the maximum user id
     * 
     * @return the max id of the user table
     */
    int findMaxId();
}
