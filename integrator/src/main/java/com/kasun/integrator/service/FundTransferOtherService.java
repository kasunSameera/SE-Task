package com.kasun.integrator.service;

import com.kasun.integrator.client.FundTransferOtherClient;
import com.kasun.integrator.model.FundTransferOther;
import com.kasun.integrator.model.AuditLog;
import com.kasun.integrator.repository.AuditLogRepository;
import com.kasun.integrator.wsdl.FundTransferOtherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class FundTransferOtherService {

    @Autowired
    private FundTransferOtherClient fundTransferOtherClient;

    @Autowired
    private AuditLogRepository auditLogRepository;

    public FundTransferOther fundTransferOther(int accountNoSend, int accountNoReceive, double transferAmount) {
        FundTransferOther fundTransferOther = new FundTransferOther();
        FundTransferOtherResponse fundTransferOtherResponse = fundTransferOtherClient.fundTransferOther(accountNoSend, accountNoReceive, transferAmount);
        AuditLog auditlog = new AuditLog();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        auditlog.setAccountNoSend(accountNoSend);
        auditlog.setAccountNoReceive(accountNoReceive);
        auditlog.setTransferAmount(transferAmount);
        auditlog.setServiceType("fundTransferOther");
        auditlog.setTimestamp(timestamp);
        auditlog.setUserId(fundTransferOtherResponse.getAccountSend().getUserId());
        auditLogRepository.save(auditlog);

        if (fundTransferOtherResponse.getAccountSend() != null && fundTransferOtherResponse.getAccountReceive() != null) {
            fundTransferOther.setSendAccountUserId(fundTransferOtherResponse.getAccountSend().getUserId());
            fundTransferOther.setSendAccountNo(fundTransferOtherResponse.getAccountSend().getAccountNo());
            fundTransferOther.setSendAccountBalance(fundTransferOtherResponse.getAccountSend().getBalance());
            fundTransferOther.setReceiveAccountUserId(fundTransferOtherResponse.getAccountReceive().getUserId());
            fundTransferOther.setReceiveAccountNo(fundTransferOtherResponse.getAccountReceive().getAccountNo());
            fundTransferOther.setReceiveAccountBalance(fundTransferOtherResponse.getAccountReceive().getBalance());
            fundTransferOther.setTransferredAmount(fundTransferOtherResponse.getTransferredAmount());
        }
        fundTransferOther.setError(fundTransferOtherResponse.getError());
        return fundTransferOther;

    }
}
