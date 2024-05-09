package com.jpql.service;

import com.jpql.dto.CustomerDTO;
import com.jpql.exception.BankException;

import java.util.List;

public interface CustomerService {
    public List<CustomerDTO> getCustomerDetails() throws BankException;
    public List<Object[]> getCustomerNameAndDob() throws BankException;
    public List<String> getCustomerName() throws BankException;
}
