import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;
public class Market {
    public static final String WELCOME = "Welcome to the marketplace!";
    public static final String LOGIN = "Are you an existing user?";
    public static final String ENTERVALID = "Please enter a valid option!";
    public static final String YESNO = "1. Yes\n2. No";
    public static final String ENTERLOGIN = "Please enter your email address.";
    public static final String NOUSER = "No user found with given credentials!";
    public static final String TRYAGAIN = "Would you like to try again?";
    public static final String ENTERPSWD = "Please enter your password.";
    public static final String EMAILEXISTS = "A user already exists with this username!";

    public static final String HI = "Welcome back!";
    public static final String BYE = "Sorry to see you go!";
    public static final String OPTIONS = "Please choose your option:";
    public static final String SELLORCUST = "Would you like to join as a\n1. Customer\n2. Seller";
    public static final String ENTERNAME = "Please enter your name";
    public static final String CHANGENAME = "What would you like to change your name to?";
    public static final String CHANGEEMAIL = "What would you like to change your email to?";
    public static final String CHANGEPASSWORD = "What would you like to change your password to?";
    public static final String CHANGED = "Changed!";
    public static final String SUREDELETE = "Are you sure you want to delete your account?";
    public static final String DELETING = "Deleting your account...";



    //seller
    public static final String SELLEROPTIONS = "1. Manage Stores\n2. View sales";
    public static final String STOREOPTION = "Which store would you like to access?";
    public static final String STORESPEC = "1. Create products\n2. Modify existing products";
    public static final String NEWOPTIONS = "Would you like to import csv file?";
    public static final String FILEIMPORT = "Please enter the name of file:";

    //customer
    public static final String MAINCUSTMENU = "Main Menu\n1. View/edit your account\n2. View marketplace\n3. Quit";
    public static final String CUSTACCOUNTCHOICES = "1. Edit your name\n2. Edit your email\n" +
            "3. Edit your password\n4. Delete your account\n5. Return to main menu";
    public static final String CUSTINFO = "Customer Info:";


