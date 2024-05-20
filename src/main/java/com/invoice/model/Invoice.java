package com.invoice.model;

import com.invoice.entity.InvoiceEntity;

import java.time.LocalDateTime;

public record Invoice(Long id,
        String invoice,
        String customer,
        String email,
        LocalDateTime invoiceDate,
        LocalDateTime dueDate,
        String status,
        double amount) {

    public static Invoice getInvoice(InvoiceEntity entity) {
        return new Invoice(entity.getId(), entity.getInvoice(), entity.getCustomer(),
                entity.getEmail(), entity.getInvoiceDate(), entity.getDueDate(),
                entity.getStatus(), entity.getAmount());
    }
}
