package com.query.service;

import com.query.exception.BankException;
import com.query.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String findNameByEmailId(String emailId) throws BankException {
        return customerRepository.findNameByEmailId(emailId);
    }
}