    public String toMarket(ArrayList<Store> stores) {
        String marketString = "MARKETPLACE\nSelect which product you'd like to view!\n";
        int counter = 1;
        for (int i = 0; i < stores.size(); i++ ) {
            for (int j = 0; j < stores.get(i).getGoods().size(); j++) {
                marketString = marketString + counter + ". Store: " + stores.get(i).getName() +
                        ", " + stores.get(i).getGoods().get(j).toString() + "\n";
            }
        }
        // I did this really quickly -- it may be smarter to make it an array of strings to be printed

        return marketString;
    }
    public static boolean doesEmailExist(ArrayList<User> customersList, ArrayList<User> sellersList, String email) {
        boolean emailExists = false;
        for (int i = 0; i < sellersList.size(); i++) {
            if (email.equals(sellersList.get(i).getEmail())) {
                emailExists = true;
            }
        }
        for (int i = 0; i < customersList.size(); i++) {
            if (email.equals(customersList.get(i).getEmail())) {
                emailExists = true;
            }
        }
        return emailExists;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = -1; //scanner choice
        boolean invalidChoice = false; //the boolean I'll use for do-while loops to check invalid input
        boolean stayInMenu = true;
        boolean emailExists = false; //does an email already exist for this user
        boolean seller; //if true, user is a seller, if false, user is a customer


        ArrayList<User> customersList = new ArrayList<>();
        ArrayList<User> sellersList = new ArrayList<>();
        ArrayList<Store> storesList = new ArrayList<>(); //arrayList of stores in the marketplace
        ArrayList<Products> productsList = new ArrayList<>();

        User currentUser = null; //the current user of the program

        //TODO here call the method that parses through the files and gets all the info
        //Necessary arrays to have:
        // 1. arrayList of products
        //
        //for buyers and sellers and etc

        System.out.println(WELCOME);
        do {
            //this code is to test functionality without file IO
            customersList.add(new Customer("sofia@gmail.com", "sofia", "sofia"));
            customersList.add(new Customer("email2", "name2", "password2"));
            customersList.add(new Customer("email3", "name3", "password3"));
            sellersList.add(new Seller("email4", "name4", "password4"));
            sellersList.add(new Seller("email5", "name5", "password5"));

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
        boolean matches = false;
        if (choice == 1) { //sign in
            do {
                System.out.println(ENTERLOGIN);
                String email = scan.nextLine();
                System.out.println(ENTERPSWD);
                String password = scan.nextLine();
                for (int i = 0; i < customersList.size(); i++) {
                    if (email.equals(customersList.get(i).getEmail()) &&
                            password.equals(customersList.get(i).getPassword())) {
                        currentUser = customersList.get(i);
                        matches = true;
                    }
                }
                if (!matches) {
                    for (int i = 0; i < sellersList.size(); i++) {
                        if (email.equals(sellersList.get(i).getEmail()) &&
                                password.equals(sellersList.get(i).getPassword())) {
                            currentUser = sellersList.get(i);
                            matches = true;
                        }
                    }
                }


                if (matches) {
                    System.out.println("Connecting you to the market!");
                } else {
                    System.out.println(NOUSER);
                    do {
                        System.out.println(TRYAGAIN);
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
                    if (choice == 1) {
                        matches = false;
                    } else {
                        System.out.println(BYE);
                        return;
                    }
                }

            } while (!matches);


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
            if (choice == 1) { //user is a customer
                seller = false;
            } else {
                seller = true; //user is a seller
            }

            System.out.println(ENTERNAME);
            String name = scan.nextLine();
            System.out.println(ENTERLOGIN);
            String email = scan.nextLine();
            System.out.println(ENTERPSWD);
            String password = scan.nextLine();
            do {
                if (emailExists) {
                    System.out.println(ENTERLOGIN);
                    email = scan.nextLine();
                    emailExists = false;
                }

                emailExists = doesEmailExist(customersList, sellersList, email);
                if (emailExists) {
                    System.out.println(EMAILEXISTS);
                    do {
                        System.out.println("Would you like to enter a different email?");
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
                    if (choice == 2) {
                        System.out.println(BYE);
                        return;
                    }
                }
            } while (emailExists);

            if (!seller) { //customer
                currentUser = new Customer(email, name, password);
            } else { //seller
                currentUser = new Seller(email, name, password);
            }
        }
        //NOW CODE FOR RUNNING MARKETPLACE, ETC

        if (currentUser instanceof Customer) {
            do { //the loop that keeps the user going back to the main menu
                do {
                    System.out.println(MAINCUSTMENU);
                    try {
                        choice = Integer.parseInt(scan.nextLine());
                        if (choice != 1 && choice != 2 && choice != 3) {
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
                if (choice == 1) { //view/edit your account
                    do { //loop that keeps them in the view/edit account
                        do {
                            System.out.println(CUSTINFO);
                            System.out.println("Name: " + currentUser.getName() +
                                    "\nEmail: " + currentUser.getEmail() +
                                    "\nPassword: " + currentUser.getPassword());
                            System.out.println(CUSTACCOUNTCHOICES);
                            try {
                                choice = Integer.parseInt(scan.nextLine());
                                if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
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
                        switch (choice) {
                            case 1 -> { //edit your name
                                System.out.println(CHANGENAME);
                                String name = scan.nextLine();
                                currentUser.setName(name);
                                System.out.println(CHANGED);
                            }
                            case 2 -> { //edit your email
                                System.out.println(CHANGEEMAIL);
                                String email = scan.nextLine();
                                //TODO scan through and make sure email isn't duplicated
                                currentUser.setEmail(email);
                                System.out.println(CHANGED);
                            }
                            case 3 -> { //edit your password
                                System.out.println(CHANGEPASSWORD);
                                String password = scan.nextLine();
                                currentUser.setPassword(password);
                                System.out.println(CHANGED);
                            }
                            case 4 -> { //delete your account
                                do {
                                    System.out.println(SUREDELETE);
                                    System.out.println(YESNO);
                                    try {
                                        choice = Integer.parseInt(scan.nextLine());
                                        if (choice != 1 && choice != 2) {
                                            invalidChoice = true;
                                            System.out.println(ENTERVALID);
                                        }
                                    } catch (NumberFormatException e) {
                                        invalidChoice = true;
                                        System.out.println(ENTERVALID);
                                    }
                                } while (invalidChoice);
                                if (choice == 1) {
                                    currentUser = null;
                                } else {
                                    System.out.println("Ok!");
                                }
                            }
                            case 5 -> //go back to main menu
                                    stayInMenu = false;
                        }

                    } while (stayInMenu);
                    stayInMenu = true;

                } else if (choice == 2) {
                    //PRINT MARKETPLACE



                } else if (choice == 3) {
                    System.out.println(BYE);
                    return;
                }
            } while (stayInMenu);


        } else if (currentUser instanceof Seller) {

        } else {
            System.out.println("User was not initialized");
        }



    }




}
