package com.myfin.controller.reqeust;

import lombok.Data;

import java.util.Date;

/**
 * @author Zihang Gao
 */
@Data
public class MemberRequest {
    private int userId;
    
    private int memberLevelId;
    
    private long startTime;
    
    private long endTime;
}
