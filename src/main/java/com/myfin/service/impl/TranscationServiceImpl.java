package com.myfin.service.impl;

import com.myfin.mapper.TranscationMapper;
import com.myfin.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Date;
import javax.annotation.Resource;


/**
 * @author Yuzhuo Ma
 */
@Slf4j
@Service
public class TranscationServiceImpl implements TransactionService {
    @Resource
    private TranscationMapper transcationMapper;

    @Override
    public void deleteSpecificTransactionService(int userId, int transactionId) {
        transcationMapper.deleteSpecificTransaction(userId, transactionId);
    }

    @Override
    public int addTransactionService(int userId, String transactionDesc, String transactionCost, String transactionType, long transactionDatetime ) {

        Date transactionDatetimeDate = new Date(transactionDatetime);
        transcationMapper.addTransaction(
                userId, transactionDesc, transactionCost, transactionType, transactionDatetimeDate
        );
        return transcationMapper.findMaxTransactionId(userId);
    }


}
