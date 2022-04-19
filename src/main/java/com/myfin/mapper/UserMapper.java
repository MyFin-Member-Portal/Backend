package com.myfin.mapper;

import com.myfin.entity.User;

/**
 * @author Zihang Gao
 */

public interface UserMapper {
    User findUserById(Integer userId);
}
