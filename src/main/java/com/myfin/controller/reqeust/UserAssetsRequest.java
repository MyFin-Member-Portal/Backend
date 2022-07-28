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

    private String cashSaving;
    private String tarCashBalance;
    private String tarFinBeh;

    private String tarIncBracket;

    private String homeOwner;
    private String liabilities;
    private String liabilitiesBalOwn;

    private String tarLifeStyle;

    private List<Map<String, Object>> assetList;

    private List<Map<String, Object>> tarAssetList;

}
