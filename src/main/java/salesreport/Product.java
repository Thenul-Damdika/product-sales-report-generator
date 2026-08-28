package salesreport;

public class Product {
  private String productId;
  private String productName;
  private String category;
  private int quantitySold;
  private double unitPrice;

  public Product(String productId, String productName, String category,
    int quantitySold, double unitPrice) {

this.productId = productId;
this.productName = productName;
this.category = category;
this.quantitySold = quantitySold;
this.unitPrice = unitPrice;
}

public String getProductId() {
  return productId;
}

public String getProductName() {
  return productName;
}

public String getCategory() {
  return category;
}

public int getQuantitySold() {
  return quantitySold;
}

public double getUnitPrice() {
  return unitPrice;
}

@Override
public String toString() {
    return "Product{" +
            "productId='" + productId + '\'' +
            ", productName='" + productName + '\'' +
            ", category='" + category + '\'' +
            ", quantitySold=" + quantitySold +
            ", unitPrice=" + unitPrice +
            '}';
}
}