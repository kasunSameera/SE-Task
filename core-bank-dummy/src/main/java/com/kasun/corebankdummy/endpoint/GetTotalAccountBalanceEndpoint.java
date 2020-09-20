package com.kasun.corebankdummy.endpoint;

import com.kasun.corebankdummy.GetTotalAccountBalanceResponse;
import com.kasun.corebankdummy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GetTotalAccountBalanceEndpoint {

    @Autowired
    private AccountService accountService;

    @PayloadRoot(namespace = "http://kasun.com/corebankdummy", localPart = "getTotalAccountBalanceRequest")
    @ResponsePayload
    public GetTotalAccountBalanceResponse getTotalAccountBalance(){
        double totalAccountBalance = accountService.getTotalAccountBalance();
        GetTotalAccountBalanceResponse getTotalAccountBalanceResponse = new GetTotalAccountBalanceResponse();
        getTotalAccountBalanceResponse.setTotalAccountBalance(totalAccountBalance);
        return getTotalAccountBalanceResponse;
    }
}
