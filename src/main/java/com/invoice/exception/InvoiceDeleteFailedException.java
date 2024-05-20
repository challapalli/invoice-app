package com.invoice.exception;

public class InvoiceDeleteFailedException extends RuntimeException {

    public InvoiceDeleteFailedException (String message) {
        super(message);
    }
}
