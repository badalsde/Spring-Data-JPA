package com.jpa;

import com.jpa.dto.TransactionDTO;
import com.jpa.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

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
        //getAllTransactionByTransactionDateAfter();
	}
	public void getAllTransaction() {
		try {
			List<TransactionDTO> transactionList = transactionService.getAllTransaction(0, 5);
			transactionList.forEach(logger::info);
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),
					"Some exception occurred. Please check log file for more details!!");
			logger.info(message);
		}
	}
	public void getAllTransactionByTransactionDateAfter() {
		try {
			LocalDate transactionDate = LocalDate.of(1996, 1, 29);
			List<TransactionDTO> transactionList = transactionService.getAllTransactionByTransactionDateAfter(transactionDate, 0,2);
			transactionList.forEach(logger::info);
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),
					"Some exception occurred. Please check log file for more details!!");
			logger.info(message);
		}
	}
}
