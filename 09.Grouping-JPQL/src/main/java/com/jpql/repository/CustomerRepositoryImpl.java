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
    public List<Object[]> getCustomerCountForCities() {
        String queryString1 = "select c.city, count(c) from Customers c group by c.city";
        String queryString2 = "select c.city, count(c) from Customers c group by c.city having c.city IN ('Pune','Delhi')";
        Query query = entityManager.createQuery(queryString2);
        return (List<Object[]>) query.getResultList();
    }
}
