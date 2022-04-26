package com.myfin.mapper;

import com.myfin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Zihang Gao
 */
@Mapper
@Repository
public interface UserMapper{
    User findUserById(Integer userId);
}
