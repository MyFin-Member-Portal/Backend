package com.myfin.mapper;

import com.myfin.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author Zihang Gao
 */

@Repository
public interface UserMapper {
    User findUserById(Integer userId);
}
