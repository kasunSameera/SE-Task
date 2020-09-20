package com.kasun.integrator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idServiceCall;

    private String serviceType;

    private Integer accountNo;

    private Integer accountNoSend;

    private Integer accountNoReceive;

    private Double transferAmount;


    private Timestamp timestamp;

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getIdServiceCall() {
        return idServiceCall;
    }

    public void setIdServiceCall(Integer idServiceCall) {
        this.idServiceCall = idServiceCall;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getAccountNoSend() {
        return accountNoSend;
    }

    public void setAccountNoSend(Integer accountNoSend) {
        this.accountNoSend = accountNoSend;
    }

    public Integer getAccountNoReceive() {
        return accountNoReceive;
    }

    public void setAccountNoReceive(Integer accountNoReceive) {
        this.accountNoReceive = accountNoReceive;
    }

    public Double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Double transferAmount) {
        this.transferAmount = transferAmount;
    }
}
