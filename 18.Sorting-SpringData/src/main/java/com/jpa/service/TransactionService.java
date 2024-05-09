package com.jpa.service;

import com.jpa.dto.TransactionDTO;
import com.jpa.exception.TransException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    public List<TransactionDTO> getAllTransaction(Sort sort) throws TransException;
    public List<TransactionDTO> getAllTransactionByTransactionDateAfter(LocalDate transactionDate, Pageable pageable) throws TransException;
}
