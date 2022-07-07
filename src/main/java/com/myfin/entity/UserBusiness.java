package com.myfin.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Zihang Gao, Yuzhuo Ma
 */
@Data
public class UserBusiness {
    @ApiModelProperty(value = "user_id", required = true,example = "1")
    private Integer userId;

    @ApiModelProperty(value = "business_id", required = true,example = "1")
    private Integer businessId;

    @ApiModelProperty(value = "business_name", required = true,example = "Example business")
    private String  businessName;

    @ApiModelProperty(value = "business_profit_loss", example = "Example business")
    private String  businessProfitLoss;

    @ApiModelProperty(value = "business_balance_sheet", example = "Example business")
    private String  businessBalanceSheet;
    
}
