package com.myfin.controller.reqeust;

import lombok.Data;

import java.util.List;
import java.util.Map;

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

    private List<Map<String, Object>> businessList;
}
