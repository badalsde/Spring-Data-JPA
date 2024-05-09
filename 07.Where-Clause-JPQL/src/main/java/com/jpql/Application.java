package com.jpql;

import com.jpql.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jpql.service.CustomerServiceImpl;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerServiceImpl customerService;

	private static final Logger logger = LogManager.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		getCustomerDetails();
	}
	public void getCustomerDetails() {
		try {
			List<CustomerDTO> customerDTOS = customerService.getCustomerDetails();
			for(CustomerDTO customerDTO:customerDTOS){
                logger.info(customerDTO);
            }
        } catch (Exception e) {
			logger.info(e.getMessage(),"Something wrong please check the log file");
        }
	}
}
