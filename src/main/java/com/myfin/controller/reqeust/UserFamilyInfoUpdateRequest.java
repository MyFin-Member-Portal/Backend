package com.myfin.controller.reqeust;

import lombok.Data;
/**
 * @author Zihang Gao, yuzhuo ma
 */

@Data
public class UserFamilyInfoUpdateRequest {
    private int user_id;
    private String maritalStatus;
    private String ChildNum;
    private String dependentsNum;
    private String petsNum;
    private String nonDependentsMemNum;
    private String exceptMaterialBills;

}
