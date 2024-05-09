package com.jpa.service;

import com.jpa.dto.CustomerDTO;
import com.jpa.exception.BankException;

public interface CustomerService {
    public void addCustomer(CustomerDTO customer) throws BankException;
}
