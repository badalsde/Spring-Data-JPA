package com.query.service;

import com.query.exception.BankException;

public interface CustomerService {
    public String findNameByEmailId(String emailId) throws BankException;
}
