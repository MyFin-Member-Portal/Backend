package com.myfin.mapper;

import com.myfin.entity.TransactionIncome;
import com.myfin.entity.TransactionOutcome;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yuzhuo Ma
 */
@Mapper
@Repository
public interface TransactionMapper {


    List<TransactionIncome> findAllIncTransactionPage(@Param("userId") int userId,
                                                      @Param("pageNum") int pageNum,
                                                      @Param("size") int size);

    List<TransactionOutcome> findAllOutTransactionPage(@Param("userId") int userId,
                                                       @Param("pageNum") int pageNum,
                                                       @Param("size") int size);




    /**
     * add income transaction for the user
     * @param userId
     * @param transactionDesc
     * @param transactionCost
     * @param transactionType
     * @param transactionDatetime
     */
    void addIncTransaction(
            @Param("userId") int userId,
            @Param("transactionDesc") String transactionDesc,
            @Param("transactionCost") String transactionCost,
            @Param("transactionType") String transactionType,
            @Param("transactionDatetime") long transactionDatetime,
            @Param("transactionPin") String transactionPin,
            @Param("transactionFreq") String transactionFreq
    );

    /**
     * add outcome transaction for the user
     * @param userId
     * @param tranOutDesc
     * @param tranOutCost
     * @param tranOutType
     * @param tranOutDatetime
     * @param tranOutPin
     * @param tranOutFreq
     */
    void addOutTransaction(@Param("userId") int userId,
                           @Param("tranOutDesc") String tranOutDesc,
                           @Param("tranOutCost") String tranOutCost,
                           @Param("tranOutType") String tranOutType,
                           @Param("tranOutDatetime") long tranOutDatetime,
                           @Param("tranOutPin") String tranOutPin,
                           @Param("tranOutFreq") String tranOutFreq);


    /**
     * find the newest transaction id
     * @param userId
     * @return transcation id
     */
    int findMaxIncTransactionId(@Param("userId") int userId);

    int findMaxOutTransactionId(@Param("userId") int userId);

    /**
     * delete specific transcation with userid and transcation id
     * @param userId
     * @param transactionId
     */
    void deleteIncSpecificTransaction(@Param("userId") int userId, @Param("transactionId")int transactionId);

    List<TransactionIncome> findSpecificTypeTransaction(@Param("userId") int userId,
                                                        @Param("transactionType") String transactionType,
                                                        @Param("pageNum") int pageNum,
                                                        @Param("size") int size);



}
