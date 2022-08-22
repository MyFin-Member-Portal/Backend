package com.myfin.controller.reqeust;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

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

    private MultipartFile businessBalanceSheet;

    private List<Map<String, Object>> businessList;
    
    private String filePath;
}