package com.myfin.controller.reqeust;
import lombok.Data;
/**
 * @author Yuzhuo ma
 */

@Data
public class UserFinancialRequest {
    private int userId;
    private String curFinBeh;
    private String finPos;
    private String empStatus;
    private String budgetInfo;
    private String incBracket;
    private int carNum;
    private String pensioner;
    private String concessionCardHold;
    private String govBenRecipient;
    private String payChiSup;
    private String inLegalProceeding;
    private String funeralPrepaid;
    private String adequateInsCov;
    private String expectInheri;
}
