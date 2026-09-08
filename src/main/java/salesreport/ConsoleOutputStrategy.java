package salesreport;
import java.util.List;
import java.util.Map;

public class ConsoleOutputStrategy {

   public void displayReport( List<Product> products, SalesReport report, ProductSalesCalculator calculator){
       printHeader();
       printProductRevenue(products, calculator);
       printCategoryRevenue(report);
       printGrandTotal(report);
       printHighlights(report, calculator);
       printFooter();
    }

    private void printProduct(Product product,double revenue){
        System.out.printf("%s %-20s %-15s $%.2f%n",
                product.getProductId(),
                product.getProductName(),
                product.getCategory(),
                revenue
        );
    }

   private void printHeader(){
       System.out.println();
       System.out.println("-----------------------------------------------");
       System.out.println("              Sales Report Summary             ");
       System.out.println("-----------------------------------------------");
    }



    private void printProductRevenue(List<Product> products, ProductSalesCalculator calculator){
        System.out.println();
        System.out.println("Product Revenue");
        System.out.println("-------------------------------");

        for(Product product :products ){
            double revenue =calculator.calculateProductRevenue(product);
            printProduct(product,revenue);
        }
    }

    private void printCategoryRevenue(SalesReport report){
        System.out.println();
        System.out.println("Category Revenue");
        System.out.println("-------------------------------");

        for (Map.Entry<String, Double> entry :
                report.getCategoryRevenue().entrySet()) {

            System.out.printf("%-20s $%.2f%n", entry.getKey(), entry.getValue());
        }
    }

    private void printGrandTotal(SalesReport report){
        System.out.println();
        System.out.println("Grand total");
        System.out.println("-------------------------------");

        System.out.printf("Grand Total Revenue: $%.2f%n", report.getGrandTotalRevenue());

    }

    private void printHighlights(
            SalesReport report,
            ProductSalesCalculator calculator) {

        System.out.println();
        System.out.println("HIGHLIGHTS");
        System.out.println("----------------------------------------");

        Product bestSelling = report.getBestSellingProduct();
        Product highestRevenue = report.getHighestRevenueProduct();

        System.out.println(
                "Best-Selling Product: "
                        + bestSelling.getProductName()
                        + " - "
                        + bestSelling.getQuantitySold()
                        + " units");

        double highestRevenueAmount = calculator.calculateProductRevenue(highestRevenue);

        System.out.printf("Highest-Revenue Product: %s - $%.2f%n",
                highestRevenue.getProductName(),
                highestRevenueAmount
        );
    }

    private void printFooter(){
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("               End of the Report               ");
        System.out.println("-----------------------------------------------");
    }
}