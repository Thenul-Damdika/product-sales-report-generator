package salesreport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesCalculatorTest {

    private ProductSalesCalculator calculator;
    private List<Product> sampleProducts;

    @BeforeEach
    void setUp() {
        calculator = new ProductSalesCalculator();
    
        sampleProducts = Arrays.asList(
            new Product("P001", "Wireless Mouse", "Electronics", 34, 9.00),
            new Product("P004", "Notebook", "Stationery", 20, 2.50),
            new Product("P005", "Ballpoint Pen", "Stationery", 100, 2.40)
        );
    }

    @Test
    void testCalculateProductRevenue() {
        Product mouse = sampleProducts.get(0);
        double revenue = calculator.calculateProductRevenue(mouse);
        assertEquals(306.00, revenue, 0.001, "Revenue should be 34 * 9.00");
    }

    @Test
    void testFindBestSellingProduct() {
        Product bestSeller = calculator.findBestSellingProduct(sampleProducts);
        assertNotNull(bestSeller);
        assertEquals("Ballpoint Pen", bestSeller.getProductName(), "Ballpoint pen has the highest quantity (100)");
        assertEquals(100, bestSeller.getQuantitySold());
    }

    @Test
    void testCalculateGrandTotalRevenue() {
        double total = calculator.calculateGrandTotalRevenue(sampleProducts);
        // (34 * 9) + (20 * 2.5) + (100 * 2.4) = 306 + 50 + 240 = 596
        assertEquals(596.00, total, 0.001);
    }
}