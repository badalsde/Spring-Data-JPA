package com.jpql.repository;

import com.jpql.dto.MovieDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository(value = "movieRepository")
public class MovieRepositoryImpl implements MovieRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public MovieDTO getMovieByName(String movieName) {
        String queryString = "select new com.jpql.dto.MovieDTO(m.movieId, m.movieName, m.directorName, m.imdbRating, m.releaseYear) from Movie m where m.movieName = :movieName";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("movieName", movieName);
        return (MovieDTO) query.getSingleResult();
    }

    @Override
    public List<MovieDTO> getMoviesByImdbRating(Double fromRating, Double toRating) {
        String queryString = "select new com.jpql.dto.MovieDTO(m.movieId, m.movieName, m.directorName, m.imdbRating, m.releaseYear) from Movie m where m.imdbRating BETWEEN :fromRating AND :toRating";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("fromRating", fromRating);
        query.setParameter("toRating", toRating);
        return query.getResultList();
    }

    @Override
    public List<Object[]> getMoviesNameAndYear(String directorName) {
        String queryString = "select m.movieName, m.releaseYear from Movie m where m.directorName = :directorName";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("directorName", directorName);
        return query.getResultList();
    }
}
