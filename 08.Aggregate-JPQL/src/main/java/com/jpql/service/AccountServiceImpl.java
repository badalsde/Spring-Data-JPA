package com.jpql.service;

import com.jpql.exception.BankException;
import com.jpql.repository.AccountRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepositoryImpl accountRepository;

    @Override
    public Double getAverageBalance() throws BankException {
        return accountRepository.getAverageBalance();
    }

    @Override
    public Long getTotalBalance() throws BankException {
        return accountRepository.getTotalBalance();
    }

    @Override
    public Long getNumberOfAccounts() throws BankException {
        return accountRepository.getNumberOfAccounts();
    }

    @Override
    public Integer getMinimumBalance() throws BankException {
        return accountRepository.getMinimumBalance();
    }

    @Override
    public Integer getMaximumBalance() throws BankException {
        return accountRepository.getMaximumBalance();
    }
}
