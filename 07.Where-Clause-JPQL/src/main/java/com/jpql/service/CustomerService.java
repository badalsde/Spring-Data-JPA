package com.jpql.service;

import com.jpql.dto.CustomerDTO;
import com.jpql.exception.BankException;

import java.util.List;

public interface CustomerService {
    public List<CustomerDTO> getCustomerDetails() throws BankException;
}
