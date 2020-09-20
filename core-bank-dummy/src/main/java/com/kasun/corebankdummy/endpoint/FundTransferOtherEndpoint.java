package com.kasun.corebankdummy.endpoint;

import com.kasun.corebankdummy.*;
import com.kasun.corebankdummy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FundTransferOtherEndpoint {

    @Autowired
    private AccountService accountService;

    @PayloadRoot(namespace = "http://kasun.com/corebankdummy", localPart = "fundTransferOtherRequest")
    @ResponsePayload
    public FundTransferOtherResponse fundTransferOtherRequest(@RequestPayload FundTransferOtherRequest request) {

        try{
            //account validation
            if (request.getAccountNoSend() == 0) {
                throw new Exception("please enter the sending account number.");
            }
            //account validation
            if (request.getAccountNoReceive() == 0){
                throw new Exception("please enter the sending account number.");
            }

            Account accountSend = accountService.getAccounts(request.getAccountNoSend());
            Account accountReceive = accountService.getAccounts(request.getAccountNoReceive());

            //account validation
            if (accountSend == null){
                throw new Exception("sending account number is invalid.");
            }

            //account validation
            if (accountReceive == null){
                throw new Exception("receiving account number is invalid.");
            }

            double transferAmount = request.getTransferAmount();
            double balanceSend = accountSend.getBalance();
            double balanceReceive = accountReceive.getBalance();
            int userIdSend = accountSend.getUserId();
            int userIdReceive = accountReceive.getUserId();

            //account balance validation
            if (balanceSend < transferAmount) {
                throw new Exception("insufficient account balance.");
            }

            Account newAccountSend = accountService.balanceUpdate(request.getAccountNoSend(), balanceSend - transferAmount);
            Account newAccountReceive = accountService.balanceUpdate(request.getAccountNoReceive(), balanceReceive + transferAmount);
            FundTransferOtherResponse fundTransferOtherResponse = new FundTransferOtherResponse();
            fundTransferOtherResponse.setAccountReceive(newAccountReceive);
            fundTransferOtherResponse.setAccountSend(newAccountSend);
            fundTransferOtherResponse.setTransferredAmount(transferAmount);
            return fundTransferOtherResponse;

        }catch (Exception e){
            FundTransferOtherResponse fundTransferOtherResponse = new FundTransferOtherResponse();
            fundTransferOtherResponse.setError(e.getMessage());
            return fundTransferOtherResponse;
        }

    }
}
