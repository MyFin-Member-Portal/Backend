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


    List<TransactionIncome> findIncTransactionWithMonth(@Param("userId") int userId,
                                                        @Param("year") int year,
                                                        @Param("month") int month);

    List<TransactionOutcome> findOutTransactionWithMonth(@Param("userId") int userId,
                                                         @Param("year") int year,
                                                         @Param("month") int month);


    List<TransactionIncome> findSpeciIncTransactionPage(@Param("userId") int userId,
                                                       @Param("tranIncId") int tranIncId);

    List<TransactionIncome> findSpeciOutTransactionPage(@Param("userId") int userId,
                                                        @Param("tranOutId") int tranOutId);





    /**
     * add income transaction for the user
     * @param userId
     * @param transactionDesc
     * @param transactionCost
     * @param transactionType
     * @param transactionDatetime
     * @param formattedTime
     */
    void addIncTransaction(
            @Param("userId") int userId,
            @Param("transactionDesc") String transactionDesc,
            @Param("transactionCost") String transactionCost,
            @Param("transactionType") String transactionType,
            @Param("transactionDatetime") long transactionDatetime,
//            @Param("transactionPin") String transactionPin,
            @Param("transactionFreq") String transactionFreq,
            @Param("formattedTime") String formattedTime);

    /**
     * add outcome transaction for the user
     * @param userId
     * @param tranOutDesc
     * @param tranOutCost
     * @param tranOutType
     * @param tranOutDatetime
     * @param tranOutFreq
     * @param formattedTime
     */
    void addOutTransaction(@Param("userId") int userId,
                           @Param("tranOutDesc") String tranOutDesc,
                           @Param("tranOutCost") String tranOutCost,
                           @Param("tranOutType") String tranOutType,
                           @Param("tranOutDatetime") long tranOutDatetime,
//                           @Param("tranOutPin") String tranOutPin,
                           @Param("tranOutFreq") String tranOutFreq,
                           @Param("formattedTime") String formattedTime);


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

    void deleteOutSpecificTransaction(@Param("userId") int userId, @Param("transactionId")int transactionId);



    List<TransactionIncome> findSpecificIncTypeTransaction(@Param("userId") int userId,
                                                           @Param("transactionType") String transactionType,
                                                           @Param("year") int year,
                                                           @Param("month") int month);


    List<TransactionOutcome> findSpecificOutTypeTransaction(@Param("userId") int userId,
                                                           @Param("transactionType") String transactionType,
                                                            @Param("year") int year,
                                                            @Param("month") int month);


    void updateIncTransaction(@Param("userId") int userId,
                              @Param("tranIncId") int tranIncId,
                              @Param("tranIncDatetime") long tranIncDatetime,
                              @Param("tranIncCost") String tranIncCost,
                              @Param("formattedTime") String formattedTime,
                              @Param("tranIncDesc") String tranIncDesc);

    void updateOutTransaction(@Param("userId") int userId,
                              @Param("transactionId") int transactionId,
                              @Param("tranOutDatetime") long tranOutDatetime,
                              @Param("tranOutCost") String tranOutCost,
                              @Param("formattedTime") String formattedTime,
                              @Param("tranOutDesc") String tranOutDesc);
}
