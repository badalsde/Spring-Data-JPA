package com.jpql;

import com.jpql.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(Application.class);
	@Autowired
	private AccountServiceImpl accountService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        getAverageBalance();
        getTotalBalance();
        getNumberOfAccounts();
        getMinimumBalance();
        getMaximumBalance();
	}

	public void getAverageBalance(){
		Double maxBalance;
		try {
            maxBalance = accountService.getAverageBalance();
			logger.info("MAX_BALANCE: "+maxBalance);
        } catch (Exception e) {
            logger.info(e.getMessage(),"Some exception occured. Please check log file for more details!!");
        }
	}
	public void getTotalBalance(){
		Long totalBalance;
        try {
            totalBalance = accountService.getTotalBalance();
            logger.info("TOTAL_BALANCE: "+totalBalance);
        } catch (Exception e) {
            logger.info(e.getMessage(),"Some exception occured. Please check log file for more details!!");
        }
	}
	public void getNumberOfAccounts(){
		Long numberOfAccounts;
        try {
            numberOfAccounts = accountService.getNumberOfAccounts();
            logger.info("NUMBER_OF_ACCOUNTS: "+numberOfAccounts);
        } catch (Exception e) {
            logger.info(e.getMessage(),"Some exception occured. Please check log file for more details!!");
        }
	}
	public void getMinimumBalance(){
		Integer minBalance;
        try {
            minBalance = accountService.getMinimumBalance();
            logger.info("MIN_BALANCE: "+minBalance);
        } catch (Exception e) {
            logger.info(e.getMessage(),"Some exception occured. Please check log file for more details!!");
        }
	}
	public void getMaximumBalance(){
		Integer maxBalance;
        try {
            maxBalance = accountService.getMaximumBalance();
            logger.info("MAX_BALANCE: " +maxBalance);
        } catch (Exception e) {
            logger.info(e.getMessage(),"Some exception occured. Please check log file for more details!!");
        }
	}
}
