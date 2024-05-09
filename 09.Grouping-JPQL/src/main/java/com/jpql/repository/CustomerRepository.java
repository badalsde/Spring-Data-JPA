package com.jpql.repository;

import java.util.List;

public interface CustomerRepository {
    public List<Object[]> getCustomerCountForCities();
}
