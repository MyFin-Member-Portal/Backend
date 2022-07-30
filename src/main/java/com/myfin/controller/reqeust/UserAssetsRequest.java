package com.myfin.controller.reqeust;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Yuzhuo ma
 */

@Data
public class UserAssetsRequest {
    private int userId;

    private List<String> investment;
    private String netAssets;
    private List<Map<String, String>> assetList;
    private String cashSaving;
    private String homeOwner;
    private String liabilities;
    private String liabilitiesBalOwn;
    private String tarIncBracket;
    private List<Map<String, String>> tarAssetList;
    private String tarCashBalance;
    private String tarFinBeh;
    private String tarLifeStyle;
}
