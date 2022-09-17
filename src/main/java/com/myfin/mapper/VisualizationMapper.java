package com.myfin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


/**
 * @author Zihang Gao
 */
@Mapper
@Repository
public interface VisualizationMapper {
    List<HashMap<String, Object>> findIncomeLineChartData(int userId, int startTime, int endTime, String interval, String type);

    List<HashMap<String, Object>> findOutcomeLineChartData(int userId, int startTime, int endTime, String interval, String type);
    
    List<HashMap<String, Object>> findOutcomePieChartData(int userId, int startTime, int endTime);

    List<HashMap<String, Object>> findIncomePieChartData(int userId, int startTime, int endTime);
}
