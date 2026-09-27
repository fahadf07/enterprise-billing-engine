package org.example.model;

import java.time.LocalDate;

public class Invoice {
    private String invoiceId;
    private String clientName;
    private double amount;
    private LocalDate dueDate;

    // Full constructor to initialize our data
    public Invoice(String invoiceId, String clientName, double amount, LocalDate dueDate) {
        this.invoiceId = invoiceId;
        this.clientName = clientName;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    // Getters and Setters (Standard encapsulation for data models)
    public String getInvoiceId() { return invoiceId; }
    public void setInvoiceId(String invoiceId) { this.invoiceId = invoiceId; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    // This makes it easy to print and debug our invoices in the console
    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + invoiceId + '\'' +
                ", client='" + clientName + '\'' +
                ", amount=$" + amount +
                ", due=" + dueDate +
                '}';
    }
}
