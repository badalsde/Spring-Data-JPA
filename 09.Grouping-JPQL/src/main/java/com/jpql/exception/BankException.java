package com.jpql.exception;

import java.io.Serial;

public class BankException extends Exception {
    @Serial
    private static final long serialVersionUID =1L;
    public BankException(String msg) {
        super(msg);
    }
}
