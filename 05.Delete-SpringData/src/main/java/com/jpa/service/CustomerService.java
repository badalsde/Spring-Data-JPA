package com.jpa.service;

import com.jpa.dto.CustomerDTO;
import com.jpa.exception.BankException;

import java.util.List;

public interface CustomerService{
    public void addCustomer(CustomerDTO customer) throws BankException;
    public CustomerDTO getCustomer(Integer customerId) throws BankException;
    public List<CustomerDTO> getAll() throws BankException;
    public void updateCustomer(Integer customerId, String emailId) throws BankException;
    public void deleteCustomer(Integer customerId) throws BankException;
}
