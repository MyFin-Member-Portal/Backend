package com.myfin.controller.reqeust;

import lombok.Data;
/**
 * @author Zihang Gao, yuzhuo ma
 */

@Data
public class UserFamilyInfoUpdateRequest {
    private int userId;
    private String maritalStatus;
    private String depNum;
    private String petsNum;
    private String supNonDepNum;
    private String exceptMedBill;

}
