package com.myfin.mapper;

import com.myfin.entity.UserAsset;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
    UserAsset getUserAssets(@Param("userId") int userId);



    Map<String, Object> getUserAssetListInfo(@Param("userId") int userId);


    /**
     * create user asset info
     * @param userId user id
     * @return null
     */
    void createUserAsset(@Param("userId") int userId);

    void updateUserAssets(@Param("userId") int userId,

                          @Param("investmentString") String investmentString,

                          @Param("netAssets") String netAssets,

                          @Param("assetNameString") String assetNameString,

                          @Param("assetValueString") String assetValueString,

                          @Param("cashSaving") String cashSaving,

                          @Param("homeOwner") String homeOwner,

                          @Param("liabilities") String liabilities,

                          @Param("liabilitiesBalOwn") String liabilitiesBalOwn,

                          @Param("tarIncBracket") String tarIncBracket,

                          @Param("tarAssetNameString") String tarAssetNameString,

                          @Param("tarAssetValueString") String tarAssetValueString,

                          @Param("tarCashBalance") String tarCashBalance,

                          @Param("tarFinBeh") String tarFinBeh,

                          @Param("tarLifeStyle") String tarLifeStyle
    );

}
