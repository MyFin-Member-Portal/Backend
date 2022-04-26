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
    private Integer user_id;

    @ApiModelProperty(value = "user_name",required = true,example = "Patrick")
    private String user_name;

    @ApiModelProperty(value = "user_email",required = true,example = "123@gmail.com")
    private String user_email;

    @ApiModelProperty(value = "user_gender",required = true,example = "Male")
    private String user_gender;

    /**
     * user description
     */
    @ApiModelProperty(value = "user_desc",required = true,example = "Male")
    private String user_desc;
}
