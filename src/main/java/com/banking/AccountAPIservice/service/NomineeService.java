package com.banking.AccountAPIservice.service;

import com.banking.AccountAPIservice.entity.Account;
import com.banking.AccountAPIservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NomineeService {

        @Autowired
        private AccountRepository accountRepository;

        //To assign a nominee
        public ResponseEntity<String> assignNominee(String accno, String nomineeAccno) {
            List<Account> accounts = accountRepository.findByAccno(accno);
            List<Account> nominee = accountRepository.findByAccno(nomineeAccno);
            if(accounts.isEmpty()){
                return new ResponseEntity<>("Account Number not found!",HttpStatus.NOT_FOUND);

            } else if (nominee.isEmpty()) {
                return new ResponseEntity<>("Nominee Account Number not existed!",HttpStatus.NOT_FOUND);

            }
            else{
                for(Account it:accounts){
                    it.setNominee_accno(nomineeAccno);
                    accountRepository.save(it);
                }
            }
            return new ResponseEntity<>("Nominee Assign Successfully !",HttpStatus.OK);
        }

}
