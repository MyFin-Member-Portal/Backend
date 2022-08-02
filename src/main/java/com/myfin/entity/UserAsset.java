package com.myfin.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Yuzhuo Ma
 */
@Data
public class UserAsset {
    private int userId;

    private List<String> investment;
    private String netAssets;
    private List<String> assetName;
    private List<String> assetValue;
    private String cashSaving;
    private String homeOwner;
    private String liabilities;
    private String liabilitiesBalOwn;
    private String tarIncBracket;

    private List<String> tarAssetName;
    private List<String> tarAssetValue;

    private String tarCashBalance;
    private String tarFinBeh;
    private String tarLifeStyle;

}
