package com.kasun.integrator.service;

import com.kasun.integrator.client.AccountClient;
import com.kasun.integrator.model.AuditLog;
import com.kasun.integrator.repository.AuditLogRepository;
import com.kasun.integrator.wsdl.Account;
import com.kasun.integrator.wsdl.GetAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class GetAccountService {

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private AuditLogRepository auditLogRepository;

    public Account getAccount(int accountNo) {

        GetAccountResponse getAccountResponse = accountClient.getAccount(accountNo);
        Account account = getAccountResponse.getAccount();
        AuditLog auditlog = new AuditLog();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        auditlog.setAccountNo(accountNo);
        auditlog.setServiceType("getAccount");
        auditlog.setTimestamp(timestamp);
        auditlog.setUserId(account.getUserId());
        auditLogRepository.save(auditlog);
        return account;

    }
}
