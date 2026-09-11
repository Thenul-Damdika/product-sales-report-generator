package salesreport;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class FileOutputStrategy implements ReportOutputStrategy {
    
    private String outputFilePath;

    public FileOutputStrategy(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    @Override
    public void generateReport(SalesReport report) {
      
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
            writer.println("=============================");
            writer.println("SALES SUMMARY REPORT");
            writer.println("=============================");
            
            writer.println("--- Revenue Per Category ---");
            for (Map.Entry<String, Double> entry : report.getCategoryRevenue().entrySet()) {
                writer.printf("%-15s : $%.2f%n", entry.getKey(), entry.getValue());
            }
            
            writer.println("--- Highlights ---");
            writer.printf("Best-Selling Product: %s (%d units)%n", 
                report.getBestSellingProduct().getProductName(), 
                report.getBestSellingProduct().getQuantitySold());
                
            writer.printf("Highest Revenue: %s ($%.2f)%n", 
                report.getHighestRevenueProduct().getProductName(), 
                (report.getHighestRevenueProduct().getQuantitySold() * report.getHighestRevenueProduct().getUnitPrice()));
                
            writer.println("=============================");
            writer.printf("Grand Total Revenue : $%.2f%n", report.getGrandTotalRevenue());
            writer.println("=============================");
            
            System.out.println("Report successfully saved to: " + outputFilePath);
            
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            System.exit(1);
        }
    }
}