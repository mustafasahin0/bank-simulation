package com.example.banksimulation.service;

import com.example.banksimulation.model.Account;
import com.example.banksimulation.model.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TransactionService {

    Transaction makeTransfer(BigDecimal amount, Date creationDate, Account sender, Account receiver, String message);

    List<Transaction> findAll();

    List<Transaction> retrieveLastTransaction();

    List<Transaction> findTransactionListById(UUID id);
}
