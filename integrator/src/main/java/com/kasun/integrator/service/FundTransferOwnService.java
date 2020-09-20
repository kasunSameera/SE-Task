package com.kasun.integrator.service;

import com.kasun.integrator.client.FundTransferOwnClient;
import com.kasun.integrator.model.FundTransferOwn;
import com.kasun.integrator.model.AuditLog;
import com.kasun.integrator.repository.AuditLogRepository;
import com.kasun.integrator.wsdl.FundTransferOwnResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class FundTransferOwnService {

    @Autowired
    private FundTransferOwnClient fundTransferOwnClient;

    @Autowired
    private AuditLogRepository auditLogRepository;

    public FundTransferOwn fundTransferOwn(int accountNoSend, int accountNoReceive, double transferAmount){
          FundTransferOwn fundTransferOwn = new FundTransferOwn();
        FundTransferOwnResponse fundTransferOwnResponse = fundTransferOwnClient.fundTransferOwn(accountNoSend,accountNoReceive,transferAmount);
        AuditLog auditlog = new AuditLog();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        auditlog.setAccountNoSend(accountNoSend);
        auditlog.setAccountNoReceive(accountNoReceive);
        auditlog.setTransferAmount(transferAmount);
        auditlog.setServiceType("fundTransferOwn");
        auditlog.setTimestamp(timestamp);
        auditlog.setUserId(fundTransferOwnResponse.getAccountSend().getUserId());
        auditLogRepository.save(auditlog);

        if(fundTransferOwnResponse.getAccountSend() != null && fundTransferOwnResponse.getAccountReceive() != null) {
            fundTransferOwn.setSendAccountUserId(fundTransferOwnResponse.getAccountSend().getUserId());
            fundTransferOwn.setSendAccountNo(fundTransferOwnResponse.getAccountSend().getAccountNo());
            fundTransferOwn.setSendAccountBalance(fundTransferOwnResponse.getAccountSend().getBalance());
            fundTransferOwn.setReceiveAccountUserId(fundTransferOwnResponse.getAccountReceive().getUserId());
            fundTransferOwn.setReceiveAccountNo(fundTransferOwnResponse.getAccountReceive().getAccountNo());
            fundTransferOwn.setReceiveAccountBalance(fundTransferOwnResponse.getAccountReceive().getBalance());
            fundTransferOwn.setTransferredAmount(fundTransferOwnResponse.getTransferredAmount());
        }
        fundTransferOwn.setError(fundTransferOwnResponse.getError());
        return fundTransferOwn;


    }
}
