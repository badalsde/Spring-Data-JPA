package com.jpql.service;

import com.jpql.exception.BankException;

public interface CustomerService {
    public Integer updateCityOfCustomer(Integer customerId, String city) throws BankException;
    public Integer deleteCustomer() throws BankException;
}
