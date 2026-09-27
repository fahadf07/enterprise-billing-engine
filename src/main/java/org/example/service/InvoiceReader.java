package org.example.service;

import org.example.model.Invoice;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InvoiceReader {

    /**
     * Reads a CSV file containing invoice records and parses them into a list of Invoice objects.
     * @param filePath The relative path to the input CSV file.
     * @return A list of populated Invoice models.
     */
    public List<Invoice> readInvoicesFromCSV(String filePath) {
        List<Invoice> invoices = new ArrayList<>();

        // Using try-with-resources to automatically close the file stream when finished
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {

            invoices = lines
                    .filter(line -> line != null && !line.trim().isEmpty()) // Skip empty lines
                    .map(line -> {
                        // Split fields by commas (Standard CSV format)
                        String[] data = line.split(",");

                        String id = data[0].trim();
                        String clientName = data[1].trim();
                        double amount = Double.parseDouble(data[2].trim());
                        LocalDate dueDate = LocalDate.parse(data[3].trim()); // Expected format: YYYY-MM-DD

                        return new Invoice(id, clientName, amount, dueDate);
                    })
                    .collect(Collectors.toList());

        } catch (IOException e) {
            System.err.println("Critical Error: Unable to read file at path " + filePath);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Parsing Error: Make sure your CSV data structure is completely valid.");
            e.printStackTrace();
        }

        return invoices;
    }
}
