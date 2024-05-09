package com.jpql;

import com.jpql.dto.MovieDTO;
import com.jpql.service.MovieServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.List;

@SpringBootApplication
public class MovieJpqlApplication implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(MovieJpqlApplication.class);

	@Autowired
	private MovieServiceImpl movieService;
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(MovieJpqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		getMovieByName();
		getMovieByImdbRating();
		getMoviesNameAndYear();
	}
	public void getMovieByName(){
		try {
			String movieName = "Deadpool";
			MovieDTO movieDTO = movieService.getMovieByName(movieName);
            logger.info(movieDTO);
			logger.info("\n");
        } catch (Exception e) {
            logger.info(environment.getProperty(e.getMessage(),"Some exception occured.Please check log file."));
			logger.info("\n");
        }
	}

	public void getMovieByImdbRating(){
		try {
			Double fromRating = 0.0d;
			Double toRating = 7.8d;
            List<MovieDTO> movieDTOS = movieService.getMoviesByImdbRating(fromRating, toRating);
            for(MovieDTO movieDTO : movieDTOS){
				logger.info(movieDTO);
			}
			logger.info("\n");
        } catch (Exception e) {
            logger.info(environment.getProperty(e.getMessage(), "Some exception occured.Please check log file."));
			logger.info("\n");
        }
	}

	public void getMoviesNameAndYear(){
        try {
			String directorName = "Joss Whedon";
			List<Object[]> objects = movieService.getMoviesNameAndYear(directorName);
			for(Object[] object : objects){
                logger.info("Movie Name: {} Released year: {}", object[0], object[1]);
			}
			logger.info("\n");
		}catch (Exception e) {
		    logger.info(environment.getProperty(e.getMessage(),"Some exception occured.Please check log file."));
			logger.info("\n");
	}
}

}
