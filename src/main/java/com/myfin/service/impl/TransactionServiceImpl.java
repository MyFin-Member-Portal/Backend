package com.myfin.service.impl;

import com.myfin.entity.TransactionIncome;
import com.myfin.entity.TransactionOutcome;
import com.myfin.mapper.TransactionMapper;
import com.myfin.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    private final int pageSize = 4;
    private final String[] transactionFreqList = new String[]{"Once", "Weekly", "Monthly", "Yearly"};
    private final String[] transactionPinList = new String[]{"True", "False"};

    private final String[] outcomeTransactionTypeList = new String[]{"Food", "Life", "Other"};
    private final String[] incomeTransactionTypeList = new String[]{"Salary", "Other"};



    @Override
    public List<TransactionIncome> findAllIncTransPageService(int userId, int pageNum) {
        int pageOffsiteNum = this.pageOffsite(pageNum, pageSize);
        return transactionMapper.findAllIncTransactionPage(userId, pageOffsiteNum, pageSize);
    }

    @Override
    public List<TransactionOutcome> findAllOutTransPageService(int userId, int pageNum) {
        int pageOffsiteNum = this.pageOffsite(pageNum, pageSize);
        return transactionMapper.findAllOutTransactionPage(userId, pageOffsiteNum, pageSize);
    }

    @Override
    public void deleteIncSpecificTransactionService(int userId, int transactionId) {
        transactionMapper.deleteIncSpecificTransaction(userId, transactionId);
    }

    @Override
    public int addIncTransactionIncomeService(int userId, String transactionDesc, String transactionCost, String transactionType,
                                              long transactionDatetime, String transactionPin, String transactionFreq ) throws IllegalArgumentException {
        int inFreqListSwitch;
        int inPinListSwitch;
        int inTypeListSwitch;


//        check transactionFreq input
        inFreqListSwitch = checkInput(transactionFreqList, transactionFreq);

        inPinListSwitch = checkInput(transactionPinList, transactionPin);

        inTypeListSwitch = checkInput(incomeTransactionTypeList, transactionType);

        if (inPinListSwitch == 0 || inFreqListSwitch == 0 || inTypeListSwitch == 0){
            throw new IllegalArgumentException("input not acceptable");
        }

        transactionMapper.addIncTransaction(
                userId, transactionDesc, transactionCost, transactionType, transactionDatetime, transactionPin,transactionFreq
        );


        return transactionMapper.findMaxIncTransactionId(userId);
    }

    @Override
    public List<TransactionIncome> findSpecificTypeTransactionService(int userId, String transactionType, int pageNum) {
        int pageOffsiteNum = this.pageOffsite(pageNum, pageSize);
        return transactionMapper.findSpecificTypeTransaction(userId, transactionType, pageOffsiteNum, pageSize);
    }

    @Override
    public int addIncTransactionOutcomeService(int userId, String tranOutDesc, String tranOutCost,
                                               String tranOutType, long tranOutDatetime, String tranOutPin, String tranOutFreq) throws IllegalArgumentException {
        int inFreqListSwitch;
        int inPinListSwitch;
        int inTypeListSwitch;

//        check transactionFreq input
        inFreqListSwitch = checkInput(transactionFreqList, tranOutFreq);

        inPinListSwitch = checkInput(transactionPinList, tranOutPin);

        inTypeListSwitch = checkInput(outcomeTransactionTypeList, tranOutType);

        if (inPinListSwitch == 0 || inFreqListSwitch == 0 || inTypeListSwitch == 0){
            throw new IllegalArgumentException("input not acceptable");
        }
        transactionMapper.addOutTransaction(
                userId, tranOutDesc, tranOutCost, tranOutType,
                tranOutDatetime, tranOutPin, tranOutFreq);

        return transactionMapper.findMaxOutTransactionId(userId);
    }

    public int pageOffsite(int pageNum, int pageSize){
        return (pageNum - 1) * pageSize;
    }

    public int checkInput(String[] standList, String input){
        for (String s : standList) {
            if (s.equals(input)) {
                return 1;
            }
        }
        return 0;
    }


}
