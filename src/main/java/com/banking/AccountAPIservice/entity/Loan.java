package com.banking.AccountAPIservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long loanid;

    @NotNull(message = "Loan amount is required")
    @Min(value = 1, message = "Loan amount must be greater than zero")
    private double amount;

    @Column(name = "interest_rate")
    @NotNull(message = "Interest rate is required")
    private double interestRate;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Account account; // Mapping to an Account entity

    // Required no-argument constructor for JPA
    public Loan() {
    }

    // Additional constructor for convenience
    public Loan(double amount, double interestRate, Account account) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.account = account;
    }

    // Getters and setters
    public long getLoanid() {

        return loanid;
    }

    public void setLoanid(long loanid) {
        this.loanid = loanid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
