package com.jpql.repository;

import com.jpql.dto.CustomerDTO;
import com.jpql.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository(value = "customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomerDTO> getCustomerDetails() {
        List<CustomerDTO> customerDTOs = null;
        String queryString = "select c from Customer c";
        Query query = entityManager.createQuery(queryString);
        List<Customer> customers = query.getResultList();
        customerDTOs = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTOs.add(customerDTO);
        }
       return customerDTOs;
    }

    @Override
    public List<Object[]> getCustomerNameAndDob() {
        String queryString = "SELECT c.name, c.dateOfBirth FROM Customer c";
        Query query = entityManager.createQuery(queryString);
        List<Object[]> customers = query.getResultList();
        return customers;
    }

    @Override
    public List<String> getCustomerName() {
        List<String> customerNames = null;
        String queryString = "select c.name from Customer c";
        Query query = entityManager.createQuery(queryString);
        customerNames = query.getResultList();
        return customerNames;
    }

}
