package com.myfin.controller.reqeust.VisualizationRelatedRequest;

import lombok.Data;
/**
 * @author  Yuzhuo ma
 */
@Data
public class TransactionOutcomeRequest {
    private int userId;

    private int tranOutId;

    private String tranOutDesc;

    private String tranOutCost;

    private String tranOutType;

    private long tranOutDatetime;

    private int pageNum;

    private String tranOutPin;

    private String tranOutFreq;

    private String year;

    private String month;

}
