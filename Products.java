public class Products {
    private String name;
    private double price;
    private int quantity;
    private String description;
    private int sales;
    private String storeName; //edit; store name added as a parameter to allow backtracking if necessary

    public Products(String name, double price, int quantity, String description, int sales, String storeName) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.storeName = storeName;
        this.sales = sales; //allow sales to be inputted directly
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    
    public String toString() {
        return String.format("Product Name: " + getName() + ", Description: " + getDescription()
        + ", Quantity Available: " + getQuantity() + ", Price: " + getPrice());
    }
    
}
