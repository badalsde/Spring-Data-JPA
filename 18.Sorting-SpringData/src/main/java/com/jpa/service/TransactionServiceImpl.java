package com.jpa.service;

import com.jpa.dto.TransactionDTO;
import com.jpa.entity.Transaction;
import com.jpa.exception.TransException;
import com.jpa.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Service(value="transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    public List<TransactionDTO> getAllTransaction(Sort sort) throws TransException {
        Iterable<Transaction> transactions = transactionRepository.findAll(sort);

        List<TransactionDTO> transactionDTOs = new ArrayList<>();
        for(Transaction transaction : transactions) {
            TransactionDTO transactionDTO = new TransactionDTO();
            transactionDTO.setTransactionId(transaction.getTransactionId());
            transactionDTO.setTransactionDate(transaction.getTransactionDate());
            transactionDTO.setTransactionAmount(transaction.getTransactionAmount());
            transactionDTOs.add(transactionDTO);
        }
        if(transactionDTOs.isEmpty()){
            throw new TransException("Service.NO_TRANSACTION_AVAILABLE");
        }
        return transactionDTOs;
    }

    @Override
    public List<TransactionDTO> getAllTransactionByTransactionDateAfter(LocalDate transactionDate, Pageable pageable) throws TransException {
        List<Transaction> transactions = transactionRepository.findByTransactionDateAfter(transactionDate, pageable);
        if (transactions.isEmpty()) {
            throw new TransException("Service.NO_TRANSACTION_IN_THIS_PAGE");
        }
        List<TransactionDTO> transactionDTOs = new ArrayList<>();
        for (Transaction transaction : transactions) {
            TransactionDTO transactionDTO = new TransactionDTO();
            transactionDTO.setTransactionId(transaction.getTransactionId());
            transactionDTO.setTransactionDate(transaction.getTransactionDate());
            transactionDTO.setTransactionAmount(transaction.getTransactionAmount());
            transactionDTOs.add(transactionDTO);
        }
        return transactionDTOs;
    }
}
