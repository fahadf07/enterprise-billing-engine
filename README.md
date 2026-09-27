# Enterprise Java Invoice Processing & Reporting Engine

A high-performance, robust Java backend application designed to automate corporate billing workflows, ingest transactional data, and generate financial audit reports.

## 🛠️ Key Capabilities
* **File Ingestion Pipeline:** Parses batch transaction records efficiently using standard Java I/O Streams (`Files.lines`).
* **Automated Financial Rules:** Programmatically processes local tax structures (Ontario HST @ 13%) and dynamically flags account delinquencies.
* **Audit-Ready Reporting:** Features decoupled, encapsulated services for reading raw business schemas and formatting data pipelines.

## 💻 Tech Stack
* **Language:** Java 27 / OpenJDK
* **Build Tool:** Maven
* **Core Concepts:** Object-Oriented Design, Encapsulation, Functional Streams API, File I/O Handling
