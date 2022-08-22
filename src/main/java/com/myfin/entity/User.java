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
    private Integer userId;
    
    private String userName;
    
    private String userEmail;
    
    private String userGender;
    
    private String userPhone;

    private String userNationality;

    private String userHeritage;

    private String userLanguage;

    private String userAddress;

    /**
     * user description
     */
    private String userDesc;
    
    private int userIsAdmin;
}
