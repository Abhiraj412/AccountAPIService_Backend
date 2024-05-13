package com.banking.AccountAPIservice.repository;

import com.banking.AccountAPIservice.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    Loan findByLoanid(long loanid);
}
