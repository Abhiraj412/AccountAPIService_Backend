package com.banking.AccountAPIservice.service;

import com.banking.AccountAPIservice.entity.Account;
import com.banking.AccountAPIservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    //for account creation
    public Account createAccount(Account account){
        try {
            if(account.getNominee_accno()!=null){
                List<Account> nominee= accountRepository.findByAccno(account.getNominee_accno());
                if(!nominee.isEmpty()){
                    return accountRepository.save(account);
                }
                else{
                    throw new RuntimeException();
                }
            }
            else{
                return accountRepository.save(account);
            }
        }
        catch(Exception e){
            return null;
        }
    }


    //For Getting all accounts
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    //For Getting account details through various fields
    //Using account number
    public List<Account> getAccountByAccno(String accno) {
        return accountRepository.findByAccno(accno);
    }

    //Using name
    public List<Account> getAccountByName(String name) {
        return accountRepository.findByName(name);
    }

    //Using phone number
    public List<Account> getAccountByPhoneno(Long phoneno) {
        return accountRepository.findByPhoneno(phoneno);
    }

    //Update account for various fields
    //updating name
    public ResponseEntity<Account> updateAccountName(String accno, String newname) {
        List<Account> accounts=accountRepository.findByAccno(accno);
        if(!accounts.isEmpty()) {
           Account account=accounts.get(0);
            account.setName(newname);
            return new ResponseEntity<>(accountRepository.save(account),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //Updating phone number
    public ResponseEntity<Account> updateAccountPhoneno(String accno, long newphoneno) {
        List<Account> accounts=accountRepository.findByAccno(accno);
        if(!accounts.isEmpty()) {
            Account account=accounts.get(0);
            account.setPhoneno(newphoneno);
            return new ResponseEntity<>(accountRepository.save(account),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //deleting account
    public ResponseEntity<Object> deleteAccount(Long id) {
        Optional<Account> account=accountRepository.findById(id);
        if(!account.isEmpty()) {
            accountRepository.deleteById(id);
            return ResponseEntity.ok("Account deleted succesfully");
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
