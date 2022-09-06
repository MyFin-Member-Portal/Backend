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
        List<HashMap<String, Object>> result = mapper.findIncome(userId, startTime, endTime, interval, type);
        log.info(result.toString());
        HashMap<String, ArrayList<Object>> resultMap = new HashMap<>(3);
        ArrayList<Object> categoryList = new ArrayList<>();
        ArrayList<Object> incomeData = new ArrayList<>();
        
        //TODO: add outcome data
        ArrayList<Object> outcomeData = new ArrayList<>();

        for (HashMap item:result) {
            categoryList.add(item.get("months"));
            incomeData.add(item.get("amount"));
        }
        
        resultMap.put("categories", categoryList);
        resultMap.put("incomeData", incomeData);
        resultMap.put("outcomeData", outcomeData);
        return resultMap;
    }

    @Override
    public HashMap<String, List> findOutcome(int userId, int startTime, int endTime, String interval, String type) {
        return null;
    }
}
