package com.myfin.controller.reqeust;

import lombok.Data;

/**
 * @author Zihang Gao
 */
@Data
public class UserBusinessRequest {

    private int userId;
    
    private int businessId;

    private String  businessName;

    private String businessProfitLoss;

    private String businessBalanceSheet;
}
