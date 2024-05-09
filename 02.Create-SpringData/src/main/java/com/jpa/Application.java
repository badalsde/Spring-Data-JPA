package com.jpa;

import com.jpa.dto.CustomerDTO;
import com.jpa.exception.BankException;
import com.jpa.service.CustomerService;
import com.jpa.service.CustomerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(Application.class);

	@Autowired
	private CustomerServiceImpl customerService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		addCustomer();
	}

	public void addCustomer(){
		CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(6);
        customerDTO.setName("Harry");
        customerDTO.setEmailId("harry@infy.com");
		customerDTO.setDateOfBirth(LocalDate.now());

		try{
			customerService.addCustomer(customerDTO);
			logger.info("Customer added successfully");
		} catch (Exception e) {
            if(e.getMessage()!=null)
				logger.error(e.getMessage(),"Getting some errors msg...");
        }
    }

}
