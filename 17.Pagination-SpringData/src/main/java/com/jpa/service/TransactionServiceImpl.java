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
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Service(value="transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    public List<TransactionDTO> getAllTransaction(Integer pageNo, Integer pageSize) throws TransException {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Transaction> page = transactionRepository.findAll(pageable);
        if(page.isEmpty()) {
            throw new TransException("Service.NO_TRANSACTION_IN_THIS_PAGE");
        }
        List<Transaction> transactions = page.getContent();
        List<TransactionDTO> transactionDTOs = new ArrayList<>();
        for(Transaction transaction : transactions) {
            TransactionDTO transactionDTO = new TransactionDTO();
            transactionDTO.setTransactionId(transaction.getTransactionId());
            transactionDTO.setTransactionDate(transaction.getTransactionDate());
            transactionDTO.setTransactionAmount(transaction.getTransactionAmount());
            transactionDTOs.add(transactionDTO);
        }
        return transactionDTOs;
    }

    @Override
    public List<TransactionDTO> getAllTransactionByTransactionDateAfter(LocalDate transactionDate, Integer pageNo, Integer pageSize) throws TransException {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
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
