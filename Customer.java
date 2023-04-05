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

    public void addProducts(Products products, int purchases) {
        int index = 0;
        for (Products product : pastPurchase) {
            if (equals(product, products)) {
                purchaseCount.set(index, purchaseCount.get(index) + purchases);
                break;
            }
            index++;
        }
        if (index == pastPurchase.size()) {
            pastPurchase.add(products);
            purchaseCount.add(purchases);
        }
    }

    public boolean equals(Products product1, Products product2) {
        if (product1.getName().equals(product2.getName())) {
            if (product1.getPrice() == product2.getPrice()) {
                if (product1.getDescription().equals(product2.getDescription())) {
                    return true;
                }
            }
        }
        return false;
    }
}
