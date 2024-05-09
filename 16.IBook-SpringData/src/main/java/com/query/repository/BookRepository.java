package com.query.repository;

import com.query.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends CrudRepository<Book,Integer> {

    public List<Book> findByBookName(String bookName);
    public List<Book> findByAuthorName(String authorName);
    public List<Book> findByPriceGreaterThanEqual(Integer price);
    public List<Book> findByPriceLessThan(Integer price);
    public List<Book> findByYearBetween(LocalDate fromDate, LocalDate toDate);
    public List<Book> findByYearAfter(LocalDate year);
    public List<Book> findByAuthorNameAndPublisher(String authorName, String publisher);
}