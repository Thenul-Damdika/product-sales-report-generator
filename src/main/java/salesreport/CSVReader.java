package salesreport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public List<Product> readProducts(String filePath) throws IOException {

        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip the header
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] values = line.split(",");

                String productId = values[0].trim();
                String productName = values[1].trim();
                String category = values[2].trim();
                int quantitySold = Integer.parseInt(values[3].trim());
                double unitPrice = Double.parseDouble(values[4].trim());

                Product product = new Product(
                        productId,
                        productName,
                        category,
                        quantitySold,
                        unitPrice
                );

                products.add(product);
            }
        }

        return products;
    }
}