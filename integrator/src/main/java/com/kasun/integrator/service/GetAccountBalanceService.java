package com.kasun.integrator.service;

import com.kasun.integrator.client.GetAccountBalanceClient;
import com.kasun.integrator.model.AuditLog;
import com.kasun.integrator.repository.AuditLogRepository;
import com.kasun.integrator.wsdl.GetAccountBalanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class GetAccountBalanceService {

    @Autowired
    private GetAccountBalanceClient getAccountBalanceClient;

    @Autowired
    private AuditLogRepository auditLogRepository;

    public Double getAccountBalance(int accountNo) {

        GetAccountBalanceResponse getAccountBalanceResponse = getAccountBalanceClient.getBalance(accountNo);
        double balance = getAccountBalanceResponse.getBalance();
        AuditLog auditlog = new AuditLog();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        auditlog.setAccountNo(accountNo);
        auditlog.setServiceType("getAccountBalance");
        auditlog.setTimestamp(timestamp);
        auditLogRepository.save(auditlog);

        return balance;

    }
}
