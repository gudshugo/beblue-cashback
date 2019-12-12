package br.com.project.rest.cashback.exceptions;

import java.util.NoSuchElementException;

public class DiscoNotFoundException extends NoSuchElementException {

    public DiscoNotFoundException(String msg) {
        super(msg);
    }

}
