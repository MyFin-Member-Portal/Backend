package com.myfin.service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author godfrey
 */
public interface VisualizationService<T> {
    HashMap<String, ArrayList<Object>> findIncome(int userId, int startTime, int endTime, String interval, String type);

    HashMap<Object, Object> findOutPieChartData(int userId, int startTime, int endTime);

    HashMap<Object, Object> findInPieChartData(int userId, int startTime, int endTime);
}
