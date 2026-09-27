package org.example.service;

import org.example.model.Invoice;
import java.time.LocalDate;

public class TaxCalculator {
    // Standard Ontario Harmonized Sales Tax (HST) rate
    private static final double HST_RATE = 0.13;

    /**
     * Calculates the final gross amount of an invoice after applying Ontario HST.
     * @param invoice The target invoice model.
     * @return Gross total rounded up to two decimal places.
     */
    public double calculateTotalWithTax(Invoice invoice) {
        double total = invoice.getAmount() * (1 + HST_RATE);
        return Math.round(total * 100.0) / 100.0; // Standard financial rounding
    }

    /**
     * Evaluates if a client's invoice is past due based on the current calendar date.
     * @param invoice The target invoice model.
     * @return true if the deadline has passed and the invoice remains unpaid.
     */
    public boolean isOverdue(Invoice invoice) {
        LocalDate today = LocalDate.now();
        return today.isAfter(invoice.getDueDate());
    }
}
