package com.kasun.integrator.client;

import com.kasun.integrator.wsdl.FundTransferOtherRequest;
import com.kasun.integrator.wsdl.FundTransferOtherResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class FundTransferOtherClient extends WebServiceGatewaySupport {

    public FundTransferOtherResponse fundTransferOther(int accountNoSend, int accountNoReceive, double transferAmount) {

        FundTransferOtherRequest fundTransferOtherRequest = new FundTransferOtherRequest();
        fundTransferOtherRequest.setAccountNoSend(accountNoSend);
        fundTransferOtherRequest.setAccountNoReceive(accountNoReceive);
        fundTransferOtherRequest.setTransferAmount(transferAmount);

        FundTransferOtherResponse fundTransferOtherResponse = (FundTransferOtherResponse) getWebServiceTemplate().marshalSendAndReceive(fundTransferOtherRequest);

        return fundTransferOtherResponse;
    }
}
