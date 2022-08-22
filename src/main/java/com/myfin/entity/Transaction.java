package com.myfin.entity;


import lombok.Data;

/**
 * @author Yuzhuo Ma
 */

@Data
public class Transaction {
    private int transactionId;

    private String transactionDesc;

    private String transactionCost;

    private String transactionType;

    private long transactionDatetime;
}
