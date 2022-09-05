package com.myfin.entity;


import lombok.Data;

/**
 * @author Yuzhuo Ma
 */

@Data
public class TransactionIncome {
    private int tranIncId;

    private String tranIncDesc;

    private String tranIncCost;

    private String tranIncType;

    private long tranIncDatetime;

    private String tranIncPin;

    private String tranIncFreq;

    private int totalPageNum;
}
