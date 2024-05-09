package com.jpql.repository;

import com.jpql.dto.MovieDTO;
import java.util.List;

public interface MovieRepository {
    public MovieDTO getMovieByName(String movieName);
    public List<MovieDTO> getMoviesByImdbRating(Double fromRating, Double toRating);
    public List<Object[]> getMoviesNameAndYear(String directorName);
}
