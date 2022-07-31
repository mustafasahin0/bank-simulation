package com.example.banksimulation.service;

import com.example.banksimulation.model.Account;
import com.example.banksimulation.enums.AccountType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface AccountService {

    Account createNewAccount(BigDecimal balance, Date creationDate, AccountType accountType, Long userId);

    List<Account> listAllAccount();

    void deleteAccount(UUID account);

    Account retrieveById(UUID account);
}
