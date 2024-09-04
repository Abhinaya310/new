package com.example.invoice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.invoice.Entity.Invoice;
import com.example.invoice.Repository.InvoiceRepository;
import com.example.invoice.dto.InvoiceDto;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    @Value("${billing.service.url}")
    private String billingServiceUrl;
    // Convert Entity to DTO
    private InvoiceDto convertToDTO(Invoice invoice) {
    InvoiceDto dto = new InvoiceDto();
    dto.setId(invoice.getId());
    dto.setCustomerId(invoice.getCustomerId());
    dto.setInvoiceDate(invoice.getInvoiceDate());
    dto.setDueDate(invoice.getDueDate());
    dto.setTotal(invoice.getTotal());
    dto.setStatus(invoice.getStatus());
    // Do not fetch additional data here
    return dto;
}

// Convert DTO to Entity
    private Invoice convertToEntity(InvoiceDto dto) {
    Invoice invoice = new Invoice();
    invoice.setId(dto.getId());
    invoice.setCustomerId(dto.getCustomerId());
    invoice.setInvoiceDate(dto.getInvoiceDate());
    invoice.setDueDate(dto.getDueDate());
    invoice.setTotal(dto.getTotal());
    invoice.setStatus(dto.getStatus());
    return invoice;
}



     

    public List<InvoiceDto> getInvoices(Long customerId) {
        return invoiceRepository.findByCustomerId(customerId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public InvoiceDto generateInvoice(InvoiceDto invoiceDTO) {
        Invoice invoice = convertToEntity(invoiceDTO);
        invoice.setInvoiceDate(LocalDateTime.now());
        invoice.setStatus("PENDING");
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return convertToDTO(savedInvoice);
    }

    public InvoiceDto updateInvoice(Long id, Long customerId, InvoiceDto invoiceDTO) {
        Invoice invoice = invoiceRepository.findByIdAndCustomerId(id, customerId)
            .orElseThrow(() -> new RuntimeException("Invoice not found"));
        invoice.setDueDate(invoiceDTO.getDueDate());
        invoice.setTotal(invoiceDTO.getTotal());
        return convertToDTO(invoiceRepository.save(invoice));
    }

    public void deleteInvoice(Long id, Long customerId) {
        Invoice invoice = invoiceRepository.findByIdAndCustomerId(id, customerId)
            .orElseThrow(() -> new RuntimeException("Invoice not found"));
        invoiceRepository.delete(invoice);
    }
}
