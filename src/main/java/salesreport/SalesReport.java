
package salesreport;

import java.util.Map;

public class SalesReport {

    private Map<String, Double> categoryRevenue;
    private double grandTotalRevenue;
    private Product bestSellingProduct;
    private Product highestRevenueProduct;

    public SalesReport(
            Map<String, Double> categoryRevenue,
            double grandTotalRevenue,
            Product bestSellingProduct,
            Product highestRevenueProduct) {

        this.categoryRevenue = categoryRevenue;
        this.grandTotalRevenue = grandTotalRevenue;
        this.bestSellingProduct = bestSellingProduct;
        this.highestRevenueProduct = highestRevenueProduct;
    }

    public Map<String, Double> getCategoryRevenue() {
        return categoryRevenue;
    }

    public double getGrandTotalRevenue() {
        return grandTotalRevenue;
    }

    public Product getBestSellingProduct() {
        return bestSellingProduct;
    }

    public Product getHighestRevenueProduct() {
        return highestRevenueProduct;
    }
}
