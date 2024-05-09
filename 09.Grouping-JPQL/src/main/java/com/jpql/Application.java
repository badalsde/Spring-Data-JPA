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
		getCityWiseCustomerCount();
	}

	public void getCityWiseCustomerCount(){
		try {
			List<Object[]> objects = customerService.getCustomerDetails();
			for(Object[] object : objects)
				logger.info(object[0] + "\t\t" + object[1]);
            logger.info("\n");
		}catch (Exception e){
			String msg = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
			logger.info(msg);
		}
	}
}
