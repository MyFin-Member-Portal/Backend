package com.myfin.controller.reqeust;

import lombok.Data;
/**
 * @author  Yuzhuo ma
 */
@Data
public class AssetRequest {
    private int userId;
    private int userAssetId;
    private String assetName;
    private String assetValue;
}
