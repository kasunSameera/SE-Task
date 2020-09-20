package com.kasun.integrator.client;

import com.kasun.integrator.wsdl.GetAccountResponse;
import com.kasun.integrator.wsdl.GetTotalAccountBalanceRequest;
import com.kasun.integrator.wsdl.GetTotalAccountBalanceResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class GetTotalAccountBalanceClient extends WebServiceGatewaySupport {

    public GetTotalAccountBalanceResponse getTotalAccountBalance(){

        GetTotalAccountBalanceRequest getTotalAccountBalanceRequest = new GetTotalAccountBalanceRequest();
        GetTotalAccountBalanceResponse getTotalAccountBalanceResponse = (GetTotalAccountBalanceResponse) getWebServiceTemplate().marshalSendAndReceive(getTotalAccountBalanceRequest);
        return  getTotalAccountBalanceResponse;
    }
}
