
<h1 style="color: #63a4f1;text-align: center;text-decoration: underline">Product Sales Report Generator</h1>
<p>This is a command line java application that reads product sales data from a CSV file,calculate sale statistics and generate formatted sales report.</p>
<h6>This project was developed as part of the <b><em>SENG 21222 – Software Construction</em></b> assignment at the <b><em>University of Kelaniya.</em></b></h6>

<h2 style="color: goldenrod;">Features</h2>
    <ul style="list-style-type:disc;">
        <li>Read product sales data from a CSV file</li>
        <li>Calculate revenue for each product</li>
        <li>Calculate total revenue for each category</li>
        <li>Calculate grand total revenue</li>
        <li>Identify the best-selling product by quantity sold</li>
        <li>Identify the product with the highest revenue</li>
        <li>Display a formatted sales report in the console</li>
        <li>Validate command-line arguments</li>
        <li>Handle invalid input and file-related errors</li>
        <li>Support extensible output methods</li>
    </ul>

<h2 style="color: goldenrod;">Technologies Used</h2>
<ul>
<li>Java</li>
<li>Maven</li>
<li>Junit</li>
<li>Git</li>
<li>Github</li>
<li>Intelij Idea</li>
</ul>

<h2 style="color: goldenrod;">Project Structure</h2>


```text
product-sales-report-generator/
|__ data/
|   |__ products.csv
|__ src/
|   |__ main/
|   |   |__ java/
|   |       |__ salesreport/
|   |__ test/
|       |__ java/
|           |__ salesreport/
|__ pom.xml
|__ README.md

```
<h2>CSV File Format</h2>

<p>The input CSV file should follow this format:</p>

```csv
productId,productName,category,quantitySold,unitPrice
P001,Wireless Mouse,Electronics,30,10.20
P002,Ballpoint Pen,Stationery,100,1.25
```

<h2>Command-Line Usage</h2>

```text
java SalesReporter <csv-file-path> <output-method> [output-file-path]
```

<h3>Console Output</h3>

```text
java SalesReporter data/products.csv console
```

<h3>File Output</h3>

```text
java SalesReporter data/products.csv file output/report.txt
```

<h2>Testing</h2>

<p>Run the automated tests using Maven:</p>

```text
mvn test
```

<p>Example CLI test cases:</p>

```text
data/products.csv console
wrong.csv console
data/products.csv pdf
data/products.csv file
```
<h2>Team Contributions</h2>

<p>This project was developed by a three-member team.</p>

<h3>Member 1 - Core Business Logic</h3>
<ul>
    <li>Product model</li>
    <li>Sales calculations</li>
    <li>Sales report model</li>
    <li>Core report generation functionality</li>
</ul>

<h3>Member 2 - File I/O, Testing and SOLID Design</h3>
<ul>
    <li>File input/output functionality</li>
    <li>Output strategy abstraction</li>
    <li>File output strategy</li>
    <li>Unit testing</li>
    <li>SOLID design support</li>
</ul>

<h3>Member 3 - CLI, Console Output, Exception Handling and Documentation</h3>
<ul>
    <li>Command-line argument validation</li>
    <li>Console report output</li>
    <li>CLI exception and error handling</li>
    <li>README documentation</li>
    <li>Final documentation coordination</li>
</ul>
<h2>Version Control</h2>

<p>Development is managed using Git and GitHub. Each team member works on an individual branch and makes meaningful commits for their own contribution.</p>

