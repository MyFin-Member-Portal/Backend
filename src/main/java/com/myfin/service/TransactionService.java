package com.myfin.service;


import com.myfin.entity.TransactionIncome;
import com.myfin.entity.TransactionOutcome;

import java.util.List;

/**
 * @author Yuzhuo Ma
 */
public interface TransactionService {

    /**
     * adjust page size here
     * @param userId
     * @param pageNum
     * @return
     */
    List<TransactionIncome> findAllIncTransPageService(int userId, int pageNum);

    List<TransactionOutcome> findAllOutTransPageService(int userId, int pageNum);


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
    int addIncTransactionIncomeService(int userId, String transactionDesc,
                                       String transactionCost,
                                       String transactionType,
                                       long transactionDatetime,
                                       String transactionPin,
                                       String transactionFreq) throws IllegalArgumentException;

    List<TransactionIncome> findSpecificTypeTransactionService(int userId, String transactionType, int pageNum);

    int addIncTransactionOutcomeService(int userId, String tranOutDesc,
                                        String tranOutCost,
                                        String tranOutType,
                                        long tranOutDatetime,
                                        String tranOutPin,
                                        String tranOutFreq)  throws IllegalArgumentException;

}
