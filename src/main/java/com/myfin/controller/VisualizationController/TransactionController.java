package com.myfin.controller.VisualizationController;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.VisualizationRelatedRequest.TranscationRequest;
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


    @PostMapping("transaction/get/all/page")
    public Result<Object> getAllTransaction(@RequestBody TranscationRequest transcationRequest){
        try{
            Object Transaction = transactionService.findAllTransactionPageService(transcationRequest.getUserId(),
                    transcationRequest.getPageNum());
            return Response.success(Transaction);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("fail to get transaction");
        }

    }

    @PostMapping("transaction/add")
    public Result<Object> addTransaction(@RequestBody TranscationRequest transcationRequest) {
        int transactionId;
        try{
            transactionId = transactionService.addTransactionService(
                    transcationRequest.getUserId(),
                    transcationRequest.getTransactionDesc(),
                    transcationRequest.getTransactionCost(),
                    transcationRequest.getTransactionType(),
                    transcationRequest.getTransactionDatetime()
            );
            return Response.success(transactionId);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("add transaction fail");
        }
    }


        @PostMapping("transaction/delete")
    public Result<Object> deleteSpecificTransaction(@RequestBody TranscationRequest transcationRequest){
        try {
            transactionService.deleteSpecificTransactionService(transcationRequest.getUserId(),
                    transcationRequest.getTransactionId());
            return Response.success("delete success");
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("Delete fail");
        }

    }


}
