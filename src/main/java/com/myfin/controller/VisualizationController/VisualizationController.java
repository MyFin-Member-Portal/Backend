package com.myfin.controller.VisualizationController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myfin.base.Result;
import com.myfin.controller.VisualizationController.request.VisualizationRequest;
import com.myfin.service.VisualizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author zihang gao
 */
@Slf4j
@RestController
@RequestMapping("/myfin/visualization")
public class VisualizationController {
    
    @Resource
    VisualizationService service;
    
    @PostMapping("/lineChart")
    public Object lineChart(@RequestBody VisualizationRequest request){
        if (request.getInterval() == null){
            request.setInterval("month");
        }

        Object result = service.findIncome(request.getUserId(), request.getStartTime(),
                request.getEndTime(), request.getInterval(), request.getType());

        return result;
    }
    
    @PostMapping("/pieChart/outcome")
    public Object pieChart(@RequestBody VisualizationRequest request){
        Object result = service.findOutPieChartData(request.getUserId(), request.getStartTime(), request.getEndTime());
        return result;
    }

    @PostMapping("/pieChart/income")
    public Object incomePieChart(@RequestBody VisualizationRequest request){
        Object result = service.findInPieChartData(request.getUserId(), request.getStartTime(), request.getEndTime());
        return result;
    }
}
