package com.jpql.repository;

import java.util.List;
import com.jpql.dto.CustomerDTO;

public interface CustomerRepository{
    public List<CustomerDTO> getCustomerDetails();
    public List<Object[]> getCustomerNameAndDob();
    public List<String> getCustomerName();
}
