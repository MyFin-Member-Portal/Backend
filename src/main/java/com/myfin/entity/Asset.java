package com.myfin.entity;


import lombok.Data;
import org.springframework.boot.SpringApplicationRunListener;

import java.util.List;
import java.util.Map;

/**
 * @author Yuzhuo Ma
 */
@Data
public class Asset {
    private int userId;
    private int userAssetId;
    private String assetName;
    private String assetValue;
}
