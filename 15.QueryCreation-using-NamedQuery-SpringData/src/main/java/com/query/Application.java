package com.query;

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
	}
	public void findNameByEmailId() {
		try {
            String name = customerService.findNameByEmailId("sonu@infy.com");
            logger.info("Customer Name: {}", name);
        } catch (Exception e) {
			if(e.getMessage()!=null)
				logger.error(environment.getProperty(e.getMessage()), "Something went wrong. Please check log file for more details.");
        }
	}
}
