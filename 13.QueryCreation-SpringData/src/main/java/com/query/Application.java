package com.query;

import com.query.dto.CustomerDTO;
import com.query.exception.BankException;
import com.query.service.CustomerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.time.LocalDate;
import java.util.List;

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
		findByEmailId();
		findByEmailIdAndName();
		findByEmailIdOrName();
		findByDateOfBirthBetween();
		findByDateOfBirthLessThan();
		findByDateOfBirthGreaterThan();
		findByDateOfBirthAfter();
		findByDateOfBirthBefore();
		findByEmailIdIsNull();
		findByNameLike();
		findByNameOrderByDateOfBirth();
		findByNameOrderByDateOfBirthDesc();
	}

	public void findByEmailId() {
		try {
			CustomerDTO customerDTO = customerService.findByEmailId("monica@infy.com");
			logger.info(customerDTO);
			logger.info("\n");
		} catch (Exception e) {
			if (e.getMessage().isEmpty()) {
				logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
			}
		}
	}
	public void findByEmailIdAndName() {
		try{
			CustomerDTO customerDTO = customerService.findByEmailIdAndName("monica@infy.com", "Monica");
            logger.info(customerDTO);
            logger.info("\n");
		} catch (BankException e) {
            if(e.getMessage().isEmpty()) {
				logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
			}
        }
    }
	public void findByEmailIdOrName() {
		try{
			List<CustomerDTO> customerDTOS = customerService.findByEmailIdOrName("monica@infy.com", "Badal");
			for(CustomerDTO customerDTO : customerDTOS){
				logger.info(customerDTO);
			}
			logger.info("\n");
		} catch (BankException e) {
			if(e.getMessage().isEmpty()) {
				logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
			}
		}
	}
	public void findByDateOfBirthBetween() {
		try{
			LocalDate fromDate = LocalDate.of(1995, 1, 1);
			LocalDate toDate = LocalDate.of(2000, 12, 31);
            List<CustomerDTO> customerDTOS = customerService.findByDateOfBirthBetween(fromDate, toDate);
            for(CustomerDTO customerDTO : customerDTOS){
                logger.info(customerDTO);
            }
            logger.info("\n");
        } catch (BankException e) {
            if(e.getMessage().isEmpty()) {
                logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
            }
        }
	}
	public void findByDateOfBirthLessThan() {
		try{
			LocalDate dateOfBirth = LocalDate.of(2000, 12, 31);

			List<CustomerDTO> customerDTOS = customerService.findByDateOfBirthLessThan(dateOfBirth);
            for(CustomerDTO customerDTO : customerDTOS){
                logger.info(customerDTO);
            }
            logger.info("\n");
        } catch (BankException e) {
            if(e.getMessage().isEmpty()) {
                logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
            }
        }
	}
	public void findByDateOfBirthGreaterThan() {
		try{
            LocalDate dateOfBirth = LocalDate.of(1995, 12, 31);

            List<CustomerDTO> customerDTOS = customerService.findByDateOfBirthGreaterThan(dateOfBirth);
            for(CustomerDTO customerDTO : customerDTOS){
                logger.info(customerDTO);
            }
            logger.info("\n");
        } catch (BankException e) {
            if(e.getMessage().isEmpty()) {
                logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
            }
        }
	}
	public void findByDateOfBirthAfter() {
		try{
            LocalDate dateOfBirth = LocalDate.of(1995, 12, 31);

            List<CustomerDTO> customerDTOS = customerService.findByDateOfBirthAfter(dateOfBirth);
            for(CustomerDTO customerDTO : customerDTOS){
                logger.info(customerDTO);
            }
            logger.info("\n");
        } catch (BankException e) {
            if(e.getMessage().isEmpty()) {
                logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
            }
        }
	}
	public void findByDateOfBirthBefore() {
		try{
            LocalDate dateOfBirth = LocalDate.of(2000, 12, 31);

            List<CustomerDTO> customerDTOS = customerService.findByDateOfBirthBefore(dateOfBirth);
            for(CustomerDTO customerDTO : customerDTOS){
                logger.info(customerDTO);
            }
            logger.info("\n");
        } catch (BankException e) {
            if(e.getMessage().isEmpty()) {
                logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
            }
        }
	}
	public void findByEmailIdIsNull() {
		try{
            List<CustomerDTO> customerDTOS = customerService.findByEmailIdNull();
            for(CustomerDTO customerDTO : customerDTOS){
                logger.info(customerDTO);
            }
            logger.info("\n");
        } catch (BankException e) {
            if(e.getMessage().isEmpty()) {
                logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
            }
        }
	}
	public void findByNameLike() {
		try{
            List<CustomerDTO> customerDTOS = customerService.findByNameLike("%d%");
            for(CustomerDTO customerDTO : customerDTOS){
                logger.info(customerDTO);
            }
            logger.info("\n");
        } catch (BankException e) {
            if(e.getMessage().isEmpty()) {
                logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
            }
        }
	}
	public void findByNameOrderByDateOfBirth() {
		try{
            List<CustomerDTO> customerDTOS = customerService.findByNameOrderByDateOfBirth("Badal");
            for(CustomerDTO customerDTO : customerDTOS){
                logger.info(customerDTO);
            }
            logger.info("\n");
        } catch (BankException e) {
            if(e.getMessage().isEmpty()) {
                logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
            }
        }
	}
	public void findByNameOrderByDateOfBirthDesc() {
		try{
            List<CustomerDTO> customerDTOS = customerService.findByNameOrderByDateOfBirthDesc("Badal");
            for(CustomerDTO customerDTO : customerDTOS){
                logger.info(customerDTO);
            }
            logger.info("\n");
        } catch (BankException e) {
            if(e.getMessage().isEmpty()) {
                logger.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
            }
        }
	}
}
