package com.example.invoice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.invoice.Entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByCustomerId(Long customerId);
    Optional<Invoice> findByIdAndCustomerId(Long id, Long customerId);
}



