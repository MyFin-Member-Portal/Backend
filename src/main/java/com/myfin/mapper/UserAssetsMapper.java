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


    String getUserAssetsInvestment(@Param("userId") int userId);

    List<Map<String, Object>> getUserAssetsAssetList(@Param("userId") int userId);

    List<Map<String, Object>> getUserAssetsTarAssetList(@Param("userId") int userId);

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
