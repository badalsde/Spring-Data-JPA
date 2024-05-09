package com.jpql.service;

import com.jpql.exception.BankException;
import com.jpql.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepositoryImpl customerRepository;

    @Override
    public List<Object[]> getCustomerDetails() throws BankException {
        return customerRepository.getCustomerCountForCities();
    }
}
