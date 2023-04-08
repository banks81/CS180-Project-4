import java.util.ArrayList;

public class Customer extends User {
    private ArrayList<String> pastPurchase; //edit made, if the code is made under the assumption this is a Products class please let me know
    private ArrayList<Integer> purchaseCount;
    private ArrayList<Products> shoppingCart;
    private ArrayList<String> shoppingCartChanges;

    public Customer(String email, String name, String password) {
        super(email, name, password);
        pastPurchase = new ArrayList<>();
        purchaseCount = new ArrayList<>();
        shoppingCart = new ArrayList<>();
        shoppingCartChanges = new ArrayList<>();

    }
    public ArrayList<Products> getShoppingCart() {
        return shoppingCart;
    }
    public void addToShoppingCart(Products products) {
        shoppingCart.add(products);
    }
    public void removeFromShoppingCart(Products products) {
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (products.equals(shoppingCart.get(i))) {
                shoppingCart.remove(shoppingCart.get(i));
            }
        }
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
    
    public void shoppingCartChangeHelper(String productname, int errorCode) {
        Stringbuilder errorMessage = new Stringbuilder()
        switch (errorCode) {
            case 1 :    //out of stock
                errorMessage.append(String.format("The item %s is out of stock!", productname));
                break;
            case 2 :    //not found on database
                errorMessage.append(String.format("The item %s is not found in our database.", productname));
                break;
            default :
                errorMessage.append(String.format("Unknown error!"));
        }
        errorMessage.append("\nItem %s has been removed from your shopping cart.", productname);
        shoppingCartChanges.add(errorMessage.toString());
    }
}
