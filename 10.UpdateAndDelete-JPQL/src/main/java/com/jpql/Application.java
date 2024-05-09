package com.jpql;

import com.jpql.service.CustomerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerServiceImpl customerService;
	@Autowired
	private Environment environment;
	private static final Logger logger = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		updateCityOfCustomer();
		//deleteCustomer();
	}

	public void updateCityOfCustomer() {
		try {
			customerService.updateCityOfCustomer(1009, "Seat");
			logger.info(environment.getProperty("UserInterface.UPDATE_SUCCESS"));
			logger.info("\n");
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),
					"Some exception occured. Please check log file for more details!!");
			logger.info(message);
		}
	}

	public void deleteCustomer(){
		try {
			  Integer delete= customerService.deleteCustomer();
			logger.info(environment.getProperty("UserInterface.DELETE_SUCCESS"));
			logger.info("\n");
        }catch (Exception e){
            String msg = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
            logger.info(msg);
        }
	}
}
