package com.kasun.integrator.controller;

import com.kasun.integrator.model.FundTransferOther;
import com.kasun.integrator.model.FundTransferOwn;
import com.kasun.integrator.service.FundTransferOtherService;
import com.kasun.integrator.service.FundTransferOwnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundTransferController {
    @Autowired
    private FundTransferOtherService fundTransferOtherService;

    @RequestMapping(method = RequestMethod.GET, value = "/fundTransferOther/{accountNoSend}/{accountNoReceive}/{transferAmount}")
    public FundTransferOther fundTransferOther(@PathVariable(name = "accountNoSend") int accountNoSend, @PathVariable(name = "accountNoReceive") int accountNoReceive, @PathVariable(name = "transferAmount") double transferAmount) {
        FundTransferOther fundTransferOther = fundTransferOtherService.fundTransferOther(accountNoSend, accountNoReceive, transferAmount);
        return fundTransferOther;
    }

    @Autowired
    private FundTransferOwnService fundTransferOwnService;

    @RequestMapping(method = RequestMethod.GET,value = "/fundTransferOwn/{accountNoSend}/{accountNoReceive}/{transferAmount}")
    public FundTransferOwn fundTransferOwn(@PathVariable(name = "accountNoSend") int accountNoSend, @PathVariable(name = "accountNoReceive") int accountNoReceive, @PathVariable(name = "transferAmount") double transferAmount) {
        FundTransferOwn fundTransferOwn = fundTransferOwnService.fundTransferOwn(accountNoSend, accountNoReceive, transferAmount);

        return fundTransferOwn;
    }
}
