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
        List<HashMap<String, Object>> result = mapper.findLineChartData(userId, startTime, endTime, interval, type);
        log.info(result.toString());
        HashMap<String, ArrayList<Object>> resultMap = new HashMap<>(3);
        ArrayList<Object> categoryList = new ArrayList<>();
        ArrayList<Object> incomeData = new ArrayList<>();
        ArrayList<Object> outcomeData = new ArrayList<>();

        for (HashMap item:result) {
            categoryList.add(item.get("months"));
            incomeData.add(item.get("incomeData"));
            outcomeData.add(item.get("outcomeData"));
        }
        
        resultMap.put("categories", categoryList);
        resultMap.put("incomeData", incomeData);
        resultMap.put("outcomeData", outcomeData);
        return resultMap;
    }

    @Override
    public HashMap<String, ArrayList<Object>> findOutPieChartData(int userId, int startTime, int endTime) {
        List<HashMap<String, Object>> sqlResult = mapper.findOutcomePieChartData(userId, startTime, endTime);
        HashMap<String, ArrayList<Object>> resultMap = new HashMap<>(3);

        ArrayList<Object> typeList = new ArrayList<>();
        ArrayList<Object> outcomeData = new ArrayList<>();

        for (HashMap item: sqlResult) {
            typeList.add(item.get("type"));
            outcomeData.add(item.get("outcomeData"));
        }

        resultMap.put("type", typeList);
        resultMap.put("outcomeData", outcomeData);
        
        return resultMap;
    }

    @Override
    public HashMap<String, ArrayList<Object>> findInPieChartData(int userId, int startTime, int endTime) {
        List<HashMap<String, Object>> sqlResult = mapper.findIncomePieChartData(userId, startTime, endTime);
        HashMap<String, ArrayList<Object>> resultMap = new HashMap<>(3);

        ArrayList<Object> typeList = new ArrayList<>();
        ArrayList<Object> outcomeData = new ArrayList<>();

        for (HashMap item: sqlResult) {
            typeList.add(item.get("type"));
            outcomeData.add(item.get("incomeData"));
        }

        resultMap.put("type", typeList);
        resultMap.put("incomeData", outcomeData);

        return resultMap;
    }
}
