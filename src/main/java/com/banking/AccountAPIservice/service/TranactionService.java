package com.banking.AccountAPIservice.service;

import com.banking.AccountAPIservice.entity.Account;
import com.banking.AccountAPIservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranactionService {
    @Autowired
    AccountRepository accountRepository;

    public String deposit(String accno,long amount){
        List<Account> accounts=accountRepository.findByAccno(accno);
        if(!accounts.isEmpty()){
            for(Account toiterate:accounts){
                Account account=toiterate;
                account.setBalance(account.getBalance()+amount);
                accountRepository.save(account);
            }

            return "Amount Deposited Successfully !";
        }else {
             return "Account not found with entered account number";
        }
    }

    public String withdraw(String accno, long amount) {
        List<Account> accounts = accountRepository.findByAccno(accno);
        if (!accounts.isEmpty()) {
            for (Account toiterate : accounts) {
                Account account = toiterate;
                if (account.getBalance() > amount) {
                    account.setBalance(account.getBalance() - amount);
                    accountRepository.save(account);
                    return "Amount withdraw Successfully !";

                } else {
                    return "Amount to be withdrawn is larger than your balance";
                }
            }
        }
        return "Account not found with entered account number";

    }
}
