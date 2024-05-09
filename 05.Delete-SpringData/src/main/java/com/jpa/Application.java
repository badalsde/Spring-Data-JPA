package com.jpa;

import com.jpa.dto.CustomerDTO;
import com.jpa.service.CustomerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		//addCustomer();
		//getCustomer();
		//getAllCustomers();
		//updateCustomer();
		deleteCustomer();
	}

	public void addCustomer() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(8);
		customerDTO.setName("Badal");
		customerDTO.setEmailId("badal@infy.com");
		customerDTO.setDateOfBirth(java.time.LocalDate.now());
		try{
			customerService.addCustomer(customerDTO);
            logger.info("Customer added successfully");
		}catch(Exception e){
			logger.error(e.getMessage(),"Something wrong please check the log file");
		}
	}
	public void getCustomer() {
		try {
			CustomerDTO customer = customerService.getCustomer(4);
			logger.info(customer);
		}catch (Exception e) {
			logger.error(e.getMessage(),"Something wrong please check the log file");
		}
    }
	public void getAllCustomers() {
		try {
			List<CustomerDTO> customers = customerService.getAll();
            customers.forEach(logger::info);
		}catch (Exception e) {
			logger.error(e.getMessage(),"Something wrong please check the log file");
		}
    }
	public void updateCustomer() {
		try {
			customerService.updateCustomer(4, "bk@infosys.com");
			logger.info("Customer Data updated successfully");
		}catch (Exception e) {
			logger.error(e.getMessage(),"Something wrong please check the log file");
		}
    }
	public void deleteCustomer() {
		try {
            customerService.deleteCustomer(4);
            logger.info("Customer deleted successfully");
        }catch (Exception e) {
            logger.error(e.getMessage(),"Something wrong please check the log file");
        }
    }
}