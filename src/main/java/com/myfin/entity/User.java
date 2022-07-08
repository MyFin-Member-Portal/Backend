package com.myfin.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Zihang Gao, Yuzhuo Ma
 */
@Data
@ApiModel(value="user object",description="user object description")
public class User {
    @ApiModelProperty(value = "userid",required = true,example = "1")
    private Integer userId;

    @ApiModelProperty(value = "user_name",required = true,example = "Patrick")
    private String userName;

    @ApiModelProperty(value = "user_email",required = true,example = "123@gmail.com")
    private String userEmail;

    @ApiModelProperty(value = "user_gender",required = true,example = "Male")
    private String userGender;

    @ApiModelProperty(value = "user_phone",required = true,example = "0451998888")
    private String userPhone;

    private String userNationality;

    private String userHeritage;

    private String userLanguage;

    private String userAddress;

    /**
     * user description
     */
    @ApiModelProperty(value = "user_desc",required = true,example = "this is married person")
    private String userDesc;
}
