package com.myfin.controller.VisualizationController.request;

import lombok.Data;

/**
 * @author Zihang Gao
 */
@Data
public class VisualizationRequest {
    private int userId;
    
    private String type;

    private String[] typeList;

    private String interval;
    
    private int startTime;

    private int endTime;
}
