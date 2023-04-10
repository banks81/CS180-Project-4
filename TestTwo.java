import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.MethodSorters;

import java.io.*;

import static org.junit.Assert.*;
public class TestTwo {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Test ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)

    public static class TestCase {
        private final PrintStream originalOutput = System.out;
        private final InputStream originalSysin = System.in;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayInputStream testIn;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayOutputStream testOut;

        @Before
        public void outputStart() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
        }

        @After
        public void restoreInputAndOutput() {
            System.setIn(originalSysin);
            System.setOut(originalOutput);
        }

        private String getOutput() {
            return testOut.toString();
        }

        @SuppressWarnings("SameParameterValue")
        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        }

        @Test(timeout = 1000)
        public void testB() {
            try {
                // Set the input
                // Separate each input with a newline (\n).
                String input = "1\nemail1\npassword1\n2\n1\n1\n1\n3\n2\n2\n4\n5\n6\n2\n3\n6\n1\n8\n";

                // Pair the input with the expected result
                String expected = "Welcome to the CS 180 Farmer's Market!\nAre you an existing user?\n" +
                        "1. Yes\n2. No\nPlease enter your email address.\nPlease enter your password.\n" +
                        "Connecting you to the farmer's market!\nMain Menu\n1. View/edit your account\n" +
                        "2. View farmer's market\n3. Quit\n~*~ Farmer's Market Main Menu ~*~\n" +
                        "1. View overall farmer's market listings\n" +
                        "2. Search for specific products\n" +
                        "3. Sort the products by price, lowest to highest\n" +
                        "4. Sort the products by quantity available, lowest to highest\n" +
                        "5. View your purchase history\n" +
                        "6. View your shopping cart\n" +
                        "7. Go back to main menu\n" +
                        "8. Quit\nSelect which product you'd like to view!\n" +
                        "1. Product Name: cartItem1, Store name: store1\n" +
                        "              Product Description: test1\n" +
                        "              Quantity Available: 80, Price: 12.0\n" +
                        "2. Product Name: cartItem2, Store name: store1\n" +
                        "              Product Description: test2\n" +
                        "              Quantity Available: 0, Price: 30.0\n" +
                        "3. Product Name: cartItem3, Store name: store3\n" +
                        "              Product Description: test3\n" +
                        "              Quantity Available: 100, Price: 190.99\n" +
                        "4. Go back to market menu\n" +
                        "5. Quit\nProduct Name: cartItem1, Store name: store1\n" +
                        "              Product Description: test1\n" +
                        "              Quantity Available: 80, Price: 12.0\n" +
                        "Would you like to...\n" +
                        "1. Add one to cart\n" +
                        "2. Purchase now\n" +
                        "3. Go back to products list\nAdded to shopping cart!\n" +
                        "Returning to product listings...\n" +
                        "Select which product you'd like to view!\n" +
                        "1. Product Name: cartItem1, Store name: store1\n" +
                        "              Product Description: test1\n" +
                        "              Quantity Available: 80, Price: 12.0\n" +
                        "2. Product Name: cartItem2, Store name: store1\n" +
                        "              Product Description: test2\n" +
                        "              Quantity Available: 0, Price: 30.0\n" +
                        "3. Product Name: cartItem3, Store name: store3\n" +
                        "              Product Description: test3\n" +
                        "              Quantity Available: 100, Price: 190.99\n" +
                        "4. Go back to market menu\n" +
                        "5. Quit\nProduct Name: cartItem3, Store name: store3\n" +
                        "              Product Description: test3\n" +
                        "              Quantity Available: 100, Price: 190.99\n" +
                        "Would you like to...\n" +
                        "1. Add one to cart\n" +
                        "2. Purchase now\n" +
                        "3. Go back to products list\nHow many would you like to purchase?\nPurchasing 2...\n" +
                        "Select which product you'd like to view!\n" +
                        "1. Product Name: cartItem1, Store name: store1\n" +
                        "              Product Description: test1\n" +
                        "              Quantity Available: 80, Price: 12.0\n" +
                        "2. Product Name: cartItem2, Store name: store1\n" +
                        "              Product Description: test2\n" +
                        "              Quantity Available: 0, Price: 30.0\n" +
                        "3. Product Name: cartItem3, Store name: store3\n" +
                        "              Product Description: test3\n" +
                        "              Quantity Available: 98, Price: 190.99\n" +
                        "4. Go back to market menu\n" +
                        "5. Quit\n~*~ Farmer's Market Main Menu ~*~\n" +
                        "1. View overall farmer's market listings\n" +
                        "2. Search for specific products\n" +
                        "3. Sort the products by price, lowest to highest\n" +
                        "4. Sort the products by quantity available, lowest to highest\n" +
                        "5. View your purchase history\n" +
                        "6. View your shopping cart\n" +
                        "7. Go back to main menu\n" +
                        "8. Quit\nPrevious purchases:\n" +
                        "1. pastItem1\n" +
                        "2. pastItem2\n" +
                        "3. pastItem3\n" +
                        "4. cartItem3\n" +
                        "~*~ Farmer's Market Main Menu ~*~\n" +
                        "1. View overall farmer's market listings\n" +
                        "2. Search for specific products\n" +
                        "3. Sort the products by price, lowest to highest\n" +
                        "4. Sort the products by quantity available, lowest to highest\n" +
                        "5. View your purchase history\n" +
                        "6. View your shopping cart\n" +
                        "7. Go back to main menu\n" +
                        "8. Quit\nShopping cart:\n" +
                        "1. cartItem1, test1\n" +
                        "    Price: 12.0\n" +
                        "2. cartItem3, test3\n" +
                        "    Price: 190.99\n" +
                        "3. cartItem1, test1\n" +
                        "    Price: 12.0\n" +
                        "What would you like to do?\n" +
                        "1. Purchase cart\n" +
                        "2. Remove an item\n" +
                        "3. Return to Market Menu\nWhich item would you like to remove?\n~*~ Farmer's Market Main Menu ~*~\n" +
                        "1. View overall farmer's market listings\n" +
                        "2. Search for specific products\n" +
                        "3. Sort the products by price, lowest to highest\n" +
                        "4. Sort the products by quantity available, lowest to highest\n" +
                        "5. View your purchase history\n" +
                        "6. View your shopping cart\n" +
                        "7. Go back to main menu\n" +
                        "8. Quit\nShopping cart:\n" +
                        "1. cartItem3, test3\n" +
                        "    Price: 190.99\n" +
                        "What would you like to do?\n" +
                        "1. Purchase cart\n" +
                        "2. Remove an item\n" +
                        "3. Return to Market Menu\n~*~ Farmer's Market Main Menu ~*~\n" +
                        "1. View overall farmer's market listings\n" +
                        "2. Search for specific products\n" +
                        "3. Sort the products by price, lowest to highest\n" +
                        "4. Sort the products by quantity available, lowest to highest\n" +
                        "5. View your purchase history\n" +
                        "6. View your shopping cart\n" +
                        "7. Go back to main menu\n" +
                        "8. Quit\nSorry to see you go! Happy trails!";

                // Runs the program with the input values
                // Replace TestProgram with the name of the class with the main method
                receiveInput(input);
                Market.main(new String[0]);

                // Retrieves the output from the program
                String stuOut = getOutput();

                // Trims the output and verifies it is correct.
                stuOut = stuOut.replace("\r\n", "\n");
                assertEquals("Error! Output does not match",
                        expected.trim(), stuOut.trim());
            } catch (Exception e) {
                e.printStackTrace();
                fail();
            }


        }
    }
}

