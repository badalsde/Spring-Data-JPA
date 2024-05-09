package com.infy.repository;

import java.util.ArrayList;
import java.util.List;

import com.infy.entity.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.infy.dto.MovieDTO;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository(value="movieRepository")
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<MovieDTO> getMovieByRating(Double fromRating) {
		List<MovieDTO> movieDTOS = null;
		String queryString = "select m from Movie m where m.imdbRating >= ?1";
		Query query = entityManager.createQuery(queryString);
		query.setParameter(1, fromRating);
		movieDTOS = new ArrayList<>();
		List<Movie> movies = query.getResultList();
		for(Movie movie : movies){
			MovieDTO movieDTO = new MovieDTO();
			movieDTO.setMovieId(movie.getMovieId());
            movieDTO.setMovieName(movie.getMovieName());
			movieDTO.setDirectorName(movie.getDirectorName());
			movieDTO.setImdbRating(movie.getImdbRating());
			movieDTO.setReleaseYear(movie.getReleaseYear());
			movieDTOS.add(movieDTO);
		}
		return movieDTOS;
	}

	@Override
	public List<MovieDTO> getHighestRatedMovie(String directorName) {
		String queryString = "select m from Movie m where m.directorName = ?1 ORDER BY m.imdbRating DESC";
		Query query = entityManager.createQuery(queryString);
		query.setParameter(1, directorName);

		List<Movie> movies= query.getResultList();
		Movie movie = movies.get(0);

		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setMovieId(movie.getMovieId());
		movieDTO.setMovieName(movie.getMovieName());
		movieDTO.setDirectorName(movie.getDirectorName());
		movieDTO.setImdbRating(movie.getImdbRating());
		movieDTO.setReleaseYear(movie.getReleaseYear());

		return List.of(movieDTO);
	}

	@Override
	public Float getAverageDirectorRating(String directorName) {
		String queryString = "select AVG(m.imdbRating) from Movie m where m.directorName = ?1";
		Query query = entityManager.createQuery(queryString);
		query.setParameter(1, directorName);
		Double doubleResult = (Double) query.getSingleResult(); //result is a Double
		return doubleResult.floatValue(); // Convert Double to Float
	}

	@Override
	public Long getNumberOfMoviesReleased(Integer fromYear, Integer toYear) {
		String queryString = "SELECT COUNT(m) from Movie m WHERE m.releaseYear BETWEEN ?1 AND ?2";
		Query query = entityManager.createQuery(queryString);
		query.setParameter(1, fromYear);
		query.setParameter(2, toYear);
		return (Long) query.getSingleResult();
	}

	

}
