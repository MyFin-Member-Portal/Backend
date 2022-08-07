package com.myfin.controller.reqeust;

import lombok.Data;
/**
 * @author  Yuzhuo ma
 */

@Data
public class UserFamilyInfoUpdateRequest {
    private int userId;
    private String martialStatus;
    private String depNum;
    private String petsNum;
    private String supNonDepNum;
    private String expectMedBill;
    private Object userChildList;
}
