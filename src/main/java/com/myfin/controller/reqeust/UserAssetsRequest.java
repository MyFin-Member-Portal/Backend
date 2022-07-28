package com.myfin.controller.reqeust;
import lombok.Data;
/**
 * @author Yuzhuo ma
 */

@Data
public class UserAssetsRequest {
    private int userId;
    private String investments;
    private String netAssets;
}
