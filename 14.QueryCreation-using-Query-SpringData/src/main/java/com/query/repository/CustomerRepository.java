package com.query.repository;

import com.query.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Query("SELECT c.name FROM Customer c WHERE c.emailId = :emailId")
    String findNameByEmailId(@Param("emailId") String emailId);

    @Query("UPDATE Customer c SET c.emailId = :emailId WHERE c.customerId = :customerId")
    @Modifying
    @Transactional
    Integer updateCustomerEmailId(@Param("emailId") String EmailId, @Param("customerId") Integer customerId);

    @Query("DELETE FROM Customer c WHERE c.emailId = :emailId")
    @Modifying
    @Transactional
    Integer deleteCustomerByEmailId(@Param("emailId") String emailId);
}
