package com.myfin.controller.reqeust;


import lombok.Data;

/**
 * @author Zihang Gao, yuzhuo ma
 */

@Data
public class UserInfoUpdateRequest {
    private String userPhoneNumber;
    private String userAddress;
    private String userGender;
    private String userNationality;
    private String userHeritage;
    private String userLanguage;

    private String userName;
    private int userId;
    private String userEmail;



}
