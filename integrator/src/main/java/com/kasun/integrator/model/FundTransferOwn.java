package com.kasun.integrator.model;

public class FundTransferOwn {

    public int getSendAccountUserId() {
        return sendAccountUserId;
    }

    public void setSendAccountUserId(int sendAccountUserId) {
        this.sendAccountUserId = sendAccountUserId;
    }

    public int getSendAccountNo() {
        return sendAccountNo;
    }

    public void setSendAccountNo(int sendAccountNo) {
        this.sendAccountNo = sendAccountNo;
    }

    public double getSendAccountBalance() {
        return sendAccountBalance;
    }

    public void setSendAccountBalance(double sendAccountBalance) {
        this.sendAccountBalance = sendAccountBalance;
    }

    public int getReceiveAccountUserId() {
        return receiveAccountUserId;
    }

    public void setReceiveAccountUserId(int receiveAccountUserId) {
        this.receiveAccountUserId = receiveAccountUserId;
    }

    public int getReceiveAccountNo() {
        return receiveAccountNo;
    }

    public void setReceiveAccountNo(int receiveAccountNo) {
        this.receiveAccountNo = receiveAccountNo;
    }

    public double getReceiveAccountBalance() {
        return receiveAccountBalance;
    }

    public void setReceiveAccountBalance(double receiveAccountBalance) {
        this.receiveAccountBalance = receiveAccountBalance;
    }

    public double getTransferredAmount() {
        return transferredAmount;
    }

    public void setTransferredAmount(double transferredAmount) {
        this.transferredAmount = transferredAmount;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private int sendAccountUserId;
    private int sendAccountNo;
    private double sendAccountBalance;
    private int receiveAccountUserId;
    private int receiveAccountNo;
    private double receiveAccountBalance;
    private double transferredAmount;
    private String error;

}
