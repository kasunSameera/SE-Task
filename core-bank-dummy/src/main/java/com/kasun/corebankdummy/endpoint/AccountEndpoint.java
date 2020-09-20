package com.kasun.corebankdummy.endpoint;

import com.kasun.corebankdummy.*;
import com.kasun.corebankdummy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccountEndpoint {

    @Autowired
    private AccountService accountService;

    @PayloadRoot(namespace = "http://kasun.com/corebankdummy", localPart = "getAccountRequest")
    @ResponsePayload
    public GetAccountResponse getAccountRequest(@RequestPayload GetAccountRequest request) {

        Account account = accountService.getAccounts(request.getAccountNo());
        GetAccountResponse getAccountResponse = new GetAccountResponse();
        getAccountResponse.setAccount(account);
        return getAccountResponse;

    }

}
