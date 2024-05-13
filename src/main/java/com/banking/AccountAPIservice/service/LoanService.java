package com.banking.AccountAPIservice.service;

import com.banking.AccountAPIservice.entity.Account;
import com.banking.AccountAPIservice.entity.Loan;
import com.banking.AccountAPIservice.repository.AccountRepository;
import com.banking.AccountAPIservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private AccountRepository accountRepository;

    //To create a loan account
    public Loan createLoan(long accountId, Loan loan) {
        Account account = accountRepository.findById(accountId);
        if (account != null) {
            loan.setAccount(account);
            return loanRepository.save(loan);
        }else{
            return null;
        }
    }

    //To update a loan account
    public Loan updateLoan(long loanId, Loan updatedLoan) {
        Loan loan = loanRepository.findByLoanid(loanId);
        if(loan!=null) {
            loan.setAmount(updatedLoan.getAmount());
            loan.setInterestRate(updatedLoan.getInterestRate());
            return loanRepository.save(loan);
        }
        else{
            return null;
        }
    }

    //To get a loan account
    public Loan getLoan(long loanId) {
        return loanRepository.findByLoanid(loanId);
    }

    //To get all loan accounts
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    //to delete a loan accounts
    public void deleteLoan(long loanId) throws RuntimeException {
        Loan loan = loanRepository.findByLoanid(loanId);
        if(loan!=null) {
            loanRepository.delete(loan);
        }
        else{
            throw new RuntimeException();
        }
    }
}
