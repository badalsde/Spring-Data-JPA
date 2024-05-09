package com.jpql.service;

import com.jpql.dto.CustomerDTO;
import com.jpql.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value ="customerService")
public class CustomerServiceImpl implements CustomerRepository {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> getCustomerDetails() {
        return customerRepository.getCustomerDetails();
    }

    @Override
    public List<Object[]> getCustomerNameAndDob() {
        return customerRepository.getCustomerNameAndDob();
    }

    @Override
    public List<String> getCustomerName() {
        return customerRepository.getCustomerName();
    }
}
