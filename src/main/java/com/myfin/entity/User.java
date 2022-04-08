package com.myfin.entity;

import java.io.Serializable;

/**
 * @author Zihang Gao
 */
public class User implements Serializable {
    private int userId;
    private String userName;
    private String userEmail;
    private String userGender;

    /**
     * user description
     */
    private String userDesc;
}
