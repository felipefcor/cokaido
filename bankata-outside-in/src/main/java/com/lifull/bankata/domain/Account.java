package com.lifull.bankata.domain;

import com.lifull.bankata.infrastructure.TransactionInterface;
import com.lifull.bankata.printable.Printable;
import com.lifull.bankata.repositories.Deposit;
import com.lifull.bankata.repositories.Withdrawal;
import com.lifull.bankata.timeserver.TimeServer;

public class Account {

    private final TransactionInterface repository;
    private final Printable printer;
    private TimeServer timeServer;

    public Account(TransactionInterface repository, Printable printer, TimeServer timeServer) {
        this.repository = repository;
        this.printer = printer;
        this.timeServer = timeServer;
    }

    public void deposit(int amount) {
        repository.save(new Deposit(amount, timeServer.getDate()));
    }

    public void withdraw(int amount) {
        repository.save(new Withdrawal(amount, timeServer.getDate()));
    }

    public void printStatement() {
        printer.print(repository.getStatement());
    }
}

