package com.jpql.service;

import com.jpql.exception.BankException;

import java.util.List;

public interface CustomerService {
    public List<Object[]> getCustomerDetails() throws BankException;
}
