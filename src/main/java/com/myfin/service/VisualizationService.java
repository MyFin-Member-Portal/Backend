package com.myfin.service;

import com.myfin.entity.TransactionIncome;
import com.myfin.entity.TransactionOutcome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author godfrey
 */
public interface VisualizationService<T> {
    HashMap<String, ArrayList<Object>> findIncome(int userId, int startTime, int endTime, String interval, String type);

    HashMap<String, ArrayList<Object>> findOutPieChartData(int userId, int startTime, int endTime);
    
}
