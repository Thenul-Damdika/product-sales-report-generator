package salesreport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalculatorTest {

    public static void main(String[] args) {

        // Create sample product list
        List<Product> products = new ArrayList<>();

        products.add(new Product(
                "P001",
                "Wireless Mouse",
                "Electronics",
                34,
                9.00
        ));

        products.add(new Product(
                "P002",
                "Keyboard",
                "Electronics",
                15,
                8.75
        ));

        products.add(new Product(
                "P003",
                "USB Flash Drive",
                "Electronics",
                24,
                6.00
        ));

        products.add(new Product(
                "P004",
                "Notebook",
                "Stationery",
                20,
                2.50
        ));

        products.add(new Product(
                "P005",
                "Ballpoint Pen",
                "Stationery",
                100,
                2.40
        ));

        ProductSalesCalculator calculator =
                new ProductSalesCalculator();

        // =====================================
        // VERIFY PRODUCT REVENUE
        // =====================================

        System.out.println("=== VERIFY PRODUCT REVENUE ===");

        double[] expectedRevenues = {
                306.00,
                131.25,
                144.00,
                50.00,
                240.00
        };

        for (int i = 0; i < products.size(); i++) {

            Product product = products.get(i);

            double actual =
                    calculator.calculateProductRevenue(product);

            double expected = expectedRevenues[i];

            boolean passed =
                    Math.abs(actual - expected) < 0.001;

            System.out.printf(
                    "%s (%s): Expected $%.2f | Actual $%.2f | %s%n",
                    product.getProductId(),
                    product.getProductName(),
                    expected,
                    actual,
                    passed ? "PASS" : "FAIL"
            );
        }

        // =====================================
        // VERIFY CATEGORY REVENUE
        // =====================================

        System.out.println("\n=== VERIFY CATEGORY REVENUE ===");

        Map<String, Double> categoryRevenue =
                calculator.calculateCategoryRevenue(products);

        verify(
                "Electronics",
                581.25,
                categoryRevenue.get("Electronics")
        );

        verify(
                "Stationery",
                290.00,
                categoryRevenue.get("Stationery")
        );

        // =====================================
        // VERIFY GRAND TOTAL
        // =====================================

        System.out.println("\n=== VERIFY GRAND TOTAL ===");

        double grandTotal =
                calculator.calculateGrandTotalRevenue(products);

        verify(
                "Grand Total",
                871.25,
                grandTotal
        );

        // =====================================
        // VERIFY BEST-SELLING PRODUCT
        // =====================================

        System.out.println("\n=== VERIFY BEST-SELLING PRODUCT ===");

        Product bestSelling =
                calculator.findBestSellingProduct(products);

        boolean bestSellerPassed =
                bestSelling != null
                && bestSelling.getProductName().equals("Ballpoint Pen")
                && bestSelling.getQuantitySold() == 100;

        System.out.printf(
                "Best Seller: Expected Ballpoint Pen (100 units) | "
                + "Actual %s (%d units) | %s%n",
                bestSelling.getProductName(),
                bestSelling.getQuantitySold(),
                bestSellerPassed ? "PASS" : "FAIL"
        );

        // =====================================
        // VERIFY HIGHEST-REVENUE PRODUCT
        // =====================================

        System.out.println("\n=== VERIFY HIGHEST-REVENUE PRODUCT ===");

        Product highestRevenue =
                calculator.findHighestRevenueProduct(products);

        double highestRevenueAmount =
                calculator.calculateProductRevenue(highestRevenue);

        boolean highestRevenuePassed =
                highestRevenue != null
                && highestRevenue.getProductName().equals("Wireless Mouse")
                && Math.abs(highestRevenueAmount - 306.00) < 0.001;

        System.out.printf(
                "Highest Revenue: Expected Wireless Mouse ($306.00) | "
                + "Actual %s ($%.2f) | %s%n",
                highestRevenue.getProductName(),
                highestRevenueAmount,
                highestRevenuePassed ? "PASS" : "FAIL"
        );

        // =====================================
        // CREATE SALES REPORT
        // =====================================

        System.out.println("\n=== CREATE SALES REPORT ===");

        SalesReport report = new SalesReport(
                categoryRevenue,
                grandTotal,
                bestSelling,
                highestRevenue
        );

        System.out.println("SalesReport created successfully.");

        // Verify SalesReport data
        verify(
                "Report Grand Total",
                871.25,
                report.getGrandTotalRevenue()
        );

        verify(
                "Report Electronics Revenue",
                581.25,
                report.getCategoryRevenue().get("Electronics")
        );

        verify(
                "Report Stationery Revenue",
                290.00,
                report.getCategoryRevenue().get("Stationery")
        );

        boolean reportBestSellerPassed =
                report.getBestSellingProduct() != null
                && report.getBestSellingProduct()
                        .getProductName()
                        .equals("Ballpoint Pen");

        System.out.printf(
                "Report Best Seller: Expected Ballpoint Pen | "
                + "Actual %s | %s%n",
                report.getBestSellingProduct().getProductName(),
                reportBestSellerPassed ? "PASS" : "FAIL"
        );

        boolean reportHighestRevenuePassed =
                report.getHighestRevenueProduct() != null
                && report.getHighestRevenueProduct()
                        .getProductName()
                        .equals("Wireless Mouse");

        System.out.printf(
                "Report Highest Revenue: Expected Wireless Mouse | "
                + "Actual %s | %s%n",
                report.getHighestRevenueProduct().getProductName(),
                reportHighestRevenuePassed ? "PASS" : "FAIL"
        );
    }

    // =====================================
    // VERIFY HELPER METHOD
    // =====================================

    public static void verify(
            String name,
            double expected,
            double actual) {

        boolean passed =
                Math.abs(actual - expected) < 0.001;

        System.out.printf(
                "%s: Expected $%.2f | Actual $%.2f | %s%n",
                name,
                expected,
                actual,
                passed ? "PASS" : "FAIL"
        );
    }
}


