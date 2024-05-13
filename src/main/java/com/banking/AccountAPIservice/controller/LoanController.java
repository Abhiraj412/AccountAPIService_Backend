package com.banking.AccountAPIservice.controller;

import com.banking.AccountAPIservice.entity.Loan;
import com.banking.AccountAPIservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    //To  create a new loan account
    @PostMapping("/create/{accountId}")
    public ResponseEntity<String> createLoan(@PathVariable long accountId, @RequestBody Loan loan) {
        Loan newLoan = loanService.createLoan(accountId, loan);
        if (newLoan != null) {
            return new ResponseEntity<>("New loan account created successfully !", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Person Don't have a existing account with this account number!",HttpStatus.BAD_REQUEST);
        }
    }

    // To update an existing loan
    @PutMapping("/update/{loanId}")
    public ResponseEntity<String> updateLoan(@PathVariable long loanId, @RequestBody Loan updatedLoan) {
        Loan loan = loanService.updateLoan(loanId, updatedLoan);
        if (loan != null) {
            return new ResponseEntity<>("Loan Updated Successfully !", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Loan did not update !",HttpStatus.NOT_FOUND);
        }
    }

    //To retrieve a specific loan by ID
    @GetMapping("/get/{loanId}")
    public ResponseEntity<Loan> getLoan(@PathVariable long loanId) {
        Loan loan = loanService.getLoan(loanId);
        if (loan != null) {
            return new ResponseEntity<>(loan, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // TO retrieve all loans
    @GetMapping("/get/all")
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.getAllLoans();
        if(loans.isEmpty()) {
            return new ResponseEntity<>(loans, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    // To delete a specific loan by ID
    @DeleteMapping("/delete/{loanId}")
    public ResponseEntity<String> deleteLoan(@PathVariable long loanId) {
        try {
            loanService.deleteLoan(loanId);
            return new ResponseEntity<>("Loan account deleted successfully !",HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("loan account is not deleted",HttpStatus.NOT_FOUND);
        }
    }
}
