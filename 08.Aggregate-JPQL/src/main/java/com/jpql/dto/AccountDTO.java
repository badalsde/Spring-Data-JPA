package com.jpql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Integer accountNumber;
    private String accountType;
    private LocalDate openingDate;
    private Integer balance;
    private String accountStatus;
}
