package com.jpql.repository;

import java.util.List;

public interface CustomerRepository {
    public Integer updateCityOfCustomer(Integer customerId,String city);
    public Integer deleteCustomer();
}
