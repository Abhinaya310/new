package com.example.invoice.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private LocalDateTime invoiceDate;
    private LocalDateTime dueDate;
    private BigDecimal total;
    private String status;

    // Added fields
    private String phoneNo;
    private String email;
    private String name;
    private String plans; // New field
    
    public Invoice(Long id, Long customerId, LocalDateTime invoiceDate, LocalDateTime dueDate, BigDecimal total,
            String status, String phoneNo, String email, String name, String plans) {
        this.id = id;
        this.customerId = customerId;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.total = total;
        this.status = status;
        this.phoneNo = phoneNo;
        this.email = email;
        this.name = name;
        this.plans = plans;
    }
    public Invoice() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }
    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPlans() {
        return plans;
    }
    public void setPlans(String plans) {
        this.plans = plans;
    }

   
}