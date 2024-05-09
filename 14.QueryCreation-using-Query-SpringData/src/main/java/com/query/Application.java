package com.query;

import com.query.exception.BankException;
import com.query.service.CustomerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(Application.class);
	@Autowired
	private CustomerServiceImpl customerService;
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		findNameByEmailId();
		//updateCustomerByEmailId();
		//deleteCustomerByEmailId();
	}
	public void findNameByEmailId(){
		try {
			String name = customerService.findNameByEmailId("monica@infy.com");
			logger.info("Customer Name is: "+name);
		}catch(Exception e){
			if(e.getMessage() != null) {
				logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
			}
		}
    }

	public void updateCustomerByEmailId(){
		try {
            customerService.updateCustomerEmailId("badal2@infy.com",7);
            logger.info(environment.getProperty("UserInterface.UPDATE_SUCCESS"));
        }catch(Exception e){
            if(e.getMessage() != null) {
                logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
            }
        }
	}

	public void deleteCustomerByEmailId(){
		try {
            customerService.deleteCustomerByEmailId("badal@infy.com");
            logger.info(environment.getProperty("UserInterface.DELETE_SUCCESS"));
        }catch(Exception e){
            if(e.getMessage() != null) {
                logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
            }
        }
	}
}
