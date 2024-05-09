package com.infy.service;

import java.util.List;

import com.infy.dto.MovieDTO;
import com.infy.exception.MovieException;

public interface MovieService {

	public List<MovieDTO> getMovieByRating(Double fromRating) throws MovieException;

	public List<MovieDTO> getHighestRatedMovie(String directorName) throws MovieException;

	public Float getAverageDirectorRating(String directorName) throws MovieException;

	public Long getNumberOfMoviesReleased(Integer fromYear, Integer toYear) throws MovieException;
}
