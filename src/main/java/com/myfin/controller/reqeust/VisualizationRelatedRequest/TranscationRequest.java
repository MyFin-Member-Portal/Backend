package com.myfin.controller.reqeust.VisualizationRelatedRequest;
import lombok.Data;
/**
 * @author  Yuzhuo ma
 */
@Data
public class TranscationRequest {
    private int userId;
    private int transactionId;
    private String transactionDesc;
    private String transactionCost;
    private String transactionType;
    private long transactionDatetime;

    private int pageNum;
}
