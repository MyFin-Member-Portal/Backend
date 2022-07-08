package com.myfin.mapper;

import com.myfin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
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
    
    int findUserIdByEmail(String userEmail);

    /**
     * Add a new user into DB
     * 
     * @param userName the name of user 
     * @param email the email address of user
     * @return null
     */
    int addUser(String userName, String email);

    int updateUserProfile(@Param("phoneNumber") String phoneNumber,
                          @Param("Address") String Address,
                          @Param("Gender") String Gender,
                          @Param("Nationality") String Nationality,
                          @Param("Heritage") String Heritage,
                          @Param("Language") String Language,
                          @Param("Name") String Name,
                          @Param("Email") String Email,
                          @Param("userId") int userId);
    /**
     * find the maximum user id
     * 
     * @return the max id of the user table
     */
    int findMaxId();




}
