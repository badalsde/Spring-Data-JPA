package com.query.service;

import com.query.dto.BookDTO;
import com.query.entity.Book;
import com.query.exception.BookException;
import com.query.validator.Validator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.query.repository.BookRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service(value="bookService")
@Transactional
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private Validator validator;

    @Override
    public BookDTO getBookDetails(Integer bookId) throws BookException {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        Book book = optionalBook.orElseThrow(()-> new BookException("Service.BOOK_DETAILS_NOT_FOUND."));
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId(book.getBookId());
        bookDTO.setBookName(book.getBookName());
        bookDTO.setAuthorName(book.getAuthorName());
        bookDTO.setYear(book.getYear());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setPrice(book.getPrice());
        return bookDTO;
    }

    @Override
    public void addBook(BookDTO bookDTO) throws BookException {
        try {
            Validator.validate(bookDTO);
            if(!bookRepository.existsById(bookDTO.getBookId())){
                Book book = new Book();
                book.setBookId(bookDTO.getBookId());
                book.setBookName(bookDTO.getBookName());
                book.setAuthorName(bookDTO.getAuthorName());
                book.setYear(bookDTO.getYear());
                book.setPublisher(bookDTO.getPublisher());
                book.setIsbn(bookDTO.getIsbn());
                book.setPrice(bookDTO.getPrice());
                bookRepository.save(book);
            }
            else{
                throw new BookException("Service.BOOK_ALREADY_EXISTS");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<BookDTO> getBookByAuthorName(String authorName) throws BookException {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> books = bookRepository.findByAuthorName(authorName);
        if(books.isEmpty()){
            throw new BookException("Service.BOOK_NOT_FOUND");
        }
        for(Book book : books){
            BookDTO bookDTO = new BookDTO();
            bookDTO.setBookId(book.getBookId());
            bookDTO.setBookName(book.getBookName());
            bookDTO.setAuthorName(book.getAuthorName());
            bookDTO.setYear(book.getYear());
            bookDTO.setPublisher(book.getPublisher());
            bookDTO.setIsbn(book.getIsbn());
            bookDTO.setPrice(book.getPrice());
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public List<BookDTO> getBookGreaterThanEqualToPrice(Integer price) throws BookException {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> books = bookRepository.findByPriceGreaterThanEqual(price);
        if(books.isEmpty()){
            throw new BookException("Service.BOOK_NOT_FOUND");
        }
        for(Book book : books){
            BookDTO bookDTO = new BookDTO();
            bookDTO.setBookId(book.getBookId());
            bookDTO.setBookName(book.getBookName());
            bookDTO.setAuthorName(book.getAuthorName());
            bookDTO.setYear(book.getYear());
            bookDTO.setPublisher(book.getPublisher());
            bookDTO.setIsbn(book.getIsbn());
            bookDTO.setPrice(book.getPrice());
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public List<BookDTO> getBookLessThanPrice(Integer price) throws BookException {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> books = bookRepository.findByPriceLessThan(price);
        if(books.isEmpty()){
            throw new BookException("Service.BOOK_NOT_FOUND");
        }
        for(Book book : books){
            BookDTO bookDTO = new BookDTO();
            bookDTO.setBookId(book.getBookId());
            bookDTO.setBookName(book.getBookName());
            bookDTO.setAuthorName(book.getAuthorName());
            bookDTO.setYear(book.getYear());
            bookDTO.setPublisher(book.getPublisher());
            bookDTO.setIsbn(book.getIsbn());
            bookDTO.setPrice(book.getPrice());
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public List<BookDTO> bookPublishedBetweenYear(LocalDate startYear, LocalDate endYear) throws BookException {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> books = bookRepository.findByYearBetween(startYear, endYear);
        if(books.isEmpty()){
            throw new BookException("Service.BOOK_NOT_FOUND");
        }
        for(Book book : books){
            BookDTO bookDTO = new BookDTO();
            bookDTO.setBookId(book.getBookId());
            bookDTO.setBookName(book.getBookName());
            bookDTO.setAuthorName(book.getAuthorName());
            bookDTO.setYear(book.getYear());
            bookDTO.setPublisher(book.getPublisher());
            bookDTO.setIsbn(book.getIsbn());
            bookDTO.setPrice(book.getPrice());
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public List<BookDTO> bookPublishedAfterYear(LocalDate year) throws BookException {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> books = bookRepository.findByYearAfter(year);
        if(books.isEmpty()){
            throw new BookException("Service.BOOK_NOT_FOUND");
        }
        for(Book book : books){
            BookDTO bookDTO = new BookDTO();
            bookDTO.setBookId(book.getBookId());
            bookDTO.setBookName(book.getBookName());
            bookDTO.setAuthorName(book.getAuthorName());
            bookDTO.setYear(book.getYear());
            bookDTO.setPublisher(book.getPublisher());
            bookDTO.setIsbn(book.getIsbn());
            bookDTO.setPrice(book.getPrice());
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public List<BookDTO> getBookByAuthorNameAndPublisher(String authorName, String publisher) throws BookException {
        List<BookDTO> bookDTOS = new ArrayList<BookDTO>();
        List<Book> books = bookRepository.findByAuthorNameAndPublisher(authorName, publisher);
        if(books.isEmpty()){
            throw new BookException("Service.BOOK_NOT_FOUND");
        }
        for(Book book : books){
            BookDTO bookDTO = new BookDTO();
            bookDTO.setBookId(book.getBookId());
            bookDTO.setBookName(book.getBookName());
            bookDTO.setAuthorName(book.getAuthorName());
            bookDTO.setYear(book.getYear());
            bookDTO.setPublisher(book.getPublisher());
            bookDTO.setIsbn(book.getIsbn());
            bookDTO.setPrice(book.getPrice());
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public void updateBookPrice(Integer bookId, Integer price) throws BookException {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        Book book = optionalBook.orElseThrow(()->new BookException("Book not found"));
        book.setPrice(price);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer bookId) throws BookException {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        Book book = optionalBook.orElseThrow(()->new BookException("Book not found"));
        bookRepository.delete(book);
    }
}
