package com.kasun.integrator.client;

import com.kasun.integrator.wsdl.GetAccountBalanceRequest;
import com.kasun.integrator.wsdl.GetAccountBalanceResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class GetAccountBalanceClient extends WebServiceGatewaySupport {

    public GetAccountBalanceResponse getBalance(int accountNo){

        GetAccountBalanceRequest getAccountBalanceRequest = new GetAccountBalanceRequest();
        getAccountBalanceRequest.setAccountNo(accountNo);

        GetAccountBalanceResponse getAccountBalanceResponse = (GetAccountBalanceResponse) getWebServiceTemplate().marshalSendAndReceive(getAccountBalanceRequest);

        return getAccountBalanceResponse;
    }
}
