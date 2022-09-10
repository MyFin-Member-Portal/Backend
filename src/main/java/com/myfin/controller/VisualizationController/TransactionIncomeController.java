package com.myfin.controller.VisualizationController;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.VisualizationRelatedRequest.TransactionIncomeRequest;
import com.myfin.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * @author Yuzhuo Ma
 */
@Slf4j
@RestController
@RequestMapping("/myfin")
public class TransactionIncomeController {
    @Resource
    TransactionService transactionService;


    @PostMapping("transaction/get/all/inc")
    public Result<Object> getAllIncTransaction(@RequestBody TransactionIncomeRequest transcationRequest){
        try{
            Object Transaction = transactionService.findIncTransactionPageWithMonthService(transcationRequest.getUserId(),
                    transcationRequest.getYear(),
                    transcationRequest.getMonth()
                    );
            return Response.success(Transaction);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("fail to get transaction");
        }
    }


    @PostMapping("transaction/add/inc")
    public Result<Object> addIncTransaction(@RequestBody TransactionIncomeRequest transcationRequest) {
        int transactionId;
        try{
            transactionId = transactionService.addTransactionIncomeService(
                    transcationRequest.getUserId(),
                    transcationRequest.getTranIncDesc(),
                    transcationRequest.getTranIncCost(),
                    transcationRequest.getTranIncType(),
                    transcationRequest.getTranIncDatetime(),
//                    transcationRequest.getTranIncPin(),
                    transcationRequest.getTranIncFreq()
            );
            return Response.success(transactionId);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return Response.fail("wrong input string either Transaction Freq, Pin, type, or no datatime input");
        } catch (ParseException e) {
            e.printStackTrace();
            return Response.fail("date format is wrong");
        }
    }




    @PostMapping("transaction/delete/inc")
    public Result<Object> deleteIncSpecificTransaction(@RequestBody TransactionIncomeRequest transcationRequest){
        int tranId;
        try {
            tranId = transactionService.deleteIncSpecificTransactionService(transcationRequest.getUserId(),
                    transcationRequest.getTranIncId());
            return Response.success(tranId);
        }catch (NullPointerException e){
            e.printStackTrace();
            return Response.fail("no such transaction id exist");
        }
    }



    @PostMapping("transaction/get/type/inc")
    public Result<Object> getIncSpecificTypeTransaction(@RequestBody TransactionIncomeRequest transcationRequest){
        try{
            Object Transaction = transactionService.findIncSpecificTypeTransactionService(transcationRequest.getUserId(),
                    transcationRequest.getTranIncType(),
                    transcationRequest.getYear(),
                    transcationRequest.getMonth()
                   );
            return Response.success(Transaction);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("fail to get transaction");
        }
    }


    @PostMapping("transaction/update/inc")
    public Result<Object> updateIncTransaction(@RequestBody TransactionIncomeRequest transcationRequest) {
        int transactionId = -1;
        try{
            transactionId = transcationRequest.getTranIncId();
            transactionService.updateIncTransactionService(
                    transcationRequest.getUserId(),
                    transactionId,
                    transcationRequest.getTranIncDatetime(),
                    transcationRequest.getTranIncCost(),
                    transcationRequest.getTranIncDesc()
            );
            return Response.success("update success");
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("fail to update transaction"+transactionId);
        }
    }






    }
