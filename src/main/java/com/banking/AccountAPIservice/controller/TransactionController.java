package com.banking.AccountAPIservice.controller;

import com.banking.AccountAPIservice.entity.Account;
import com.banking.AccountAPIservice.service.TranactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TranactionService tranactionService;

    @PutMapping("/deposit/{accno}")
    public ResponseEntity<String> deposit(@PathVariable ("accno") String accno, @RequestParam ("amount") long amount){
        return new ResponseEntity<>(tranactionService.deposit(accno,amount), HttpStatus.OK);
    }

    @PutMapping("/withdraw/{accno}")
    public ResponseEntity<String> withdraw(@PathVariable ("accno") String accno, @RequestParam ("amount") long amount){
        return new ResponseEntity<>(tranactionService.withdraw(accno,amount), HttpStatus.OK);
    }
}
