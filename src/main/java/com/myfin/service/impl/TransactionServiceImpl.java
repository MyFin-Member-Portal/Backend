package com.myfin.service.impl;

import com.myfin.entity.TransactionIncome;
import com.myfin.entity.TransactionOutcome;
import com.myfin.mapper.TransactionMapper;
import com.myfin.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    private final int pageSize = 6;
    private final String[] transactionFreqList = new String[]{"Once", "Weekly", "Monthly", "Yearly"};
    private final String[] transactionPinList = new String[]{"True", "False"};

    private final String[] outcomeTransactionTypeList = new String[]{"Food", "Life", "Other"};
    private final String[] incomeTransactionTypeList = new String[]{"Salary", "Other"};




    @Override
    public List<TransactionIncome> findIncTransactionPageWithMonthService(int userId) {
        Calendar calendar = Calendar.getInstance();
//        int pageOffsiteNum = this.pageOffsite(pageNum, pageSize);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        log.info(""+currentMonth);


        return transactionMapper.findIncTransactionPageWithMonth(userId);
    }

    @Override
    public List<TransactionOutcome> findOutTransactionPageWithMonthService(int userId) {
//        int pageOffsiteNum = this.pageOffsite(pageNum, pageSize);
        return transactionMapper.findOutTransactionPageWithMonth(userId);
    }

    @Override
    public int deleteIncSpecificTransactionService(int userId, int transactionId) throws NullPointerException{
        if (transactionMapper.findSpeciIncTransactionPage(userId, transactionId).size() == 0) {
            throw new NullPointerException();
        }
        transactionMapper.deleteIncSpecificTransaction(userId, transactionId);
        return transactionId;
    }

    @Override
    public int deleteOutSpecificTransactionService(int userId, int tranOutId) throws NullPointerException{
        if (transactionMapper.findSpeciOutTransactionPage(userId, tranOutId).size() == 0) {
            throw new NullPointerException();
        }
        transactionMapper.deleteOutSpecificTransaction(userId, tranOutId);
        return tranOutId;
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
        if(transactionDatetime == 0){
            throw new IllegalArgumentException("no time input");
        }
        String formattedTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(transactionDatetime));


        transactionMapper.addIncTransaction(
                userId, transactionDesc, transactionCost, transactionType, transactionDatetime, transactionPin,transactionFreq
                ,formattedTime
        );


        return transactionMapper.findMaxIncTransactionId(userId);
    }

    @Override
    public List<TransactionIncome> findIncSpecificTypeTransactionService(int userId, String transactionType, int pageNum) {
        int pageOffsiteNum = this.pageOffsite(pageNum, pageSize);
        return transactionMapper.findSpecificIncTypeTransaction(userId, transactionType, pageOffsiteNum, pageSize);
    }


    @Override
    public List<TransactionOutcome> findOutSpecificTypeTransactionService(int userId, String transactionType, int pageNum) {
        int pageOffsiteNum = this.pageOffsite(pageNum, pageSize);
        return transactionMapper.findSpecificOutTypeTransaction(userId, transactionType, pageOffsiteNum, pageSize);
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
        if(tranOutDatetime == 0){
            throw new IllegalArgumentException("no time input");
        }

        String formattedTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(tranOutDatetime));
        transactionMapper.addOutTransaction(
                userId, tranOutDesc, tranOutCost, tranOutType,
                tranOutDatetime, tranOutPin, tranOutFreq, formattedTime);

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
