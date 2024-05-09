package com.query.exception;

import java.io.Serial;

public class BookException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;
    public BookException(String msg) {
        super(msg);
    }
}
