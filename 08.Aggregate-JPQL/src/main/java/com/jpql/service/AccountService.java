package com.jpql.service;

import com.jpql.exception.BankException;

public interface AccountService {
    public Double getAverageBalance() throws BankException;
    public Long getTotalBalance() throws BankException;
    public Long getNumberOfAccounts() throws BankException;
    public Integer getMinimumBalance() throws BankException;
    public Integer getMaximumBalance() throws BankException;
}
