package com.kasun.corebankdummy.endpoint;

import com.kasun.corebankdummy.Account;
import com.kasun.corebankdummy.GetAccountBalanceRequest;
import com.kasun.corebankdummy.GetAccountBalanceResponse;
import com.kasun.corebankdummy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccountBalanceEndpoint {

    @Autowired
    private AccountService accountService;

    @PayloadRoot(namespace = "http://kasun.com/corebankdummy", localPart = "getAccountBalanceRequest")
    @ResponsePayload
    public GetAccountBalanceResponse getAccountBalanceRequest(@RequestPayload GetAccountBalanceRequest request) {

        Account account = accountService.getAccounts(request.getAccountNo());
        GetAccountBalanceResponse getAccountBalanceResponse = new GetAccountBalanceResponse();
        getAccountBalanceResponse.setBalance(account.getBalance());
        return getAccountBalanceResponse;

    }
}
