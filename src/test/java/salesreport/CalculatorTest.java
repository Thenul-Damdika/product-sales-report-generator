package salesreport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private List<Product> products;
    private ProductSalesCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new ProductSalesCalculator();
        products = new ArrayList<>();

        products.add(new Product("P001", "Wireless Mouse", "Electronics", 34, 9.00));
        products.add(new Product("P002", "Keyboard", "Electronics", 15, 8.75));
        products.add(new Product("P003", "USB Flash Drive", "Electronics", 24, 6.00));
        products.add(new Product("P004", "Notebook", "Stationery", 20, 2.50));
        products.add(new Product("P005", "Ballpoint Pen", "Stationery", 100, 2.40));
    }

    @Test
    void testCalculateProductRevenue() {
        double[] expectedRevenues = {306.00, 131.25, 144.00, 50.00, 240.00};

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            double actual = calculator.calculateProductRevenue(product);
      
            assertEquals(expectedRevenues[i], actual, 0.001, 
                "Revenue calculation failed for " + product.getProductName());
        }
    }

    @Test
    void testCalculateCategoryRevenue() {
        Map<String, Double> categoryRevenue = calculator.calculateCategoryRevenue(products);

        assertEquals(581.25, categoryRevenue.get("Electronics"), 0.001);
        assertEquals(290.00, categoryRevenue.get("Stationery"), 0.001);
    }

    @Test
    void testCalculateGrandTotalRevenue() {
        double grandTotal = calculator.calculateGrandTotalRevenue(products);
        assertEquals(871.25, grandTotal, 0.001);
    }

    @Test
    void testFindBestSellingProduct() {
        Product bestSelling = calculator.findBestSellingProduct(products);

        assertNotNull(bestSelling, "Best selling product should not be null");
        assertEquals("Ballpoint Pen", bestSelling.getProductName());
        assertEquals(100, bestSelling.getQuantitySold());
    }

    @Test
    void testFindHighestRevenueProduct() {
        Product highestRevenue = calculator.findHighestRevenueProduct(products);

        assertNotNull(highestRevenue, "Highest revenue product should not be null");
        assertEquals("Wireless Mouse", highestRevenue.getProductName());
        
        double expectedRevenue = 34 * 9.00; // 306.00
        double actualRevenue = calculator.calculateProductRevenue(highestRevenue);
        assertEquals(expectedRevenue, actualRevenue, 0.001);
    }
}