package salesreport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalculatorTest {

    public static void main(String[] args) {

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

        System.out.println("---VERIFY PRODUCT REVENUE---");

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

        System.out.println("\n---VERIFY CATEGORY REVENUE---");

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

        System.out.println("\n--- VERIFY GRAND TOTAL ---");

        double grandTotal =
                calculator.calculateGrandTotalRevenue(products);

        verify(
                "Grand Total",
                871.25,
                grandTotal
        );
    }

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