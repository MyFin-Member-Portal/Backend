package com.myfin.mapper;

import com.myfin.entity.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Yuzhuo Ma
 */
@Mapper
@Repository
public interface TransactionMapper {


    List<Transaction> findAllTransactionPage(@Param("userId") int userId,
                                             @Param("pageNum") int pageNum,
                                             @Param("size") int size);


    /**
     * add a transcation for the user
     * @param userId
     * @param transactionDesc
     * @param transactionCost
     * @param transactionType
     * @param transactionDatetime
     */
    void addTransaction(
            @Param("userId") int userId,
            @Param("transactionDesc") String transactionDesc,
            @Param("transactionCost") String transactionCost,
            @Param("transactionType") String transactionType,
            @Param("transactionDatetime") long transactionDatetime
    );

    /**
     * find the newest transaction id
     * @param userId
     * @return transcation id
     */
    int findMaxTransactionId(@Param("userId") int userId);

    /**
     * delete specific transcation with userid and transcation id
     * @param userId
     * @param transactionId
     */
    void deleteSpecificTransaction(@Param("userId") int userId, @Param("transactionId")int transactionId);
}
