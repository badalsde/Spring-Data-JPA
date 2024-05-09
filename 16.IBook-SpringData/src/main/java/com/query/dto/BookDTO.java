package com.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Integer bookId;
    private String bookName;
    private String authorName;
    private LocalDate year;
    private String publisher;
    private Long isbn;
    private Integer price;
}
