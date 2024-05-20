package com.invoice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(InvoiceDeleteFailedException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage invoiceDeleteFailedException(InvoiceDeleteFailedException ex) {
        log.error("Failed to delete the Invoice. Error: {}", ex.getMessage());
        return new ErrorMessage(LocalDateTime.now(), ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(InvoiceUpdateFailedException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage invoiceUpdateFailedException(InvoiceUpdateFailedException ex) {
        log.error("Failed to update the Invoice. Error: {}", ex.getMessage());
        return new ErrorMessage(LocalDateTime.now(), ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
}
