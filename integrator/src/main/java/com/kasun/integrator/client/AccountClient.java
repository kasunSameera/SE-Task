package com.kasun.integrator.client;

import com.kasun.integrator.wsdl.GetAccountRequest;
import com.kasun.integrator.wsdl.GetAccountResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class AccountClient extends WebServiceGatewaySupport {

    public GetAccountResponse getAccount(int accountNo) {

        GetAccountRequest getAccountRequest = new GetAccountRequest();
        getAccountRequest.setAccountNo(accountNo);

        GetAccountResponse getAccountResponse = (GetAccountResponse) getWebServiceTemplate().marshalSendAndReceive(getAccountRequest);

        return getAccountResponse;
    }
}
