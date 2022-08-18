package com.myfin.service;


/**
 * @author Yuzhuo Ma
 */
public interface TransactionService {
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
