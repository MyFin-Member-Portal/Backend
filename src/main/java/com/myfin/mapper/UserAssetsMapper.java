package com.myfin.mapper;

import com.myfin.entity.UserAsset;
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
    String getUserAssets(@Param("userId") int userId);


    /**
     * create user asset info
     * @param userId user id
     * @return null
     */
    void createUserAsset(@Param("userId") int userId);

    void updateUserAssets(@Param("userId") int userId,

                          @Param("investmentString") String investmentString,

                          @Param("netAssets") String netAssets,

                          @Param("assetListString") String assetListString,

                          @Param("cashSaving") String cashSaving,

                          @Param("homeOwner") String homeOwner,

                          @Param("liabilities") String liabilities,

                          @Param("liabilitiesBalOwn") String liabilitiesBalOwn,

                          @Param("tarIncBracket") String tarIncBracket,

                          @Param("tarAssetListString") String tarAssetListString,

                          @Param("tarCashBalance") String tarCashBalance,

                          @Param("tarFinBeh") String tarFinBeh,

                          @Param("tarLifeStyle") String tarLifeStyle
    );
}
