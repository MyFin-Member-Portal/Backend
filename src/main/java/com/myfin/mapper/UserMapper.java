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


    /**
     * Find the user id by user email
     *
     * @param userEmail the user email
     * @return user id
     */
    int findUserIdByEmail(String userEmail);

    /**
     * Add a new user into DB
     * 
     * @param userName the name of user 
     * @param email the email address of user
     * @return null
     */
    int addUser(String userName, String email);

    /**
     *
     * @param phoneNumber   user's phone number
     * @param Address       user's Address
     * @param Gender        user's gender
     * @param Nationality   user's Nationality
     * @param Heritage      user's Heritage
     * @param Language      user's Language
     * @param Name          user's Name
     * @param Email         user's email
     * @param userId        user id
     * @return              return the user id of the current user
     */
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

    /**
     * find is admin status
     * @param userId the user id
     * @return the status of admin
     */
    int findIsAdmin(int userId);

}
