import java.sql.SQLOutput;
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = -1; //scanner choice
        boolean invalidChoice = false; //the boolean I'll use for do-while loops to check invalid input
        boolean stayInMenu = true;
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
            do { //the loop that keeps the user going back to the main menu
                do {
                    System.out.println(MAINCUSTMENU);
                    try {
                        choice = Integer.parseInt(scan.nextLine());
                        if (choice != 1 && choice != 2 && choice != 3) {
                            invalidChoice = true;
                            System.out.println(ENTERVALID);
                        }
                    } catch (NumberFormatException e) {
                        invalidChoice = true;
                        System.out.println(ENTERVALID);
                    }
                } while (invalidChoice);
                if (choice == 1) { //view/edit your account
                    do { //loop that keeps them in the view/edit account
                        System.out.println(CUSTINFO);
                        System.out.println("Name: " + currentUser.getName() +
                                "\nEmail: " + currentUser.getEmail() +
                                "\nPassword: " + currentUser.getPassword());
                        System.out.println(CUSTACCOUNTCHOICES);
                        do {
                            try {
                                choice = Integer.parseInt(scan.nextLine());
                                if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
                                    invalidChoice = true;
                                    System.out.println(ENTERVALID);
                                }
                            } catch (NumberFormatException e) {
                                invalidChoice = true;
                                System.out.println(ENTERVALID);
                            }
                        } while (invalidChoice);
                        switch (choice) {
                            case 1: //edit your name
                                System.out.println(CHANGENAME);
                                String name = scan.nextLine();
                                currentUser.setName(name);
                                System.out.println(CHANGED);
                                break;

                            case 2: //edit your email
                                System.out.println(CHANGEEMAIL);
                                String email = scan.nextLine();
                                //TODO scan through and make sure email isn't duplicated
                                currentUser.setEmail(email);
                                System.out.println(CHANGED);
                                break;

                            case 3: //edit your password
                                System.out.println(CHANGEPASSWORD);
                                String password = scan.nextLine();
                                currentUser.setPassword(password);
                                System.out.println(CHANGED);
                                break;

                            case 4: //delete your account
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

                                break;

                            case 5: //go back to main menu
                                stayInMenu = false;
                                break;
                        }

                    } while (stayInMenu);
                    stayInMenu = true;

                } else if (choice == 2) {
                    //MARKETPLACE


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
