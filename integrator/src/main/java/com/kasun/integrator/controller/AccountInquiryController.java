package com.kasun.integrator.controller;

import com.kasun.integrator.service.GetAccountBalanceService;
import com.kasun.integrator.service.GetAccountService;
import com.kasun.integrator.service.GetTotalAccountBalanceService;
import com.kasun.integrator.wsdl.Account;
import com.kasun.integrator.wsdl.GetTotalAccountBalanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountInquiryController {


    @Autowired
    private GetAccountService getAccountService;

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountNo}")
    public Account getAccount(@PathVariable int accountNo) {
        Account account = getAccountService.getAccount(accountNo);
        return account;
    }

    @Autowired
    private GetAccountBalanceService getAccountBalanceService;

    @RequestMapping(method = RequestMethod.GET, value = "/accountBalance/{accountNo}")
    public double getAccountBalance(@PathVariable int accountNo) {
        double balance = getAccountBalanceService.getAccountBalance(accountNo);
        return balance;
    }

    @Autowired
    private GetTotalAccountBalanceService getTotalAccountBalanceService;

    @RequestMapping(method = RequestMethod.GET, value = "/getTotalAccountBalance")
    public GetTotalAccountBalanceResponse getTotalAccountBalance(){
        GetTotalAccountBalanceResponse getTotalAccountBalanceResponse = getTotalAccountBalanceService.getTotalAccountBalance();
        return getTotalAccountBalanceResponse;
    }
}
