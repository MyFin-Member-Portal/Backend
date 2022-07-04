package com.myfin.controller.reqeust;
import lombok.Data;
/**
 * @author Zihang Gao, yuzhuo ma
 */

@Data
public class UserChildInfoRequest {
    private int userId;
    private int userChildId;
    private int userChildAge;
    private String userChildEdu;

}
