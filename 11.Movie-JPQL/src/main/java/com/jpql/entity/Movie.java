package com.jpql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    private Integer movieId;
    private String movieName;
    private String directorName;
    private Float imdbRating;
    private Integer releaseYear;
}
