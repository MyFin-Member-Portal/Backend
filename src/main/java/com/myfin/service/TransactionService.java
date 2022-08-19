package com.myfin.service;


import com.myfin.entity.Transaction;

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
    List<Transaction> findAllTransactionPageService(int userId, int pageNum);

    /**
     * delete specific transcation with userid and transcation id
     * @param userId
     * @param transactionId
     */
    void deleteSpecificTransactionService(int userId, int transactionId);

    /**
     * add a transaction for the user
     * @param userId
     * @param transactionDesc
     * @param transactionCost
     * @param transactionType
     * @param transactionDatetime
     */
    int addTransactionService(int userId, String transactionDesc,
                                      String transactionCost,
                              String transactionType,
                                      long transactionDatetime);
}
