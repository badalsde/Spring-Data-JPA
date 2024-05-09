package com.query;

import com.query.dto.BookDTO;
import com.query.exception.BookException;
import com.query.service.BookServiceImpl;
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

	private static final Logger logger = LogManager.getLogger();
	private static final String GENERAL_ERROR = "Some exception occured.Please check log file.";

	@Autowired
	private BookServiceImpl bookService;
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		getBookDetails();
		//addBook();
		//getBookByAuthorName();
		//getBookGreaterThanEqualToPrice();
		//getBookLessThanPrice();
		//bookPublishedBetweenYear();
		//bookPublishedAfterYear();
		//getBookByAuthorNameAndPublisher();
		//updateBookPrice();
		//deleteBook();
	}

	public void getBookDetails() {
		try {
			BookDTO bookDTO = bookService.getBookDetails(1001);
			logger.info(bookDTO);
		} catch (Exception e) {
			logger.info(environment.getProperty(e.getMessage()), GENERAL_ERROR);
		}
	}
	public void addBook() {
		try {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setBookId(1005);
			bookDTO.setBookName("The Badal Code");
			bookDTO.setAuthorName("Badal Kumar");
			bookDTO.setYear(LocalDate.of(2000, 04, 18));
			bookDTO.setPublisher("Doubleday");
			bookDTO.setIsbn(1456987609898l);
			bookDTO.setPrice(690);
			bookService.addBook(bookDTO);
			logger.info(environment.getProperty("UserInterface.INSERT_SUCCESS"));
		} catch (Exception e) {
			logger.info(environment.getProperty(e.getMessage()), GENERAL_ERROR);
		}
	}
	public void getBookByAuthorName() {
		try {
			String authorName = "Nicholas Sparks";
			List<BookDTO> bookDTOS = bookService.getBookByAuthorName(authorName);
			for (BookDTO bookDTO : bookDTOS) {
                logger.info(bookDTO);
            }
		} catch (BookException e) {
			logger.info(environment.getProperty(e.getMessage()), GENERAL_ERROR);
		}
	}
	public void getBookGreaterThanEqualToPrice() {
		try {
            Integer price = 700;
            List<BookDTO> bookDTOS = bookService.getBookGreaterThanEqualToPrice(price);
            //bookDTOS.forEach(bookDTO->logger.info(bookDTO));
			bookDTOS.forEach(logger::info);
        } catch (BookException e) {
            logger.info(environment.getProperty(e.getMessage()), GENERAL_ERROR);
        }
	}
	public void getBookLessThanPrice() {
		try {
            Integer price = 600;
            List<BookDTO> bookDTOS = bookService.getBookLessThanPrice(price);
            //bookDTOS.forEach(bookDTO->logger.info(bookDTO));
            bookDTOS.forEach(logger::info);
        } catch (BookException e) {
            logger.info(environment.getProperty(e.getMessage()), GENERAL_ERROR);
        }
	}
	public void bookPublishedBetweenYear() {
		try {
            LocalDate startYear = LocalDate.of(1990, 12, 22);
            LocalDate endYear = LocalDate.of(2000, 12, 22);
            List<BookDTO> bookDTOS = bookService.bookPublishedBetweenYear(startYear, endYear);
            //bookDTOS.forEach(bookDTO->logger.info(bookDTO));
            bookDTOS.forEach(logger::info);
        } catch (BookException e) {
            logger.info(environment.getProperty(e.getMessage()), GENERAL_ERROR);
        }
	}
	public void bookPublishedAfterYear() {
		try {
            LocalDate year = LocalDate.of(2000, 12, 22);
            List<BookDTO> bookDTOS = bookService.bookPublishedAfterYear(year);
            //bookDTOS.forEach(bookDTO->logger.info(bookDTO));
            bookDTOS.forEach(logger::info);
        } catch (BookException e) {
            logger.info(environment.getProperty(e.getMessage()), GENERAL_ERROR);
        }
	}
	public void getBookByAuthorNameAndPublisher() {
		try {
			String authorName = "Amish Tripathi";
			String publisher = "Westland Press";
			List<BookDTO> bookDTOS = bookService.getBookByAuthorNameAndPublisher(authorName, publisher);
			//bookDTOS.forEach(bookDTO->logger.info(bookDTO));
			bookDTOS.forEach(logger::info);
		} catch (BookException e) {
			logger.info(environment.getProperty(e.getMessage()), GENERAL_ERROR);
		}

	}
	public void updateBookPrice() {
		try {
            Integer bookId = 1005;
            Integer price = 850;
            bookService.updateBookPrice(bookId, price);
            logger.info(environment.getProperty("UserInterface.UPDATE_SUCCESS"));
        } catch (BookException e) {
            logger.info(environment.getProperty(e.getMessage()), GENERAL_ERROR);
        }
	}
	public void deleteBook() {
		try {
            Integer bookId = 1005;
            bookService.deleteBook(bookId);
            logger.info(environment.getProperty("UserInterface.DELETE_SUCCESS"));
        } catch (BookException e) {
            logger.info(environment.getProperty(e.getMessage()), GENERAL_ERROR);
        }
	}
}