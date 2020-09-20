package com.kasun.integrator.client;

import com.kasun.integrator.wsdl.FundTransferOwnRequest;
import com.kasun.integrator.wsdl.FundTransferOwnResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class FundTransferOwnClient extends WebServiceGatewaySupport {

    public FundTransferOwnResponse fundTransferOwn(int accountNoSend, int accountNoReceive, double transferAmount) {

        FundTransferOwnRequest fundTransferOwnRequest = new FundTransferOwnRequest();
        fundTransferOwnRequest.setAccountNoSend(accountNoSend);
        fundTransferOwnRequest.setAccountNoReceive(accountNoReceive);
        fundTransferOwnRequest.setTransferAmount(transferAmount);

        FundTransferOwnResponse fundTransferOwnResponse = (FundTransferOwnResponse) getWebServiceTemplate().marshalSendAndReceive(fundTransferOwnRequest);

        return fundTransferOwnResponse;

    }
}
