import java.util.ArrayList;

public class Customer extends User {
    private ArrayList<Products> pastPurchase;
    private ArrayList<Integer> purchaseCount;
    public Customer(String email, String name, String password) {
        super(email, name, password);
        pastPurchase = new ArrayList<>();
        purchaseCount = new ArrayList<>();
    }

    public ArrayList<Products> getPastPurchase() {
        return pastPurchase;
    }

    public void setPastPurchase(ArrayList<Products> pastPurchase) {
        this.pastPurchase = pastPurchase;
    }

    public ArrayList<Integer> getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(ArrayList<Integer> purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public void addProducts(Products products) {
        pastPurchase.add(products);
    }
}
