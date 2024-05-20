package com.invoice.exception;

public class InvoiceUpdateFailedException extends RuntimeException {

    public InvoiceUpdateFailedException(String message) {
        super(message);
    }
}
