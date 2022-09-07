package com.myfin.service.impl;

import com.myfin.entity.TransactionIncome;
import com.myfin.entity.TransactionOutcome;
import com.myfin.mapper.TransactionMapper;
import com.myfin.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import javax.annotation.Resource;
import com.myfin.util.dateTransform;

/**
 * @author Yuzhuo Ma
 */
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {
    @Resource
    private TransactionMapper transactionMapper;

    private final int datePeriod = 12;

    private final String[] transactionFreqList = new String[]{"Once", "Weekly", "Monthly", "Yearly"};
    private final String[] transactionPinList = new String[]{"True", "False"};

    private final String[] outcomeTransactionTypeList = new String[]{"Food", "Life", "Other"};
    private final String[] incomeTransactionTypeList = new String[]{"Salary", "Other"};




    @Override
    public List<TransactionIncome> findIncTransactionPageWithMonthService(int userId, String year, String month) {
//        int pageOffsiteNum = this.pageOffsite(pageNum, pageSize);
        int monthInt;
        int yearInt;
        try {
            monthInt = Integer.parseInt(month);
            yearInt = Integer.parseInt(year);
        } catch (Exception e) {
            throw new IllegalArgumentException("wrong month and year format");
        }

        return transactionMapper.findIncTransactionWithMonth(userId, yearInt, monthInt);
    }

    @Override
    public List<TransactionOutcome> findOutTransactionPageWithMonthService(int userId, String year, String month) {
        int monthInt;
        int yearInt;

        try {
            monthInt = Integer.parseInt(month);
            yearInt = Integer.parseInt(year);
        } catch (Exception e) {
            throw new IllegalArgumentException("wrong month and year format");
        }
        return transactionMapper.findOutTransactionWithMonth(userId, yearInt, monthInt);
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
    public int addTransactionIncomeService(int userId, String transactionDesc, String transactionCost, String transactionType,
                                           long transactionDatetime,
//                                              String transactionPin,
                                           String transactionFreq ) throws IllegalArgumentException, ParseException {
        int inFreqListSwitch;
        int inPinListSwitch;
        int inTypeListSwitch;

        transactionDatetime = transactionDatetime*1000L;


//        check transactionFreq input
        inFreqListSwitch = checkInput(transactionFreqList, transactionFreq);

//        inPinListSwitch = checkInput(transactionPinList, transactionPin);

        inTypeListSwitch = checkInput(incomeTransactionTypeList, transactionType);

        if (inFreqListSwitch == 0 || inTypeListSwitch == 0){
            throw new IllegalArgumentException("input not acceptable");
        }
        if(transactionDatetime == 0){
            throw new IllegalArgumentException("no time input");
        }
        String formattedTime = dateTransform.timestampToDate(transactionDatetime);

        if (transactionFreq.equals("Monthly")){
            List<String> monthFormatList = new ArrayList<>(Collections.emptyList());
            for (int i = 0; i <= datePeriod; i++){
                monthFormatList.add(formattedTime);
                formattedTime = dateTransform.addMonth(formattedTime);
            }
            for (String transDate : monthFormatList) {
                long monthlyTimeStamp = dateTransform.dateToTimestamp(transDate);
                transactionMapper.addIncTransaction(
                userId, transactionDesc, transactionCost, transactionType, monthlyTimeStamp,transactionFreq
                ,transDate);
            }
        }
        if(transactionFreq.equals("Once")){
            transactionMapper.addIncTransaction(userId, transactionDesc, transactionCost, transactionType,
                    transactionDatetime,transactionFreq,formattedTime);
        }
        return transactionMapper.findMaxIncTransactionId(userId);
    }

    @Override
    public int addTransactionOutcomeService(int userId, String tranOutDesc, String tranOutCost,
                                            String tranOutType, long tranOutDatetime,
//                                               String tranOutPin,
                                            String tranOutFreq) throws IllegalArgumentException, ParseException {

        int inFreqListSwitch;
        int inPinListSwitch;
        int inTypeListSwitch;

//        check transactionFreq input
        inFreqListSwitch = checkInput(transactionFreqList, tranOutFreq);

//        inPinListSwitch = checkInput(transactionPinList, tranOutPin);

        inTypeListSwitch = checkInput(outcomeTransactionTypeList, tranOutType);

        if (inFreqListSwitch == 0 || inTypeListSwitch == 0){
            throw new IllegalArgumentException("input not acceptable");
        }
        if(tranOutDatetime == 0){
            throw new IllegalArgumentException("no time input");
        }

        String formattedTime = dateTransform.timestampToDate(tranOutDatetime);
        if (tranOutFreq.equals("Monthly")){
            List<String> monthFormatList = new ArrayList<>(Collections.emptyList());
            for (int i = 0; i <= datePeriod; i++){
                monthFormatList.add(formattedTime);
                formattedTime = dateTransform.addMonth(formattedTime);
            }
            for (String transDate : monthFormatList) {
                long monthlyTimeStamp =dateTransform.dateToTimestamp(transDate);
                transactionMapper.addOutTransaction(
                        userId, tranOutDesc, tranOutCost, tranOutType, monthlyTimeStamp,tranOutFreq
                        ,transDate);
            }
        }
        if(tranOutFreq.equals("Once")){
            transactionMapper.addOutTransaction(userId, tranOutDesc, tranOutCost, tranOutType,
                    tranOutDatetime,tranOutFreq,formattedTime);

        }
        return transactionMapper.findMaxOutTransactionId(userId);
    }

    @Override
    public void updateIncTransactionService(int userId, int tranIncId, long tranIncDatetime, String tranIncCost, String tranIncDesc) {

        String formattedTime = dateTransform.timestampToDate(tranIncDatetime);

        transactionMapper.updateIncTransaction(userId, tranIncId, tranIncDatetime, tranIncCost, formattedTime, tranIncDesc);


    }

    @Override
    public void updateOutTransactionService(int userId, int transactionId, long tranOutDatetime, String tranOutCost, String tranOutDesc) {
        String formattedTime = dateTransform.timestampToDate(tranOutDatetime);

        transactionMapper.updateOutTransaction(userId, transactionId, tranOutDatetime, tranOutCost, formattedTime, tranOutDesc);

    }


    @Override
    public List<TransactionIncome> findIncSpecificTypeTransactionService(int userId, String transactionType, String year, String month) {
        int monthInt;
        int yearInt;

        try {
            monthInt = Integer.parseInt(month);
            yearInt = Integer.parseInt(year);
        } catch (Exception e) {
            throw new IllegalArgumentException("input not acceptable");
        }
        return transactionMapper.findSpecificIncTypeTransaction(userId, transactionType, yearInt, monthInt);
    }


    @Override
    public List<TransactionOutcome> findOutSpecificTypeTransactionService(int userId, String transactionType, String year, String month) {
        int monthInt;
        int yearInt;

        try {
            monthInt = Integer.parseInt(month);
            yearInt = Integer.parseInt(year);
        } catch (Exception e) {
            throw new IllegalArgumentException("input not acceptable");
        }
        return transactionMapper.findSpecificOutTypeTransaction(userId, transactionType, yearInt, monthInt);
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
