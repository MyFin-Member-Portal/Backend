package com.myfin.controller.reqeust;


import lombok.Data;

/**
 * @author Zihang Gao, Yuzhuo ma
 */

@Data
public class UserInfoUpdateRequest {
    private int userId;

    private String userName;

    private String userEmail;

    private String userPhoneNumber;

    private String userAddress;

    private String userGender;

    private String userNationality;

    private String userHeritage;

    private String userLanguage;

}
