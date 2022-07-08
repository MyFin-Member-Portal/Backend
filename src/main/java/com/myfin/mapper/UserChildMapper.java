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
    int addUserChild(@Param("userId") int userId, @Param("userChildAge") int userChildAge, @Param("userChildEdu") String userChildEdu);

    int findMaxUserChildId(@Param("userId") int userId);

    int updateUserChildProfile(@Param("userId") int userId, @Param("userChildId") int userChildId, @Param("userChildAge") int userChildAge, @Param("userChildEdu") String userChildEdu);


    List<UserChild> getUserChild(@Param("userId") int userId);

    List<Integer> getUserChildId(@Param("userId") int userId);

}
