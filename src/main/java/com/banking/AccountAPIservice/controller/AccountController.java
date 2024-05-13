package com.banking.AccountAPIservice.controller;



import com.banking.AccountAPIservice.entity.Account;
import com.banking.AccountAPIservice.service.AccountService;
import com.banking.AccountAPIservice.service.NomineeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private NomineeService nomineeService;

    //To create a new account
    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody @Valid Account account){
        if(accountService.createAccount(account)!=null) {
            //accountService.createAccount(account)
           return new ResponseEntity<>("Account Created Successfully!", HttpStatus.CREATED);
        }
        else{
            String errorMessage = "Nominee account doesn't exist.";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }

    //To Get all accounts
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }
    //To get account details by using account number
    @GetMapping("/accno/{accno}")
    public ResponseEntity<List<Account>>getAccountByAccno(@PathVariable ("accno") String accno){
       return new ResponseEntity<>(accountService.getAccountByAccno(accno),HttpStatus.OK);
    }

    //To get account details by using by name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Account>> getAccountByName(@PathVariable ("name") String name){
            return new ResponseEntity<>(accountService.getAccountByName(name),HttpStatus.OK);
    }

    //To get account details by using phone number
    @GetMapping("/phoneno/{phoneno}")
    public ResponseEntity<List<Account>>getAccountByPhoneno(@PathVariable ("phoneno") long phoneno){
            return new ResponseEntity<>(accountService.getAccountByPhoneno(phoneno),HttpStatus.OK);
    }

    //To update phone number of account
    @PutMapping("/update/phone/{accno}")
    public ResponseEntity<String> updatePhonenoByAccno(@PathVariable ("accno") String accno, @RequestParam("phoneno") long newphoneno ){
            accountService.updateAccountPhoneno(accno,newphoneno);
            return new ResponseEntity<>(" Phone number Updated !",HttpStatus.OK);
    }

    //to update name of account
    @PutMapping("/update/name/{accno}")
    public ResponseEntity<String> updateNameByAccno(@PathVariable ("accno") String accno, @RequestParam ("name") String newname){
            accountService.updateAccountName(accno,newname);
            return new ResponseEntity<>("Name Updated !",HttpStatus.OK);

    }

    //to delete an account using id
    @DeleteMapping("/deletebyid/{id}")
    @Transactional
     public ResponseEntity<Object> deleteAccountById(@PathVariable ("id") long id){
            try {
                 accountService.deleteAccount(id);
                 return ResponseEntity.ok("Account Deleted successfully");
            } catch (Exception e) {
                 return new ResponseEntity<>("Errrrror !" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

