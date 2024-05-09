package com.jpa.service;

import java.util.List;
import com.jpa.dto.CustomerDTO;
import com.jpa.exception.BankException;

public interface CustomerService {

    public void addCustomer(CustomerDTO customer) throws BankException;

    public CustomerDTO getCustomer(Integer customerId) throws BankException;

    public List<CustomerDTO> getAll() throws BankException;

}