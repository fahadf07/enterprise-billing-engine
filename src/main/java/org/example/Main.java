package org.example;

import org.example.model.Invoice;
import org.example.service.InvoiceReader;
import org.example.service.TaxCalculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("      STARTING ENTERPRISE BILLING ENGINE       ");
        System.out.println("==============================================\n");

        // 1. Initialize our service modules
        InvoiceReader reader = new InvoiceReader();
        TaxCalculator calculator = new TaxCalculator();

        // 2. Define the path to our local data source
        String dataFilePath = "data/input_invoices.csv";

        // 3. Ingest and parse the raw data file
        System.out.println("[INFO] Reading file: " + dataFilePath + "...");
        List<Invoice> invoicePipeline = reader.readInvoicesFromCSV(dataFilePath);

        System.out.println("[INFO] Successfully processed " + invoicePipeline.size() + " records.\n");
        System.out.println("----------------------------------------------");
        System.out.println("                 AUDIT REPORT                 ");
        System.out.println("----------------------------------------------");

        // 4. Loop through each record, apply business logic, and print reports
        for (Invoice invoice : invoicePipeline) {
            double finalAmountWithTax = calculator.calculateTotalWithTax(invoice);
            boolean statusFlag = calculator.isOverdue(invoice);

            System.out.printf("Client: %-18s | Base: $%-8.2f | Gross (with HST): $%-8.2f | Status: %s%n",
                    invoice.getClientName(),
                    invoice.getAmount(),
                    finalAmountWithTax,
                    statusFlag ? "⚠️ OVERDUE - SEND NOTICE" : "✅ CURRENT"
            );
        }

        System.out.println("----------------------------------------------");
        System.out.println("[SUCCESS] Pipeline processing completed cleanly.");
    }
}
