package com.jpql.repository;

import com.jpql.dto.CustomerDTO;

import java.util.List;

public interface CustomerRepository {
    public List<CustomerDTO> getCustomerDetails();
}
