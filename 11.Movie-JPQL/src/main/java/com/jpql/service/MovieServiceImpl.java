package com.jpql.service;

import com.jpql.dto.MovieDTO;
import com.jpql.exception.MovieException;
import com.jpql.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="movieService")
@Transactional
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieDTO getMovieByName(String movieName) throws MovieException {
        MovieDTO movie = movieRepository.getMovieByName(movieName);
        if(movie == null) {
            throw new MovieException("Service.NO_MOVIE_FOUND");
        }
        return movie;
    }

    @Override
    public List<MovieDTO> getMoviesByImdbRating(Double fromRating, Double toRating) throws MovieException {
        List<MovieDTO> movies = movieRepository.getMoviesByImdbRating(fromRating, toRating);
        if(movies.isEmpty()) {
           throw new MovieException("Service.NO_MOVIES_FOUND_FOR_RATING");
       }
       return movies;
    }

    @Override
    public List<Object[]> getMoviesNameAndYear(String directorName) throws MovieException {
       List<Object[]> objects = movieRepository.getMoviesNameAndYear(directorName);
        if( objects.isEmpty()) {
            throw new MovieException("Service.MOVIE_NOT_FOUND_FOR_DIRECTOR");
        }
        return objects;
    }
}
