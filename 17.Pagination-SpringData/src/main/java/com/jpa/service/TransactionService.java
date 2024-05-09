package com.jpa.service;

import com.jpa.dto.TransactionDTO;
import com.jpa.exception.TransException;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    public List<TransactionDTO> getAllTransaction(Integer pageNo, Integer pageSize) throws TransException;
    public List<TransactionDTO> getAllTransactionByTransactionDateAfter(LocalDate transactionDate, Integer pageNo,Integer pageSize) throws TransException;
}
