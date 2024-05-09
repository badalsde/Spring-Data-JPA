package com.query.service;

import com.query.entity.Customer;
import com.query.exception.BankException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.query.repository.CustomerRepository;

import java.util.Optional;

@Service(value="customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String findNameByEmailId(String emailId) throws BankException {
        return customerRepository.findNameByEmailId(emailId);
    }

    @Override
    public void updateCustomerEmailId(String newEmailId, Integer customerId) throws BankException {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        Customer customer = optionalCustomer.orElseThrow(()->new BankException("Service.CUSTOMER_UNAVAILABLE"));
        customerRepository.updateCustomerEmailId(newEmailId, customerId);
    }

    @Override
    public void deleteCustomerByEmailId(String emailId) throws BankException {
        Integer count = customerRepository.deleteCustomerByEmailId(emailId);
        if(count==0){
            throw new BankException("Service.CUSTOMER_UNAVAILABLE");
        }
    }
}
