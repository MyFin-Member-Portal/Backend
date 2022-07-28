package com.myfin.mapper;

import com.myfin.entity.UserAssets;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Yuzhuo Ma
 */
@Mapper
@Repository
public interface UserAssetsMapper {


    /**
     * get the user assets info
     * @param userId
     * @return the UserAssets object
     */
    UserAssets getUserAssets(@Param("userId") int userId);


    /**
     * create user asset info
     * @param userId
     * @return
     */
    int createUserAsset(@Param("userId") int userId);
}
