package salesreport;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.err.println(
                    "Usage: java SalesReporter <csv-file-path> <output-method> [output-file-path]"
            );
            return;
        }

        String csvFilePath = args[0];
        String outputMethod = args[1];

        if (!outputMethod.equalsIgnoreCase("console")
                && !outputMethod.equalsIgnoreCase("file")) {

            System.err.println(
                    "Error: Invalid output method. Use 'console' or 'file'."
            );
            return;
        }

        if (outputMethod.equalsIgnoreCase("file") && args.length < 3) {
            System.err.println(
                    "Error: Output file path is required when using 'file' output."
            );
            return;
        }

        CsvFileReader reader = new CsvFileReader();
        List<Product> products = reader.readProducts(csvFilePath);

        if (products.isEmpty()) {
            System.err.println("Error: No valid products found in the CSV file.");
            return;
        }

        ProductSalesCalculator calculator = new ProductSalesCalculator();
        
        Map<String, Double> categoryRevenue = calculator.calculateCategoryRevenue(products);
        double grandTotal = calculator.calculateGrandTotalRevenue(products);
        Product bestSelling = calculator.findBestSellingProduct(products);
        Product highestRevenue = calculator.findHighestRevenueProduct(products);

        SalesReport report = new SalesReport(
                categoryRevenue, 
                grandTotal, 
                bestSelling, 
                highestRevenue
        );

        ReportOutputStrategy outputStrategy;
        
        if (outputMethod.equalsIgnoreCase("file")) {
            outputStrategy = new FileOutputStrategy(args[2]);
        } else {
            // Note: Work for Dimuth
            outputStrategy = new ConsoleOutputStrategy(); 
        }

        outputStrategy.generateReport(report);
    }
}