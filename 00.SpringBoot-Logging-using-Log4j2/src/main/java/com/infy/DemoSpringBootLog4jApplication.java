package com.infy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.infy.controller.CustomerLoginController;
import com.infy.dto.CustomerLoginDTO;
import com.infy.exception.InfyBankException;

@SpringBootApplication
public class DemoSpringBootLog4jApplication implements CommandLineRunner{

	private static final Logger LOGGER = LogManager.getLogger(DemoSpringBootLog4jApplication.class);

	
	@Autowired
	CustomerLoginController customerLoginController;
	
	@Autowired
	Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootLog4jApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try{

			CustomerLoginDTO customerLogin = new CustomerLoginDTO();
			customerLogin.setLoginName("harry");
			customerLogin.setPassword("harry@123");
			customerLoginController.authenticateCustomer(customerLogin);
			LOGGER.info(environment.getProperty("SUCCESS"));
		}catch(InfyBankException exception){
			LOGGER.error(environment.getProperty(exception.getMessage()));
		}
		
	}

}