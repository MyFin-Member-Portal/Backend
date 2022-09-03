package com.myfin.entity;

import lombok.Data;

/**
 * @author Yuzhuo Ma
 */

@Data
public class TransactionOutcome {
    private int tranOutId;

    private String tranOutDesc;

    private String tranOutCost;

    private String tranOutType;

    private long tranOutDatetime;

    private String tranOutPin;

    private String tranOutFreq;
}
