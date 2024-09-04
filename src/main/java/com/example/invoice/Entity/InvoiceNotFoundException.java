package com.example.invoice.Entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvoiceNotFoundException extends RuntimeException{
    public InvoiceNotFoundException(Long id,Long CustomerId)
    {
        super(String.format("Invoice not found for ID %d and customer ID %d",id,CustomerId));
    }


}
