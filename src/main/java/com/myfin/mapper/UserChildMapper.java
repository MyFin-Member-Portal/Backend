package com.myfin.mapper;
import com.myfin.entity.UserChild;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yuzhuo Ma
 */
@Mapper
@Repository
public interface UserChildMapper {

    /**
     *  add a child information  for the user
     * @param userId user's id
     * @param userChildAge      user child age
     * @param userChildEdu      user child education background
     */
    void addUserChild(@Param("userId") int userId, @Param("userChildAge") String userChildAge, @Param("userChildEdu") String userChildEdu);

    /**
     * find the newest child id for the current user
     * @param userId  user's id
     * @return  return child id
     */
    int findMaxUserChildId(@Param("userId") int userId);


    /**
     * get all the child information for the specific user
     * @param userId    user's id
     * @return  return a list of UserChild object
     */
    List<UserChild> getUserChild(@Param("userId") int userId);

    /**
     * get all the child_id for the specific user
     * @param userId   user's id
     * @return  a list of child_id for current user
     */
    List<Integer> getUserChildId(@Param("userId") int userId);

    /**
     * delete specific child for the user
     * @param userId    user id
     * @param userChildId       user child id
     */
    void deleteSpecificUserChild(@Param("userId") int userId, @Param("userChildId") int userChildId);

}
