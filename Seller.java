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
    public void newStore(String storeName) {
        storeList.add(new Store(storeName, getName(), getEmail())); //edit; seller name and email added to field of the store so we may backtrack?
    }
    public void addStore(Store store) {
        storeList.add(store);
    }
    public ArrayList<Store> getStore() {
        return (storeList);
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
                            Integer.parseInt(lineBreak[2]), lineBreak[3], 0, store.getName())); //edit; store name added to the parameter & field of Products
                } catch (Exception e) {                                                         //another edit made to initialize sale as int
                    System.out.println("Wrong file format!");                                   //better when we work with initialization from file IO
                    break;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
