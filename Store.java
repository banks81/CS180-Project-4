import java.util.*;
public class Store {
    public String name;
    public ArrayList<Products> goods;
    private ArrayList<Customer> customers;
    private double revenue;
    private int sales;
    
    private String sellerName;
    private String sellerEmail;

    public Store(String name, String sellerName, String sellerEmail) {  //edit; sellerName and sellerEmail as a parameter.
        this.name = name;
        this.sellerName = sellerName;
        this.sellerEmail = sellerEmail;
        goods = new ArrayList<>();
        customers = new ArrayList<>();
        revenue = 0.00;
        sales = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Products> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<Products> goods) {
        this.goods = goods;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void addGoods(Products products) {
        getGoods().add(products);
    }
    
    public String toMarketString() {
        String store = "Store Name: " + getName() + "\nProducts: \n";
        for (int i = 0; i < goods.size(); i++) {
            store = store + goods.get(i).toString() + "\n";
        }
        return store;
        //to print in the market   
    }
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }
    
}
