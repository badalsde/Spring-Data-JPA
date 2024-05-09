package com.jpql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private Integer accountNumber;
    private String accountType;
    private LocalDate openingDate;
    private Integer balance;
    private String accountStatus;
}
