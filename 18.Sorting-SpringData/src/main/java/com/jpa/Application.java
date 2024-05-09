package com.jpa;

import com.jpa.dto.TransactionDTO;
import com.jpa.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(Application.class);
	@Autowired
	private TransactionServiceImpl transactionService;

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		getAllTransaction();
        getAllTransactionByTransactionDateAfter();
	}
	public void getAllTransaction(){
		try {
			Sort sort = Sort.by("transactionDate");
			List<TransactionDTO> transactionDTOs = transactionService.getAllTransaction(sort);
			transactionDTOs.forEach(logger::info);
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),
					"Some exception occured. Please check log file for more details!!");
			logger.info(message);
		}
	}
	public void getAllTransactionByTransactionDateAfter(){
		try {
			LocalDate transactionDate = LocalDate.of(1996, 1, 29);
			Sort sort = Sort.by("transactionDate");
			Pageable pageable = PageRequest.of(0, 2,sort);

			List<TransactionDTO> transactionDTOs = transactionService.getAllTransactionByTransactionDateAfter(transactionDate, pageable);
			transactionDTOs.forEach(logger::info);

		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),
					"Some exception occured. Please check log file for more details!!");
			logger.info(message);
		}
	}
}
