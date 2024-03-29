package com.myfin.service.impl;

import com.myfin.mapper.VisualizationMapper;
import com.myfin.service.VisualizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author godfrey
 */
@Slf4j
@Service
public class VisualizationServiceImpl implements VisualizationService {
    @Resource
    VisualizationMapper mapper;
    
    @Override
    public HashMap<String, ArrayList<Object>> findIncome(int userId, int startTime, int endTime, String interval, String type) {
        String sqlInterval = parseInterval(interval);
        List<HashMap<String, Object>> resultIncome = mapper.findIncomeLineChartData(userId, startTime, endTime, sqlInterval, type);
        List<HashMap<String, Object>> resultOutcome = mapper.findOutcomeLineChartData(userId, startTime, endTime, sqlInterval, type);

        HashMap<String, ArrayList<Object>> resultMap = new HashMap<>(3);
        ArrayList<Object> categoryList = new ArrayList<>();
        ArrayList<Object> incomeData = new ArrayList<>();
        ArrayList<Object> outcomeData = new ArrayList<>();

        for (HashMap item:resultIncome) {
            categoryList.add(item.get("intervals"));
            incomeData.add(item.get("incomeData"));
        }
        for (HashMap item:resultOutcome) {
            outcomeData.add(item.get("outcomeData"));
        }
        
        
        resultMap.put("categories", categoryList);
        resultMap.put("incomeData", incomeData);
        resultMap.put("outcomeData", outcomeData);
        return resultMap;
    }

    @Override
    public HashMap<Object, Object> findOutPieChartData(int userId, int startTime, int endTime) {
        List<HashMap<String, Object>> sqlResult = mapper.findOutcomePieChartData(userId, startTime, endTime);
        HashMap<Object, Object> resultMap = new HashMap<>(3);

        for (HashMap item: sqlResult) {
            resultMap.put(item.get("type"), item.get("outcomeData"));
        }
        
        return resultMap;
    }

    @Override
    public  HashMap<Object, Object> findInPieChartData(int userId, int startTime, int endTime) {
        List<HashMap<String, Object>> sqlResult = mapper.findIncomePieChartData(userId, startTime, endTime);
        HashMap<Object, Object> resultMap = new HashMap<>(3);

        for (HashMap item: sqlResult) {
            resultMap.put(item.get("type"), item.get("incomeData"));
        }

        return resultMap;
    }
    
    private String parseInterval(String interval){
        switch (interval){
            case "month":
                return "%b";
            case "year":
                return "%Y";
            case "week":
                return "%w";
            default:
                return null;
        }
    }
}
