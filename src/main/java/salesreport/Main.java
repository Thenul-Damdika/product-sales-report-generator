package salesreport;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

        // Check CSV path and output method are provided
        if (args.length < 2) {
            System.err.println("Usage: java SalesReporter <csv-file-path> <output-method> [output-file-path]");
            return;
        }

        String csvFilePath = args[0];
        String outputMethod = args[1];

        // Validate output method
        if (!outputMethod.equalsIgnoreCase("console")
                && !outputMethod.equalsIgnoreCase("file")) {

            System.err.println(
                    "Error: Invalid output method. Use 'console' or 'file'."
            );
            return;
        }

        // File output requires an output file path
        if (outputMethod.equalsIgnoreCase("file") && args.length < 3) {
            System.err.println(
                    "Error: Output file path is required when using 'file' output."
            );
            return;
        }

        System.out.println("Command-line arguments are valid.");
        System.out.println("CSV file: " + csvFilePath);
        System.out.println("Output method: " + outputMethod);

        try {
            // Read products from CSV
            CSVReader csvReader = new CSVReader();
            List<Product> products = csvReader.readProducts(csvFilePath);

            // Create calculator
            ProductSalesCalculator calculator = new ProductSalesCalculator();

            // Calculate report values
            Map<String, Double> categoryRevenue = calculator.calculateCategoryRevenue(products);

            double grandTotalRevenue = calculator.calculateGrandTotalRevenue(products);

            Product bestSellingProduct = calculator.findBestSellingProduct(products);

            Product highestRevenueProduct = calculator.findHighestRevenueProduct(products);

            // Create SalesReport
            SalesReport report = new SalesReport(
                    categoryRevenue,
                    grandTotalRevenue,
                    bestSellingProduct,
                    highestRevenueProduct
            );

            // Display report
           if(outputMethod.equalsIgnoreCase("console")) {
               ConsoleOutputStrategy consoleOutputStrategy = new ConsoleOutputStrategy();

               consoleOutputStrategy.displayReport(products,report,calculator);
           } else if (outputMethod.equalsIgnoreCase("file")) {
               String outputFilePath = args[2];

               FileOutputStrategy fileOutputStrategy = new FileOutputStrategy(outputFilePath);
               fileOutputStrategy.generateReport(report);
               System.out.println("Sales report successfully saved to: " + outputFilePath);
           }

            System.out.println();
                System.out.println("----------------------------------------");
                System.out.printf("Grand Total Revenue: $%.2f%n", report.getGrandTotalRevenue()
                );

                System.out.println();
                System.out.println("HIGHLIGHTS");
                System.out.println("----------------------------------------");

                System.out.println(
                        "Best-Selling Product: "
                                + report.getBestSellingProduct().getProductName()
                                + " - "
                                + report.getBestSellingProduct().getQuantitySold()
                                + " units"
                );

                System.out.println(
                        "Highest-Revenue Product: "
                                + report.getHighestRevenueProduct().getProductName()
                                + " - $"
                                + String.format(
                                        "%.2f",
                                        calculator.calculateProductRevenue(
                                                report.getHighestRevenueProduct()
                                        )
                                )
                );

                System.out.println();
                System.out.println("========================================");
                System.out.println("             END OF REPORT");
                System.out.println("========================================");


        } catch (java.io.FileNotFoundException e) {

            System.err.println("Error: CSV file not found: " + csvFilePath);

        } catch (NumberFormatException e) {

            System.err.println("Error: Invalid numeric value found in the CSV file.");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error:Invalid CSV format.Required column is missing");
        }catch (IOException e) {
            System.out.println("Error:Reading CSV file:"+e.getMessage());
        } catch (Exception e) {
            System.out.println("Error generating Report:"+e.getMessage());
        }
    }
} 