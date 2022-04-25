package com.myfin.controller.reqeust;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="Login Request",description="Login Request description")

public class LoginRequest {
    @ApiModelProperty(value = "userName",required = true,example = "Patrick")
    private String userName;

    @ApiModelProperty(value = "userId",required = true,example = "1")
    private int userId;

    @ApiModelProperty(value = "password",required = true,example = "123456")
    private String password;
}
