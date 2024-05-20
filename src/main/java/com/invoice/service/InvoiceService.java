package com.invoice.service;

import com.invoice.entity.InvoiceEntity;
import com.invoice.exception.InvoiceDeleteFailedException;
import com.invoice.exception.InvoiceUpdateFailedException;
import com.invoice.model.Invoice;
import com.invoice.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getAllInvoices() {
        final List<InvoiceEntity> invoiceEntities = invoiceRepository.findAll();
        log.info("The number of records fetched for DB. Size: {}", invoiceEntities.size());
        return invoiceEntities.stream().map(Invoice::getInvoice).collect(Collectors.toList());
    }

    public Invoice saveInvoice(Invoice invoice) {
        var invoiceEntity = InvoiceEntity.getEntity(invoice);
        invoiceEntity = invoiceRepository.save(invoiceEntity);
        log.info("Successfully saved the Invoice. Id: {}", invoiceEntity.getInvoice());
        return Invoice.getInvoice(invoiceEntity);
    }

    public void deleteInvoice(int id) {
        var optionalEntity = invoiceRepository.findById(id);
        if (optionalEntity.isEmpty()) {
            log.info("No Invoice with Id: {} found in the DB to delete", id);
            throw new InvoiceDeleteFailedException("Invoice doesn't exist in DB, cannot delete.");
        } else {
            invoiceRepository.delete(optionalEntity.get());
            log.info("Successfully deleted the Invoice. Id: {}", id);
        }
    }

    public Invoice updateInvoice(int id, Invoice invoice) {
        var optionalEntity = invoiceRepository.findById(id);
        if(optionalEntity.isPresent()) {
            var entity = InvoiceEntity.getEntity(invoice);
            entity.setId(optionalEntity.get().getId());
            invoiceRepository.save(entity);
            log.info("Successfully updated the Invoice. Id: {}", id);
            return Invoice.getInvoice(entity);
        }
        log.info("No Invoice with Id: {} found in the DB to update", id);
        throw new InvoiceUpdateFailedException("Invoice doesn't exist in DB, cannot update.");
    }
}
