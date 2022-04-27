package com.myfin.mapper;


import com.myfin.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Zihang Gao, Yuzhuo Ma
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

    /**
     * find password by the user id
     * @param userId user id
     */
    Account findPasswordByUserId(int userId);
}
