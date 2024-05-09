package com.jpql.service;

import com.jpql.dto.CustomerDTO;
import com.jpql.exception.BankException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpql.repository.CustomerRepositoryImpl;

import java.util.List;

@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepositoryImpl customerRepository;

    @Override
    public List<CustomerDTO> getCustomerDetails() throws BankException {
        return customerRepository.getCustomerDetails();
    }
}
