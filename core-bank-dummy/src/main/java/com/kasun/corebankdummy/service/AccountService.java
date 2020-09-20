package com.kasun.corebankdummy.service;

import com.kasun.corebankdummy.Account;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class AccountService {

    private static final Map<Integer, Account> accounts = new HashMap<>();

    @PostConstruct
    public void initialize() {

        Account ac123123123 = new Account();
        ac123123123.setAccountNo(123123123);
        ac123123123.setUserId(111);
        ac123123123.setBalance(1000);

        Account ac456456456 = new Account();
        ac456456456.setAccountNo(456456456);
        ac456456456.setUserId(111);
        ac456456456.setBalance(2000);

        Account ac789789789 = new Account();
        ac789789789.setAccountNo(789789789);
        ac789789789.setUserId(222);
        ac789789789.setBalance(2320);

        Account ac567567567 = new Account();
        ac567567567.setAccountNo(567567567);
        ac567567567.setUserId(333);
        ac567567567.setBalance(1230);

        accounts.put(ac123123123.getAccountNo(), ac123123123);
        accounts.put(ac456456456.getAccountNo(), ac456456456);
        accounts.put(ac789789789.getAccountNo(), ac789789789);
        accounts.put(ac567567567.getAccountNo(), ac567567567);

    }

    public static Account getAccounts(int accNO) {
        return accounts.get(accNO);
    }

    public static Account balanceUpdate(int accNO, double newBalance) {
        Account account = accounts.get(accNO);
        account.setBalance(newBalance);
        accounts.replace(account.getAccountNo(), account);
        Account updatedAccount = accounts.get(accNO);
        return updatedAccount;
    }

    public static double getTotalAccountBalance(){
        double totalBalance= 0.0;
        Iterator iterator = accounts.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry map = (Map.Entry) iterator.next();
              Account account = (Account) map.getValue();
              totalBalance = totalBalance + account.getBalance();
        }

        return totalBalance;
    }
}
