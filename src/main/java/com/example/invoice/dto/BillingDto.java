package com.example.invoice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BillingDto {
    private Long billingID;    
    private BigDecimal amount;
    private String billingStatus;
    private LocalDate dueDate;
    
    public Long getBillingID() {
        return billingID;
    }
    public void setBillingID(Long billingID) {
        this.billingID = billingID;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getBillingStatus() {
        return billingStatus;
    }
    public void setBillingStatus(String billingStatus) {
        this.billingStatus = billingStatus;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    
    @Override
    public String toString() {
        return "BillingDto [billingID=" + billingID + ", amount=" + amount + ", billingStatus=" + billingStatus
                + ", dueDate=" + dueDate + "]";
    }
    public BillingDto(Long billingID, BigDecimal amount, String billingStatus, LocalDate dueDate) {
        this.billingID = billingID;
        this.amount = amount;
        this.billingStatus = billingStatus;
        this.dueDate = dueDate;
    }
    public BillingDto() {
    }

}
