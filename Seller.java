import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Seller extends User{
    private ArrayList<Store> storeList;
    public Seller(String email, String name, String password) {
        super(email, name, password);
        storeList = new ArrayList<>();
    }
    /* Functions electable
    *
    * Dashboard for displaying stores
    *
    * */
    //FIX IN TERMS OF "SORTING"
    public String dashboard() {
        StringBuilder total = new StringBuilder();
        for (int i = 0; i < storeList.size(); i++) {
            Store store = storeList.get(i);
            total.append(String.format("--------------------\nStore name: %s\nItems: \n", store.getName()));
            for (int j = 0; j < store.getGoods().size(); j++) {
                Products item = store.getGoods().get(j);
                total.append(String.format("  %s, sold %d time", item.getName(), item.getSales()));
                if (item.getSales() > 1) {
                    total.append(String.format("s\n"));
                } else {
                    total.append(String.format("\n"));
                }
            }
            total.append(String.format("Customers: \n"));
            StringBuilder customerList = new StringBuilder();
            for (int j = 0; j < store.getCustomers().size(); j++) {
                Customer currentCust = store.getCustomers().get(j);
                if (customerList.length() > 70) {
                    customerList.append(String.format("\n"));
                }
                customerList.append(String.format("%s, ", currentCust.getName()));
            }
            customerList.delete(customerList.length() - 1, customerList.length());
            total.append(customerList.toString());

            total.append(String.format("\nRevenue: $%.2f\n", store.getRevenue()));
        }
        return total.toString();
    }
    public void newStore(String name) {
        storeList.add(new Store(name));
    }
    public void assignProduct(String fileName, Store store) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String eachLine = bufferedReader.readLine();
                if (eachLine == null) {
                    break;
                }
                try {
                    String[] lineBreak = eachLine.split(",");
                    //Assuming the csv file is in name, price, quantity, description format
                    store.addGoods(new Products(lineBreak[0], Double.parseDouble(lineBreak[1]),
                            Integer.parseInt(lineBreak[2]), lineBreak[3]));
                } catch (Exception e) {
                    System.out.println("Wrong file format!");
                    break;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
