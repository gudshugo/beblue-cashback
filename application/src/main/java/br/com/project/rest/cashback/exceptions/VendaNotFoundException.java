package br.com.project.rest.cashback.exceptions;

import java.util.NoSuchElementException;

public class VendaNotFoundException extends NoSuchElementException {

    public VendaNotFoundException(String msg) {
        super(msg);
    }

}
