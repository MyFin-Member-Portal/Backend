package com.myfin.controller.VisualizationController;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.VisualizationRelatedRequest.TransactionIncomeRequest;
import com.myfin.controller.reqeust.VisualizationRelatedRequest.TransactionOutcomeRequest;
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
public class TransactionController {
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

    @PostMapping("transaction/get/all/out")
    public Result<Object> getAllOutTransaction(@RequestBody TransactionOutcomeRequest transcationRequest){
        try{
            Object Transaction = transactionService.findOutTransactionPageWithMonthService(transcationRequest.getUserId(),
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


    @PostMapping("transaction/add/out")
    public Result<Object> addIncTransaction(@RequestBody TransactionOutcomeRequest transcationRequest) {
        int transactionId;
        try{
            transactionId = transactionService.addTransactionOutcomeService(
                    transcationRequest.getUserId(),
                    transcationRequest.getTranOutDesc(),
                    transcationRequest.getTranOutCost(),
                    transcationRequest.getTranOutType(),
                    transcationRequest.getTranOutDatetime(),
//                    transcationRequest.getTranOutPin(),
                    transcationRequest.getTranOutFreq()
            );
            return Response.success(transactionId);
        }catch (IllegalArgumentException | ParseException e){
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
                    transcationRequest.getYear(),
                    transcationRequest.getMonth()
                   );
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

    @PostMapping("transaction/update/out")
    public Result<Object> updateIncTransaction(@RequestBody TransactionOutcomeRequest transcationRequest) {
        int transactionId = -1;
        try{
                transactionId = transcationRequest.getTranOutId();
                transactionService.updateOutTransactionService(
                transcationRequest.getUserId(),
                transactionId,
                transcationRequest.getTranOutDatetime(),
                transcationRequest.getTranOutCost(),
                transcationRequest.getTranOutDesc()
            );
            return Response.success("update success");
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("fail to update transaction"+transactionId);
        }
    }





    }
