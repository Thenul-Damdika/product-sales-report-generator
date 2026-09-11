package salesreport;

public class ConsoleOutputStrategy implements ReportOutputStrategy {

   
    @Override
    public void generateReport(SalesReport report) {
        System.out.println("Console report generation pending Dimuth's implementation.");
    }

  
    public void printProduct(Product product, double revenue) {
        System.out.printf("%s %-20s %-15s $%.2f%n", product.getProductId(), product.getProductName(), product.getCategory(), revenue);
    }
}