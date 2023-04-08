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
    public int checkChoice(Scanner scan, int lastNum){
        int choice;
        do {
            try {
                choice = Integer.parseInt(scan.nextLine());
                if (choice > 0 && choice < lastNum + 1){
                    return choice;
                }
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid option!");
            }
        } while (true);
    }
    public int checkInt(Scanner scan){
        int choice;
        do {
            try {
                choice = Integer.parseInt(scan.nextLine());
                return choice;
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid option!");
            }
        } while (true);
    }
    public double checkDouble(Scanner scan){
        double choice;
        do {
            try {
                choice = Double.parseDouble(scan.nextLine());
                return choice;
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid option!");
            }
        } while (true);
    }
    /*
     * Seller main menu code
     */
    public void sellerMainMenu(Scanner scan){
        int choice;
        do {
            System.out.println("1. View booths");
            System.out.println("2. Add booth");
            System.out.println("3. Edit booth");
            System.out.println("4. Remove booth");
            System.out.println("5. Go back");
            choice = checkChoice(scan, 5);
            if (choice == 1) {
                int count = 0;
                System.out.println("Which booth would you like to view?");
                for (Store store : storeList) {
                    count++;
                    System.out.println(count + ". " + store.name);
                }
                if (count == 0) {
                    System.out.println("No booths found!");
                } else {
                    choice = checkChoice(scan, count);
                    storeList.get(choice - 1).viewStore(scan);
                }
            } else if (choice == 2){
                System.out.println("Enter the name of the booth: ");
                String storeName = scan.nextLine();
                storeList.add(new Store(storeName, getName(), getEmail()));
            } else if (choice == 3){
                // TODO edit booth
            } else if (choice == 4){
                // TODO remove booth
            }
            else if (choice == 5){
                break;
            }
        } while (true);
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
