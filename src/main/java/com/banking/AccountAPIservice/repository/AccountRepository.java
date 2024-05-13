package com.banking.AccountAPIservice.repository;

import com.banking.AccountAPIservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {

    //Find account by account id
    Account findById(long id);

    // Find accounts by account number
    List<Account> findByAccno(String accno);

    // Find accounts by name
    List<Account> findByName(String name);

    //Find account by phone number
    List<Account> findByPhoneno(long phoneno);

   // boolean getvalidationforaccount(String accountNo);

}
