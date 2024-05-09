package com.jpa.service;

import com.jpa.dto.CustomerDTO;
import com.jpa.entity.Customer;
import com.jpa.exception.BankException;
import com.jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addCustomer(CustomerDTO customerDTO) throws BankException {
         Optional<Customer> optional = customerRepository.findById(customerDTO.getCustomerId());
         if(optional.isPresent()){
             throw new BankException("Customer already exists");
         }
         Customer customer = new Customer();
         customer.setCustomerId(customerDTO.getCustomerId());
         customer.setName(customerDTO.getName());
         customer.setEmailId(customerDTO.getEmailId());
         customer.setDateOfBirth(customerDTO.getDateOfBirth());
         customerRepository.save(customer);
    }
}
