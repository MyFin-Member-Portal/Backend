package com.myfin.controller.reqeust;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="Login Request",description="Login Request description")

public class LoginRequest {
    @ApiModelProperty(value = "userEmail",required = true,example = "Patrick@gmail.com")
    private String userEmail;

//    @ApiModelProperty(value = "userId", example = "1")
//    private int userId;

    @ApiModelProperty(value = "password",required = true,example = "123456")
    private String password;
}
