package com.myfin.controller.userProfileController;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.UserFinancialRequest;
import com.myfin.service.UserFinancialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author  Yuhzhuo Ma
 */

@Slf4j
@RestController
@RequestMapping("/myfin/user/profile/finicial")
public class UserFinancialInfoController {
    @Resource
    private UserFinancialService userFinancialService;

    @PostMapping("/getInfo")
    public Result<Object> getUserFinicialInfo(@RequestBody UserFinancialRequest userFinancialRequest){
        Object UserFinicial;
        try{
            int userId = userFinancialRequest.getUserId();
            UserFinicial = userFinancialService.getUserFinicialInfoService(userId);

        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("Get Fail");
        }
        return Response.success(UserFinicial);
    }


    @PostMapping("/createInfo")
    public Result<Object> createUserFinancialInfo(@RequestBody UserFinancialRequest userFinancialRequest){

        try{
            userFinancialService.createUserFinancialInfoService(userFinancialRequest.getUserId());
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("Create Fail");
        }
        return Response.success("create user financial table success");
    }


    @PostMapping("/updateInfo")
    public Result<Object> updateUserFinicialInfo(@RequestBody UserFinancialRequest userFinancialRequest){
        int userId;
        try {
            userId = userFinancialRequest.getUserId();
            userFinancialService.updateUserFinicialInfoService(
                    userId,
                    userFinancialRequest.getCurFinBeh(),
                    userFinancialRequest.getFinPos(),
                    userFinancialRequest.getEmpStatus(),
                    userFinancialRequest.getBudgetInfo(),
                    userFinancialRequest.getIncBracket(),
                    userFinancialRequest.getCarNum(),
                    userFinancialRequest.getPensioner(),
                    userFinancialRequest.getConcessionCardHold(),
                    userFinancialRequest.getGovBenRecipient(),
                    userFinancialRequest.getPayChiSup(),
                    userFinancialRequest.getInLegalProceeding(),
                    userFinancialRequest.getFuneralPrepaid(),
                    userFinancialRequest.getAdequateInsCov(),
                    userFinancialRequest.getExpectInheri()
            );

        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("Update Fail");
        }
        return Response.success(userId);
    }

}
