package com.invoice.entity;

import com.invoice.model.Invoice;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String invoice;
    private String customer;
    private String email;
    private LocalDateTime invoiceDate;
    private LocalDateTime dueDate;
    private String status;
    private double amount;

    public static InvoiceEntity getEntity(Invoice invoice) {
        return InvoiceEntity.builder()
                .invoice(invoice.invoice())
                .customer(invoice.customer())
                .email(invoice.email())
                .invoiceDate(invoice.invoiceDate())
                .dueDate(invoice.dueDate())
                .status(invoice.status())
                .amount(invoice.amount())
                .build();
    }

}
