package com.query.repository;

import com.query.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    String findNameByEmailId(@Param("emailId") String emailId);
}
