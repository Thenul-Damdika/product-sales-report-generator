package salesreport;

public class ConsoleOutputStrategy {

    public void printProduct(Product product, double revenue) {
        System.out.printf("%s %-20s %-15s $%.2f%n", product.getProductId(), product.getProductName(), product.getCategory(), revenue);
    }
}