package com.jpa;

import com.jpa.exception.BankException;
import com.jpa.service.CustomerServiceImpl;
import com.jpa.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
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
		// addCustomer();
		// getCustomer();
		getAllCustomers();
	}
	public void addCustomer(){
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(7);
		customerDTO.setName("Badal");
		customerDTO.setEmailId("badal@infy.com");
		customerDTO.setDateOfBirth(LocalDate.now());
		try {
            customerService.addCustomer(customerDTO);
			logger.info("Customer added successfully");
        } catch (BankException e) {
            logger.error(e.getMessage(),"Something wrong please check the log file");
        }
	}
	public void getCustomer(){
		try{
			CustomerDTO customer = customerService.getCustomer(6);
			logger.info(customer);
		}catch (BankException e) {
			logger.error(e.getMessage(),"Something wrong please check the log file");
		}
    }
	public void getAllCustomers(){
		try{
			List<CustomerDTO> customers = customerService.getAll();
			customers.forEach(logger::info);
		} catch (BankException e) {
            throw new RuntimeException(e);
        }
    }
}
