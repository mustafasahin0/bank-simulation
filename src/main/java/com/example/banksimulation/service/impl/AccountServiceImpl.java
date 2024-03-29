package com.example.banksimulation.service.impl;

import com.example.banksimulation.enums.AccountStatus;
import com.example.banksimulation.model.Account;
import com.example.banksimulation.enums.AccountType;
import com.example.banksimulation.repository.AccountRepository;
import com.example.banksimulation.service.AccountService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createNewAccount(BigDecimal balance, Date creationDate, AccountType accountType, Long userId) {
        Account account = Account.builder().id(UUID.randomUUID())
                .userId(userId).accountType(accountType).balance(balance).creationDate(creationDate).accountStatus(AccountStatus.ACTIVE).build();
        return accountRepository.save(account);
    }

    @Override
    public List<Account> listAllAccount() {
        return AccountRepository.findAll();
    }

    @Override
    public void deleteAccount(UUID accountId) {
        Account account = accountRepository.findById(accountId);
        account.setAccountStatus(AccountStatus.DELETED);
        accountRepository.deleteAccount(account);
    }

    @Override
    public Account retrieveById(UUID account) {
        return accountRepository.findById(account);
    }

}
