package com.kasun.corebankdummy.endpoint;

import com.kasun.corebankdummy.Account;
import com.kasun.corebankdummy.FundTransferOwnRequest;
import com.kasun.corebankdummy.FundTransferOwnResponse;
import com.kasun.corebankdummy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FundTransferOwnEndpoint {

    @Autowired
    private AccountService accountService;

    @PayloadRoot(namespace = "http://kasun.com/corebankdummy", localPart = "fundTransferOwnRequest")
    @ResponsePayload
    public FundTransferOwnResponse fundTransferOwnRequest(@RequestPayload FundTransferOwnRequest request) {


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

            //account user validation
            if (userIdSend != userIdReceive) {
                throw new Exception("the account you are Trying to transfer funds is not yours.");
            }

            Account newAccountSend = accountService.balanceUpdate(request.getAccountNoSend(), balanceSend - transferAmount);
            Account newAccountReceive = accountService.balanceUpdate(request.getAccountNoReceive(), balanceReceive + transferAmount);
            FundTransferOwnResponse fundTransferOwnResponse = new FundTransferOwnResponse();
            fundTransferOwnResponse.setAccountReceive(newAccountReceive);
            fundTransferOwnResponse.setAccountSend(newAccountSend);
            fundTransferOwnResponse.setTransferredAmount(transferAmount);
            return fundTransferOwnResponse;

        } catch (Exception e){
            FundTransferOwnResponse fundTransferOwnResponse = new FundTransferOwnResponse();
            fundTransferOwnResponse.setError(e.getMessage());
            return fundTransferOwnResponse;
        }


    }
}
