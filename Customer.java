import java.util.ArrayList;

public class Customer extends User {
    private ArrayList<String> pastPurchase;
    private ArrayList<Integer> purchaseCount;
    public Customer(String email, String name, String password) {
        super(email, name, password);
        pastPurchase = new ArrayList<>();
        purchaseCount = new ArrayList<>();
    }

    public ArrayList<String> getPastPurchase() {
        return pastPurchase;
    }

    public void setPastPurchase(ArrayList<String> pastPurchase) {
        this.pastPurchase = pastPurchase;
    }

    public ArrayList<Integer> getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(ArrayList<Integer> purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public void addProducts(String products, int purchases) {
        int index = 0;
        for (String product : pastPurchase) {
            if (product.equals(products)) {
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
}
