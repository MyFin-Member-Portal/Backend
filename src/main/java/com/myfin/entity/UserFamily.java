package com.myfin.entity;

import lombok.Data;

/**
 * @author Yuzhuo Ma
 */
@Data
public class UserFamily {

    private int userId;

    private String maritalStatus;

    private String depNum;

    private String petsNum;

    private String supNonDepNum;

    private String exceptMedBill;
}
