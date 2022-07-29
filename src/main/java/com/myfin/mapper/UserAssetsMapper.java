package com.myfin.mapper;

import com.myfin.entity.Asset;
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
    Asset getUserAssets(@Param("userId") int userId);


    /**
     * create user asset info
     * @param userId
     * @return
     */
    int createUserAsset(@Param("userId") int userId);

    void updateUserAssets(@Param("userId") int userId,
                          @Param("tarFinBeh") String tarFinBeh,
                          @Param("investment") String investment,
                          @Param("netAssets") String netAssets,
                          @Param("assetList") String assetList,
                          @Param("tarAssets") String tarAssets,
                          @Param("cashSaving") String cashSaving,
                          @Param("tarCashBalance") String tarCashBalance,
                          @Param("tarIncBracket") String tarIncBracket,
                          @Param("homeOwner") String homeOwner,
                          @Param("liabilities") String liabilities,
                          @Param("liabilitiesBalOwn") String liabilitiesBalOwn,
                          @Param("tarLifeStyle") String tarLifeStyle);
}
