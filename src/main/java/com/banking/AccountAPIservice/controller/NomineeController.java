package com.banking.AccountAPIservice.controller;

import com.banking.AccountAPIservice.service.NomineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NomineeController {

    @Autowired
    NomineeService nomineeService;

    //to update nominee to account
    @PutMapping("/assign/nominee/{accno}/{nominee_accno}")
    public ResponseEntity<String> assignNominee(@PathVariable("accno") String accno, @PathVariable("nominee_accno") String nomineeAccno) {
       // nomineeService.assignNominee(accno, nomineeAccno);
        return nomineeService.assignNominee(accno, nomineeAccno);
    }

}
