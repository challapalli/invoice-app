package com.invoice.controller;

import com.invoice.model.Invoice;
import com.invoice.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
@CrossOrigin
@Slf4j
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        log.info("Request to fetching all the Invoices.");
        return invoiceService.getAllInvoices();
    }

    @PostMapping
    public Invoice saveInvoice(@RequestBody Invoice invoice) {
        log.info("Request to save the Invoice. InvoiceId: {}", invoice.invoice());
        return invoiceService.saveInvoice(invoice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable int id) {
        log.info("Request to delete the Invoice. Id: {}", id);
        invoiceService.deleteInvoice(id);
        return new ResponseEntity<>("Invoice deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Invoice updateInvoice(@RequestBody Invoice invoice, @PathVariable int id) {
        log.info("Request to update the invoice. Id: {}", id);
        return invoiceService.updateInvoice(id, invoice);
    }
}
