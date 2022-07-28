package com.myfin.mapper;

import com.myfin.entity.UserFinancial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author  Yuhzhuo Ma
 */
@Mapper
@Repository
public interface UserFinancialMapper {

    /**
     * get the user finicial information
     * @param userId
     * @return UserFinancial object
     */
    UserFinancial getUserFinancialInfo(@Param("userId") int userId);


    /**
     * post/update the new info for user finicial module
     * @param userId
     * @param curFinBeh
     * @param finPos
     * @param empStatus
     * @param budgetInfo
     * @param incBracket
     * @param carNum
     * @param pensioner
     * @param concessionCardHold
     * @param govBenRecipient
     * @param payChiSup
     * @param inLegalProceeding
     * @param funeralPrepaid
     * @param adequateInsCov
     * @param expectInheri
     */
    void updateUserFinancialInfo(@Param("userId") int userId,
                                 @Param("curFinBeh") String curFinBeh,
                                 @Param("finPos") String finPos,
                                 @Param("empStatus") String empStatus,
                                 @Param("budgetInfo") String budgetInfo,
                                 @Param("incBracket") String incBracket,
                                 @Param("carNum") int carNum,
                                 @Param("pensioner") String pensioner,
                                 @Param("concessionCardHold") String concessionCardHold,
                                 @Param("govBenRecipient") String govBenRecipient,
                                 @Param("payChiSup") String payChiSup,
                                 @Param("inLegalProceeding")  String inLegalProceeding,
                                 @Param("funeralPrepaid") String funeralPrepaid,
                                 @Param("adequateInsCov") String adequateInsCov,
                                 @Param("expectInheri") String expectInheri);

    void createUserFinancialInfo(@Param("userId") int userId);
}
