package salesreport;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class ProductSalesCalculator {

    // Calculate revenue for one product
    public double calculateProductRevenue(Product product) {
        return product.getQuantitySold() * product.getUnitPrice();
    }

    // Calculate total revenue from all products
    public double calculateGrandTotalRevenue(List<Product> products) {

        double totalRevenue = 0;

        for (Product product : products) {
            totalRevenue += calculateProductRevenue(product);
        }

        return totalRevenue;
    }

    // Calculate total revenue for each category
    public Map<String, Double> calculateCategoryRevenue(List<Product> products) {

        Map<String, Double> categoryRevenue = new LinkedHashMap<>();

        for (Product product : products) {

            String category = product.getCategory();

            double revenue = calculateProductRevenue(product);

            categoryRevenue.put(
                    category,
                    categoryRevenue.getOrDefault(category, 0.0) + revenue
            );
        }

        return categoryRevenue;
    }

    // Find the best-selling product by quantity sold
    public Product findBestSellingProduct(List<Product> products) {

        if (products == null || products.isEmpty()) {
            return null;
        }

        Product bestSelling = products.get(0);

        for (Product product : products) {

            if (product.getQuantitySold()
                    > bestSelling.getQuantitySold()) {

                bestSelling = product;
            }
        }

        return bestSelling;
    }

    // Find the product with the highest revenue
    public Product findHighestRevenueProduct(List<Product> products) {

        if (products == null || products.isEmpty()) {
            return null;
        }

        Product highestRevenue = products.get(0);

        for (Product product : products) {

            if (calculateProductRevenue(product)
                    > calculateProductRevenue(highestRevenue)) {

                highestRevenue = product;
            }
        }

        return highestRevenue;
    }
}