package com.myfin.service.impl;

import com.myfin.entity.Transaction;
import com.myfin.mapper.TransactionMapper;
import com.myfin.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;


/**
 * @author Yuzhuo Ma
 */
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {
    @Resource
    private TransactionMapper transactionMapper;

    @Override
    public List<Transaction> findAllTransactionPageService(int userId, int pageNum) {
        int pageSize = 4;
        int pageOffsiteNum = (pageNum - 1) * pageSize;
        return transactionMapper.findAllTransactionPage(userId, pageOffsiteNum, pageSize);
    }

    @Override
    public void deleteSpecificTransactionService(int userId, int transactionId) {
        transactionMapper.deleteSpecificTransaction(userId, transactionId);
    }

    @Override
    public int addTransactionService(int userId, String transactionDesc, String transactionCost, String transactionType, long transactionDatetime ) {

        transactionMapper.addTransaction(
                userId, transactionDesc, transactionCost, transactionType, transactionDatetime
        );
        return transactionMapper.findMaxTransactionId(userId);
    }


}
