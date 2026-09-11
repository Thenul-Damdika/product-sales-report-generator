package salesreport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {

    public List<Product> readProducts(String filePath) {
        List<Product> products = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            
            while ((line = br.readLine()) != null) {
            
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; 
                }
                
                String[] data = line.split(",");
                
               
                if (data.length == 5) {
                    String id = data[0].trim();
                    String name = data[1].trim();
                    String category = data[2].trim();
                    int quantity = Integer.parseInt(data[3].trim());
                    double price = Double.parseDouble(data[4].trim());
                    
                    products.add(new Product(id, name, category, quantity, price));
                }
            }
        } catch (IOException e) {
            System.err.println("Error: CSV file not found or cannot be read at " + filePath);
            System.exit(1); 
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid numeric data in the CSV file.");
            System.exit(1); 
        }
        
        return products;
    }
}