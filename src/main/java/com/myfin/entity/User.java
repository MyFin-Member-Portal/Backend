package com.myfin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zihang Gao
 */
@Data
public class User {
    private Integer user_id;
    private String user_name;
    private String user_email;
    private String user_gender;

    /**
     * user description
     */
    private String user_desc;
}
