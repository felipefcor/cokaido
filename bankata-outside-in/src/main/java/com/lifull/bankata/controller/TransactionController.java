package com.lifull.bankata.controller;

import com.lifull.bankata.domain.AccountService;
import com.lifull.bankata.infrastructure.TransactionInterface;
import com.lifull.bankata.timeserver.TimeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {
     @Autowired
    TransactionInterface repository;
    @Autowired
    TimeServer timeServer;

    @GetMapping("/statement")
    public ResponseEntity<Object> transaction() {
        return new ResponseEntity<>(repository.getStatement(), HttpStatus.OK);
    }

    @PostMapping(value = "/deposit", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addDeposit(@RequestBody TransactionUseCase transactionUseCase) {
        AccountService accountService = new AccountService(repository, timeServer);
        try {
            accountService.deposit(transactionUseCase.amount);
            return new ResponseEntity<>("Deposit added correctly", HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/withdrawal", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addWithdrawal(@RequestBody TransactionUseCase transactionUseCase) {
        AccountService accountService = new AccountService(repository, timeServer);
        try {
            accountService.withdraw(transactionUseCase.amount);
            return new ResponseEntity<>("Withdrawal added correctly", HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
