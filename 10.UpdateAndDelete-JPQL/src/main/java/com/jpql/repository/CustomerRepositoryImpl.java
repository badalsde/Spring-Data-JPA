package com.jpql.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Integer updateCityOfCustomer(Integer customerId, String city) {
        String queryString = "update Customers c set c.city=?1 where c.customerId=?2";
        Query query = entityManager.createQuery(queryString);
        query.setParameter(1, city);
        query.setParameter(2, customerId);
        return query.executeUpdate();
    }

    @Override
    public Integer deleteCustomer() {
        String queryString = "DELETE FROM Customers c where c.emailId is NULL";
        Query query = entityManager.createQuery(queryString);
        return query.executeUpdate();
    }
}
