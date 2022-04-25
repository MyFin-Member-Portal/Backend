package com.myfin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myfin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Zihang Gao
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    User findUserById(Integer userId);
}
