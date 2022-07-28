package com.myfin.entity;


import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Yuzhuo Ma
 */
@Data
public class UserAssets {
    private int userId;
    private List<String> investment;
    private String netAssets;

    private Map<Integer, String> assetList;
    private Map<Integer, String> tarAssets;

    private String cashSaving;
    private String tarCashBalance;

    private String tarIncBracket;

    private String homeOwner;
    private String liabilities;
    private String liabilitiesBalOwn;

    private String tarLifeStyle;
}
