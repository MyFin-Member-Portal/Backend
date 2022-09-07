package com.myfin.service;


import com.myfin.entity.TransactionIncome;
import com.myfin.entity.TransactionOutcome;

import java.text.ParseException;
import java.util.List;

/**
 * @author Yuzhuo Ma
 */
public interface TransactionService {

    /**
     * adjust page size here
     * @param userId
     * @return
     */
    List<TransactionIncome> findIncTransactionPageWithMonthService(int userId, String year, String month);

    List<TransactionOutcome> findOutTransactionPageWithMonthService(int userId, String year, String month);


    /**
     * delete specific transcation with userid and transaction id
     * @param userId
     * @param transactionId
     */
    int deleteIncSpecificTransactionService(int userId, int transactionId);

    int deleteOutSpecificTransactionService(int userId, int tranOutId);




    /**
     * add a transaction for the user
     * add transaction default not pin, and one time thing
     * @param userId
     * @param transactionDesc
     * @param transactionCost
     * @param transactionType
     * @param transactionDatetime
     */
    int addTransactionIncomeService(int userId, String transactionDesc,
                                    String transactionCost,
                                    String transactionType,
                                    long transactionDatetime,
//                                       String transactionPin,
                                    String transactionFreq) throws IllegalArgumentException, ParseException;

    List<TransactionIncome> findIncSpecificTypeTransactionService(int userId, String transactionType, String year, String month);

    List<TransactionOutcome> findOutSpecificTypeTransactionService(int userId, String transactionType, String year, String month);


    int addTransactionOutcomeService(int userId, String tranOutDesc,
                                     String tranOutCost,
                                     String tranOutType,
                                     long tranOutDatetime,
//                                        String tranOutPin,
                                     String tranOutFreq) throws IllegalArgumentException, ParseException;

    void updateIncTransactionService(int userId, int tranIncId, long tranIncDatetime, String tranIncCost, String tranIncDesc);

    void updateOutTransactionService(int userId, int transactionId, long tranOutDatetime, String tranOutCost, String tranOutDesc);
}
