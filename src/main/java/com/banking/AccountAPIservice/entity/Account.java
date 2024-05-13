package com.banking.AccountAPIservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;


@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "accno")
    @NotBlank(message = "Acccount number is required")
    private String accno;

    @NotBlank(message = "Name is required")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Account type cannot be blank")
    @Column(name = "acc type")
    private String acc_type;

    @Column(name = "phone_no")
    @NotNull(message = "Phone number is required")
    @Digits(integer = 10, fraction = 0, message = "Phone number must be a valid 10-digit number")
    private long phoneno;

    @Column(name = "balance")
    @NotNull(message = "Balance cannot be null")
    @Min(value = 0, message = "Balance cannot be negative")
    private long balance;

    @Column(name = "nominee")
    private String nominee_accno;

    //Constructors
    public Account() {
    }

    public Account(long id, String accno, String name, String acc_type, long phoneno, long balance, String nominee_accno) {
        this.id = id;
        this.accno = accno;
        this.name = name;
        this.acc_type = acc_type;
        this.phoneno = phoneno;
        this.balance = balance;
        this.nominee_accno = nominee_accno;
    }

    public Account(long id, String accno, String name, String acc_type, long phoneno, long balance) {
        this.id = id;
        this.accno = accno;
        this.name = name;
        this.acc_type = acc_type;
        this.phoneno = phoneno;
        this.balance = balance;
    }

    //Getter
    public long getId() {
        return id;
    }

    public String getAccno() {
        return accno;
    }

    public String getName() {
        return name;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public long getPhoneno() {
        return phoneno;
    }

    public long getBalance() {
        return balance;
    }

    public String getNominee_accno() {
        return nominee_accno;
    }

    //Setter
    public void setId(long id) {
        this.id = id;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }

    public void setPhoneno(long phoneno) {
        this.phoneno = phoneno;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setNominee_accno(String nominee_accno) {
        this.nominee_accno = nominee_accno;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accno='" + accno + '\'' +
                ", name='" + name + '\'' +
                ", acc_type='" + acc_type + '\'' +
                ", phoneno=" + phoneno +
                ", balance=" + balance +
                ", nominee_accno=" + nominee_accno +
                '}';
    }
}