package com.example.banksimulation.repository;

import com.example.banksimulation.enums.AccountStatus;
import com.example.banksimulation.model.Account;
import com.example.banksimulation.exception.RecordNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class AccountRepository {

    public static List<Account> accountList = new ArrayList<>();

    public Account save(Account account) {
        accountList.add(account);
        return account;

    }

    public static List<Account> findAll() {
        return accountList;
    }

    public Account findById(UUID accountId) {
        return accountList.stream().filter(account -> account.getId().equals(accountId)).findAny().orElseThrow(() ->
                new RecordNotFoundException("This account is not in the database"));
    }

    public Account deleteAccount(Account account) {
        accountList.remove(findById(account.getId()));
        accountList.add(account);
        return account;

    }
}
