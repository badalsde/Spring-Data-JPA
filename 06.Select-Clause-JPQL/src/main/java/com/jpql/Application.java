package com.jpql;

import com.jpql.dto.CustomerDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpql.service.CustomerServiceImpl;
import java.util.List;

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
		getCustomerDetails();
		//getCustomerNameAndDob();
		//getCustomerName();
	}

	public void getCustomerDetails() {
        try {
			List<CustomerDTO> customerDTOS = customerService.getCustomerDetails();
			for (CustomerDTO customerDTO : customerDTOS) {
				logger.info(customerDTO);
			}
			logger.info("\n");
		}catch(Exception e){
			logger.error(e.getMessage(),"Something wrong please check the log file");
		}
    }

	public void getCustomerNameAndDob() {
        try{
			List<Object[]> objects = customerService.getCustomerNameAndDob();
			for(Object[] object : objects){
				logger.info(object[0] + "\t\t" + object[1]);
			}
			logger.info("\n");
		}catch(Exception e){
			logger.error(e.getMessage(),"Something wrong please check the log file");
		}
    }

	public void getCustomerName() {
        try{
			List<String> customerNames = customerService.getCustomerName();
			for(String customerName : customerNames){
                logger.info(customerName);
            }
			logger.info("\n");
		}catch(Exception e){
			logger.error(e.getMessage(),"Something wrong please check the log file");
		}
    }
}
