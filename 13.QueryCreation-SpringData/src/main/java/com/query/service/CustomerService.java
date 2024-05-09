package com.query.service;

import com.query.dto.CustomerDTO;
import com.query.exception.BankException;
import java.time.LocalDate;
import java.util.List;

public interface CustomerService {

   public CustomerDTO findByEmailId(String emailId) throws BankException;
   public CustomerDTO findByEmailIdAndName(String emailId, String name) throws BankException;
   public List<CustomerDTO> findByEmailIdOrName(String emailId, String name) throws BankException;
   public List<CustomerDTO> findByDateOfBirthBetween(LocalDate fromDate, LocalDate toDate) throws BankException;
   public List<CustomerDTO> findByDateOfBirthLessThan(LocalDate dateOfBirth) throws BankException;
   public List<CustomerDTO> findByDateOfBirthGreaterThan(LocalDate dateOfBirth) throws BankException;
   public List<CustomerDTO> findByDateOfBirthAfter(LocalDate dateOfBirth) throws BankException;
   public List<CustomerDTO> findByDateOfBirthBefore(LocalDate dateOfBirth) throws BankException;
   public List<CustomerDTO> findByEmailIdNull() throws BankException;
   public List<CustomerDTO> findByNameLike(String pattern) throws BankException;
   public List<CustomerDTO> findByNameOrderByDateOfBirth(String name) throws BankException;
   public List<CustomerDTO> findByNameOrderByDateOfBirthDesc(String name) throws BankException;

}
