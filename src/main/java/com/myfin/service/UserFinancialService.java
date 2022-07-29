package com.myfin.service;

import com.myfin.entity.UserFinancial;

public interface UserFinancialService {

    /**
     * get the user basic finical information
     * @param userId
     * @return
     */
    UserFinancial getUserFinicialInfoService(int userId);

    /**
     * update the financial information for the user
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
    void updateUserFinicialInfoService(int userId, String curFinBeh, String finPos, String empStatus, String budgetInfo, String incBracket, int carNum, String pensioner, String concessionCardHold, String govBenRecipient, String payChiSup, String inLegalProceeding, String funeralPrepaid, String adequateInsCov, String expectInheri);

    /**
     * create the user finicial information table for user
     * ( create when user register, so no info needed)
     * @param userId
     */
    void createUserFinancialInfoService(int userId);
}
