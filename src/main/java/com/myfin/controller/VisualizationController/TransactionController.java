package com.myfin.controller.VisualizationController;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.VisualizationRelatedRequest.TransactionIncomeRequest;
import com.myfin.controller.reqeust.VisualizationRelatedRequest.TransactionOutcomeRequest;
import com.myfin.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Yuzhuo Ma
 */
@Slf4j
@RestController
@RequestMapping("/myfin")
public class TransactionController {
    @Resource
    TransactionService transactionService;


    @PostMapping("transaction/get/all/inc")
    public Result<Object> getAllIncTransaction(@RequestBody TransactionIncomeRequest transcationRequest){
        try{
            Object Transaction = transactionService.findIncTransactionPageWithMonthService(transcationRequest.getUserId()
                    );
            return Response.success(Transaction);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("fail to get transaction");
        }
    }

    @PostMapping("transaction/get/all/out")
    public Result<Object> getAllOutTransaction(@RequestBody TransactionOutcomeRequest transcationRequest){
        try{
            Object Transaction = transactionService.findOutTransactionPageWithMonthService(transcationRequest.getUserId());
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
            transactionId = transactionService.addIncTransactionIncomeService(
                    transcationRequest.getUserId(),
                    transcationRequest.getTranIncDesc(),
                    transcationRequest.getTranIncCost(),
                    transcationRequest.getTranIncType(),
                    transcationRequest.getTranIncDatetime(),
                    transcationRequest.getTranIncPin(),
                    transcationRequest.getTranIncFreq()
            );
            return Response.success(transactionId);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return Response.fail("wrong input string either Transaction Freq, Pin, type, or no datatime input");
        }
    }


    @PostMapping("transaction/add/out")
    public Result<Object> addIncTransaction(@RequestBody TransactionOutcomeRequest transcationRequest) {
        int transactionId;
        try{
            transactionId = transactionService.addIncTransactionOutcomeService(
                    transcationRequest.getUserId(),
                    transcationRequest.getTranOutDesc(),
                    transcationRequest.getTranOutCost(),
                    transcationRequest.getTranOutType(),
                    transcationRequest.getTranOutDatetime(),
                    transcationRequest.getTranOutPin(),
                    transcationRequest.getTranOutFreq()
            );
            return Response.success(transactionId);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return Response.fail("wrong input string either Transaction Freq, Pin, type, or no datatime input");
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

    @PostMapping("transaction/delete/out")
    public Result<Object> deleteOutSpecificTransaction(@RequestBody TransactionOutcomeRequest transcationRequest){
        int tranId;
        try {
            tranId = transactionService.deleteOutSpecificTransactionService(transcationRequest.getUserId(),
                    transcationRequest.getTranOutId());
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
                    transcationRequest.getPageNum());
            return Response.success(Transaction);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("fail to get transaction");
        }
    }

    @PostMapping("transaction/get/type/out")
    public Result<Object> getOutSpecificTypeTransaction(@RequestBody TransactionOutcomeRequest transcationRequest){
        try{
            Object Transaction = transactionService.findOutSpecificTypeTransactionService(transcationRequest.getUserId(),
                    transcationRequest.getTranOutType(),
                    transcationRequest.getPageNum());
            return Response.success(Transaction);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("fail to get transaction");
        }
    }


}
