package com.query.service;

import com.query.exception.BankException;

public interface CustomerService {
   public String findNameByEmailId(String emailId) throws BankException;
   public void updateCustomerEmailId(String newEmailId, Integer customerId) throws BankException;
   public void deleteCustomerByEmailId(String emailId) throws BankException;
}
