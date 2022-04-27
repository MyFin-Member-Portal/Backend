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
    User findUserById(Integer userId);
    User findUserByEmail(String userEmail);
}
