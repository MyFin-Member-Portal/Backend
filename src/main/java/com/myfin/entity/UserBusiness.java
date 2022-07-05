package com.myfin.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Zihang Gao, Yuzhuo Ma
 */
@Data
public class UserBusiness {
    @ApiModelProperty(value = "user_id", required = true,example = "1")
    private Integer user_id;

    @ApiModelProperty(value = "business_id", required = true,example = "1")
    private Integer business_id;

    @ApiModelProperty(value = "business_name", required = true,example = "Example business")
    private String  business_name;

    @ApiModelProperty(value = "business_profit_loss", example = "Example business")
    private String  business_profit_loss;

    @ApiModelProperty(value = "business_balance_sheet", example = "Example business")
    private String  business_balance_sheet;
    
}
