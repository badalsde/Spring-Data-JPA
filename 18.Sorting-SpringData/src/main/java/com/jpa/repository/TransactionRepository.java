package com.jpa.repository;

import com.jpa.entity.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Integer> {
    public List<Transaction> findByTransactionDateAfter(LocalDate transactionDate, Pageable pageable);
}
