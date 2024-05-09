package com.query.validator;

import com.query.dto.BookDTO;
import com.query.exception.BookException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Validator {
    public static void validate(BookDTO bookDTO) throws BookException {
        if(bookDTO==null){
            throw new BookException("Book cannot be null");
        }
        if(!validateYear(bookDTO.getYear())){
            throw new BookException("Validator.INVALID_YEAR");
        }
    }
    public static boolean validateYear(LocalDate year) {
        LocalDate currentDate = LocalDate.now();
        return !year.isAfter(currentDate);
    }

}