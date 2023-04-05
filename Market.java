import java.util.Scanner;
import java.util.ArrayList;
public class Market {
    public static final String WELCOME = "Welcome to the marketplace!";
    public static final String LOGIN = "Are you an existing user?";
    public static final String ENTERVALID = "Please enter a valid option!";
    public static final String YESNO = "1. Yes\n2. No";
    public static final String ENTERLOGIN = "Please enter your email address.";
    public static final String NOUSER = "No user found with given email!";
    public static final String ENTERPSWD = "Please enter your password.";
    public static final String NOPSWD = "Incorrect password!";
    public static final String HI = "Welcome back!";
    public static final String BYE = "Sorry to see you go!";
    public static final String OPTIONS = "Please choose your option:";
    public static final String SELLORCUST = "Would you like to join as a\n1. Customer\n2. Seller";
    public static final String ENTERNAME = "Please enter your name";


    //seller
    public static final String SELLEROPTIONS = "1. Manage Stores\n2. View sales";
    public static final String STOREOPTION = "Which store would you like to access?";
    public static final String STORESPEC = "1. Create products\n2. Modify existing products";
    public static final String NEWOPTIONS = "Would you like to import csv file?";
    public static final String FILEIMPORT = "Please enter the name of file:";

    //customer
    public static final String MAINCUSTMENU = "Main Menu\n1. View/edit your account\n2. View marketplace";
    public static final String CUSTACCOUNTMENU = "Account Menu:\n1. Edit your name\n2. Edit your username\n" +
            "3. Edit your password\n4. Delete your account";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = -1; //scanner choice
        boolean invalidChoice = false; //the boolean I'll use for do-while loops to check invalid input
        ArrayList<User> userList = new ArrayList<>();
        User currentUser = null; //the current user of the program

        //TODO here call the method that parses through the files and gets all the info
        //for buyers and sellers and etc

        System.out.println(WELCOME);
        do {
            System.out.println(LOGIN);
            System.out.println(YESNO);
            try {
                choice = Integer.parseInt(scan.nextLine());
                if (choice != 1 && choice != 2) {
                    invalidChoice = true;
                    System.out.println(ENTERVALID);
                } else {
                    invalidChoice = false;
                }
            } catch (NumberFormatException e) {
                invalidChoice = true;
                System.out.println(ENTERVALID);
            }
        } while (invalidChoice);
        invalidChoice = false;
        if (choice == 1) { //sign in
            //code for signing in
        } else if (choice == 2) { //Create an account
            do {
                System.out.println(SELLORCUST);
                try {
                    choice = Integer.parseInt(scan.nextLine());
                    if (choice != 1 && choice != 2) {
                        invalidChoice = true;
                        System.out.println(ENTERVALID);
                    } else {
                        invalidChoice = false;
                    }
                } catch (NumberFormatException e) {
                    invalidChoice = true;
                    System.out.println(ENTERVALID);
                }
            } while (invalidChoice);
            if (choice == 1) { //customer
                System.out.println(ENTERNAME);
                String name = scan.nextLine();
                System.out.println(ENTERLOGIN);
                String email = scan.nextLine();
                System.out.println(ENTERPSWD);
                String password = scan.nextLine();
                //TODO check and make sure the email isn't the same as anyone else
                currentUser = new Customer(email, name, password);

            } else { //seller
                System.out.println(ENTERNAME);
                String name = scan.nextLine();
                System.out.println(ENTERLOGIN);
                String email = scan.nextLine();
                System.out.println(ENTERPSWD);
                String password = scan.nextLine();
                //TODO check and make sure the email isn't the same as anyone else

                currentUser = new Seller(email, name, password);
            }

        }
        //NOW CODE FOR RUNNING MARKETPLACE, ETC

        if (currentUser instanceof Customer) {


        } else if (currentUser instanceof Seller) {

        } else {
            System.out.println("User was not initialized");
        }



    }




}
