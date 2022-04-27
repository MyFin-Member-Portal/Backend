package com.myfin.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Yuzhuo Ma
 */
public class Account {
    @ApiModelProperty(value = "userid",required = true,example = "1")
    private Integer user_id;

    @ApiModelProperty(value = "password", example = "abc123")
    private String account_password;
}
