package com.kasun.integrator.service;

import com.kasun.integrator.client.GetTotalAccountBalanceClient;
import com.kasun.integrator.model.AuditLog;
import com.kasun.integrator.repository.AuditLogRepository;
import com.kasun.integrator.wsdl.GetTotalAccountBalanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class GetTotalAccountBalanceService {

    @Autowired
    private GetTotalAccountBalanceClient getTotalAccountBalanceClient;

    @Autowired
    private AuditLogRepository auditLogRepository;

    public GetTotalAccountBalanceResponse getTotalAccountBalance(){

        GetTotalAccountBalanceResponse getTotalAccountBalanceResponse = getTotalAccountBalanceClient.getTotalAccountBalance();
        AuditLog auditlog = new AuditLog();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        auditlog.setServiceType("getTotalAccountBalance");
        auditlog.setTimestamp(timestamp);
        auditLogRepository.save(auditlog);
        return getTotalAccountBalanceResponse;
    }
}
