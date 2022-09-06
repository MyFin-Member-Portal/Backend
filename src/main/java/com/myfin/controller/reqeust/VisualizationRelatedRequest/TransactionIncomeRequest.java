package com.myfin.controller.reqeust.VisualizationRelatedRequest;
import lombok.Data;
/**
 * @author  Yuzhuo ma
 */
@Data
public class TransactionIncomeRequest {
    private int userId;

    private int tranIncId;

    private String tranIncDesc;

    private String tranIncCost;

    private String tranIncType;

    private long tranIncDatetime;

    private int pageNum;

    private String tranIncPin;

    private String tranIncFreq;

    private String year;

    private String month;

}
