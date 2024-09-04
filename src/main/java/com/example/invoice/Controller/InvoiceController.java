package com.example.invoice.Controller;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.invoice.Service.InvoiceService;
import com.example.invoice.dto.InvoiceDto;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/{customerId}")
    public ResponseEntity<List<InvoiceDto>> getInvoices(@PathVariable Long customerId) {
        List<InvoiceDto> invoices = invoiceService.getInvoices(customerId);
        if (invoices.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 if no invoices found
        }
        return ResponseEntity.ok(invoices); // Return 200 with the list of invoices
    }

    @PostMapping
    public ResponseEntity<InvoiceDto> generateInvoice(@RequestBody InvoiceDto invoiceData) {
        InvoiceDto generatedInvoice = invoiceService.generateInvoice(invoiceData);
        return ResponseEntity.created(URI.create("/api/invoices/" + generatedInvoice.getId())).body(generatedInvoice);
    }

    @PutMapping("/{id}/{customerId}")
    public ResponseEntity<InvoiceDto> updateInvoice(@PathVariable Long id, @PathVariable Long customerId, @RequestBody InvoiceDto invoiceData) {
        InvoiceDto updatedInvoice = invoiceService.updateInvoice(id, customerId, invoiceData);
        return ResponseEntity.ok(updatedInvoice);
    }

    @DeleteMapping("/{id}/{customerId}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id, @PathVariable Long customerId) {
        invoiceService.deleteInvoice(id, customerId);
        return ResponseEntity.noContent().build();
    }
}