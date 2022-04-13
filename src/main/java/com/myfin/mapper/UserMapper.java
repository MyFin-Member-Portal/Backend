package com.myfin.mapper;

import com.myfin.entity.User;


import java.util.List;

/**
 * @author Zihang Gao
 */

public interface UserMapper {
    List<User> findUserById(int userId);
}
