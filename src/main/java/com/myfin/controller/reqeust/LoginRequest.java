package com.myfin.controller.reqeust;

import lombok.Data;

@Data
public class LoginRequest {
    private String userName;
    
    private int userId;
    
    private String password;
}
