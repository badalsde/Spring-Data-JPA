package com.query.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private Integer bookId;
    private String bookName;
    private String authorName;
    private LocalDate year;
    private String publisher;
    private Long isbn;
    private Integer price;
}
