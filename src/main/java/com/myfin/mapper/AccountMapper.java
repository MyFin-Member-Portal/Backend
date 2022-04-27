package com.myfin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @author Yuzhuo Ma
 */
@Mapper
@Repository
public interface AccountMapper {
    
    /**
     * add the password of the user
     * @param userId user id
     * @param password the password of the user
     */
    void addPassword(@Param("userId") int userId, @Param("password") String password);
}
