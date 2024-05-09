package com.jpa.service;

import com.jpa.dto.CustomerDTO;
import com.jpa.entity.Customer;
import com.jpa.exception.BankException;
import com.jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addCustomer(CustomerDTO customerDTO) throws BankException {
    Optional<Customer> optional = customerRepository.findById(customerDTO.getCustomerId());
    if(optional.isPresent()) {
        throw new BankException("Customer already exists");
    }
    Customer customer = new Customer();
    customer.setCustomerId(customerDTO.getCustomerId());
    customer.setName(customerDTO.getName());
    customer.setEmailId(customerDTO.getEmailId());
    customer.setDateOfBirth(customerDTO.getDateOfBirth());
    customerRepository.save(customer);
    }

    @Override
    public CustomerDTO getCustomer(Integer customerId) throws BankException {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        Customer customer = optionalCustomer.orElseThrow(()-> new BankException("Customer not found"));
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmailId(customer.getEmailId());
        customerDTO.setDateOfBirth(customer.getDateOfBirth());
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAll() throws BankException {
        Iterable<Customer> customers= customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        customers.forEach(customer->{
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTOS.add(customerDTO);
        });
        if(customerDTOS.isEmpty()){
            throw new BankException("No customers found");
        }
        return customerDTOS;
    }
}
