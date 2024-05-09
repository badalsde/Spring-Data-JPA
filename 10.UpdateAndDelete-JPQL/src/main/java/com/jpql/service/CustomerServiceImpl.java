package com.jpql.service;

import com.jpql.exception.BankException;
import com.jpql.repository.CustomerRepositoryImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepositoryImpl customerRepository;

    @Override
    public Integer updateCityOfCustomer(Integer customerId, String city) throws BankException {
        return customerRepository.updateCityOfCustomer(customerId, city);
    }

    @Override
    public Integer deleteCustomer() throws BankException {
        return customerRepository.deleteCustomer();
    }
}
