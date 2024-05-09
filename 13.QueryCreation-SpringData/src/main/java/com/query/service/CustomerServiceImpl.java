package com.query.service;

import com.query.dto.CustomerDTO;
import com.query.entity.Customer;
import com.query.exception.BankException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.query.repository.CustomerRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value="customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO findByEmailId(String emailId) throws BankException {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailId(emailId);
        Customer customer = optionalCustomer.orElseThrow(()-> new BankException("Service.CUSTOMER_UNAVAILABLE"));

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmailId(customer.getEmailId());
        customerDTO.setDateOfBirth(customer.getDateOfBirth());

        return customerDTO;
    }

    @Override
    public CustomerDTO findByEmailIdAndName(String emailId, String name) throws BankException {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailIdAndName(emailId, name);
        Customer customer = optionalCustomer.orElseThrow(()-> new BankException("Service.CUSTOMER_UNAVAILABLE"));

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmailId(customer.getEmailId());
        customerDTO.setDateOfBirth(customer.getDateOfBirth());

        return customerDTO;
    }

    @Override
    public List<CustomerDTO> findByEmailIdOrName(String emailId, String name) throws BankException {
        List<Customer> customers = customerRepository.findByEmailIdOrName(emailId, name);
        List<CustomerDTO>customerDTOS = new ArrayList<>();
        if(customers.isEmpty()){
            throw new BankException("Service.CUSTOMER_UNAVAILABLE");
        }
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerDTO> findByDateOfBirthBetween(LocalDate fromDate, LocalDate toDate) throws BankException {
        List<Customer> customers = customerRepository.findByDateOfBirthBetween(fromDate, toDate);
        List<CustomerDTO>customerDTOS = new ArrayList<>();
        if(customers.isEmpty()){
            throw new BankException("Service.CUSTOMER_UNAVAILABLE");
        }
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerDTO> findByDateOfBirthLessThan(LocalDate dateOfBirth) throws BankException {
        List<Customer> customers = customerRepository.findByDateOfBirthLessThan(dateOfBirth);
        List<CustomerDTO>customerDTOS = new ArrayList<>();
        if(customers.isEmpty()){
            throw new BankException("Service.CUSTOMER_UNAVAILABLE");
        }
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerDTO> findByDateOfBirthGreaterThan(LocalDate dateOfBirth) throws BankException {
        List<Customer> customers = customerRepository.findByDateOfBirthGreaterThan(dateOfBirth);
        List<CustomerDTO>customerDTOS = new ArrayList<>();
        if(customers.isEmpty()){
            throw new BankException("Service.CUSTOMER_UNAVAILABLE");
        }
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerDTO> findByDateOfBirthAfter(LocalDate dateOfBirth) throws BankException {
        List<Customer> customers = customerRepository.findByDateOfBirthAfter(dateOfBirth);
        List<CustomerDTO>customerDTOS = new ArrayList<>();
        if(customers.isEmpty()){
            throw new BankException("Service.CUSTOMER_UNAVAILABLE");
        }
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerDTO> findByDateOfBirthBefore(LocalDate dateOfBirth) throws BankException {
        List<Customer> customers = customerRepository.findByDateOfBirthBefore(dateOfBirth);
        List<CustomerDTO>customerDTOS = new ArrayList<>();
        if(customers.isEmpty()){
            throw new BankException("Service.CUSTOMER_UNAVAILABLE");
        }
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerDTO> findByEmailIdNull() throws BankException {
        List<Customer> customers = customerRepository.findByEmailIdNull();
        List<CustomerDTO>customerDTOS = new ArrayList<>();
        if(customers.isEmpty()){
            throw new BankException("Service.CUSTOMER_UNAVAILABLE");
        }
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerDTO> findByNameLike(String pattern) throws BankException {
        List<Customer> customers = customerRepository.findByNameLike(pattern);
        List<CustomerDTO>customerDTOS = new ArrayList<>();
        if(customers.isEmpty()){
            throw new BankException("Service.CUSTOMER_UNAVAILABLE");
        }
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerDTO> findByNameOrderByDateOfBirth(String name) throws BankException {
        List<Customer> customers = customerRepository.findByNameOrderByDateOfBirth(name);
        List<CustomerDTO>customerDTOS = new ArrayList<>();
        if(customers.isEmpty()){
            throw new BankException("Service.CUSTOMER_UNAVAILABLE");
        }
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerDTO> findByNameOrderByDateOfBirthDesc(String name) throws BankException {
        List<Customer> customers = customerRepository.findByNameOrderByDateOfBirthDesc(name);
        List<CustomerDTO>customerDTOS = new ArrayList<>();
        if(customers.isEmpty()){
            throw new BankException("Service.CUSTOMER_UNAVAILABLE");
        }
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }
}
