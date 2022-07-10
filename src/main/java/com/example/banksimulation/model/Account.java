package com.example.banksimulation.model;


import com.example.banksimulation.enums.AccountStatus;
import com.example.banksimulation.enums.AccountType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class Account {

    private UUID id;
    private BigDecimal balance;
    private AccountStatus accountStatus;
    private AccountType accountType;
    private Date creationDate;
    private Long userId;

}
