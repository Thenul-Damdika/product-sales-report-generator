<h1 align="center">📊 Product Sales Report Generator</h1>

<p align="center">
  A command-line Java application for generating product sales reports from CSV data.
</p>

<p align="center">
  <strong>SENG 21222 – Software Construction</strong><br>
  University of Kelaniya
</p>

---

## ❓ About the Project

The **Product Sales Report Generator** is a command-line Java application that reads product sales data from a CSV file, calculates sales statistics, and generates a formatted sales report.

The project was developed as part of the **SENG 21222 – Software Construction** assignment at the **University of Kelaniya**.

## ✨ Features

- Read product sales data from a CSV file
- Calculate revenue for each product
- Calculate total revenue for each category
- Calculate grand total revenue
- Identify the best-selling product by quantity sold
- Identify the product with the highest revenue
- Display a formatted sales report in the console
- Generate a sales report to a file
- Validate command-line arguments
- Handle invalid input and file-related errors
- Support extensible output methods

## 🛠️ Technologies Used

- **Java**
- **Maven**
- **JUnit 5**
- **Git**
- **Github**
- **IntelliJ Idea**

## 📁 Project Structure

```text
product-sales-report-generator/
│
├── data/
│   └── products.csv
│
├── output/
│   └── .gitkeep
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── salesreport/
│   │
│   └── test/
│       └── java/
│           └── salesreport/
│
├── pom.xml
├── .gitignore
└── README.md
```

## 📄 CSV File Format

The input CSV file should follow this format:

```csv
productId,productName,category,quantitySold,unitPrice
P001,Wireless Mouse,Electronics,30,10.20
P002,Ballpoint Pen,Stationery,100,1.25
```

The first row is treated as the CSV header.

## 🛂  Command-Line Usage

The application uses the following command format:

```text
java SalesReporter <csv-file-path> <output-method> [output-file-path]
```

Supported output methods:

- `console` – displays the report in the terminal
- `file` – writes the report to the specified output file

### Console Output

```text
java SalesReporter data/products.csv console
```

### File Output

```text
java SalesReporter data/products.csv file output/report.txt
```

When using `file` output, the output file path must be provided as the third argument.

## 🧪 Testing

Run the automated tests using Maven:

```bash
mvn test
```

### CLI Test Cases

Valid console output:

```text
data/products.csv console
```

Valid file output:

```text
data/products.csv file output/report.txt
```

Missing CSV file:

```text
wrong.csv console
```

Invalid output method:

```text
data/products.csv pdf
```

Missing file output path:

```text
data/products.csv file
```

## 👥 Team Contributions

This project was developed by a three-member team.

### Member 1 – Core Business Logic

- Product model
- Sales calculations
- Sales report model
- Core report generation functionality

### Member 2 – File I/O, Testing and SOLID Design

- File input/output functionality
- Output strategy abstraction
- File output strategy
- Unit testing
- SOLID design support

### Member 3 – CLI, Console Output, Exception Handling and Documentation

- Command-line argument validation
- Console report output
- CLI exception and error handling
- README documentation
- Final documentation coordination

## 🔀 Version Control

Development is managed using **Git and Github**.

Each team member works on an individual branch and makes meaningful commits for their own contribution.

The branches are integrated into the final project after implementation and testing.

## 🎓 Academic Information

**Course:** SENG 21222 – Software Construction  
**Institution:** University of Kelaniya  
**Project:** Command Line Product Sales Report Generator

---

<p align="center">
  <strong>Developed as part of the SENG 21222 Software Construction assignment.</strong>
</p>