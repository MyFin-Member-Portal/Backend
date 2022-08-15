package com.myfin.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.core.serializer.Serializer;

/**
 * @author Zihang Gao, Yuzhuo Ma
 */
@Data
@ApiModel(value="user object",description="user object description")
public class Account{
    @ApiModelProperty(value = "userid",required = true,example = "1")
    private Integer userId;

    @ApiModelProperty(value = "user_password",required = true,example = "yefbhew+_wd3")
    private String accountPassword;
}
