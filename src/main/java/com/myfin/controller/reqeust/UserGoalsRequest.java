package com.myfin.controller.reqeust;

import lombok.Data;

/**
 * @author Yuzhuo ma
 */

@Data
public class UserGoalsRequest {
    private int userId;
    private String tarIncBracket;
    private String tarAssets;
    private String tarCashBalance;
    private String tarFinBeh;
    private String tarLifeStyle;
}
