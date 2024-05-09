package com.jpql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Integer movieId;
    private String movieName;
    private String directorName;
    private Float imdbRating;
    private Integer releaseYear;
}
