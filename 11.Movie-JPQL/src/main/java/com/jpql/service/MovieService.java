package com.jpql.service;

import com.jpql.exception.MovieException;
import com.jpql.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    public MovieDTO getMovieByName(String movieName) throws MovieException;
    public List<MovieDTO> getMoviesByImdbRating(Double fromRating, Double toRating) throws MovieException;
    public List<Object[]> getMoviesNameAndYear(String directorName) throws MovieException;
}
