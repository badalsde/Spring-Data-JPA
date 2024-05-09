package com.jpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.jpa.repository.CustomerRepository;
import com.jpa.entity.Customer;
import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(Application.class);

	@Autowired
	private CustomerRepository customerRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Customer customer1 = new Customer(4, "monica@infy.com", "Monica", LocalDate.of(1987, 4, 2));
		Customer customer2 = new Customer(5, "allen@infy.com", "Allen", LocalDate.of(1980, 4, 2));

		//Save Customer
		customerRepository.save(customer1);
		customerRepository.save(customer2);

		//fetch customer by id
		logger.info("Customer fetch By findBId(1)");
		Customer customer3 = customerRepository.findById(2).get();
		logger.info(customer3);
	}
}
