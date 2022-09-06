package com.myfin.mapper;

import com.myfin.entity.TransactionIncome;
import com.myfin.entity.TransactionOutcome;
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
    List<HashMap<String, Object>> findIncome(int userId, int startTime, int endTime, String interval, String type);

    List<TransactionOutcome> findOutcome(int userId, int startTime, int endTime, String interval, String type);
}
