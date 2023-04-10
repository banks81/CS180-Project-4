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
public class TestThree {
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
        public void testC() {
            try {
                // Set the input
                // Separate each input with a newline (\n).
                String input = "Two\n2\nTwo\n2\nTestName2\nTestEmail2\nTestPassword2\nThree\n2\n2\nbooth1\n1\n1\n3\nname1\n" +
                        "description1\n90\n100\n7\nproduct.csv\n8\n5\n3\n";

                // Pair the input with the expected result
                String expected = "Welcome to the CS 180 Farmer's Market!\nAre you an existing user?\n" +
                        "1. Yes\n2. No\nPlease enter a valid option!\nAre you an existing user?\n" +
                        "1. Yes\n2. No\nWould you like to join as a\n1. Customer\n2. Farmer\nPlease enter a valid option!\n" +
                        "Would you like to join as a\n1. Customer\n2. Farmer\nPlease enter your name\n" +
                        "Please enter your email address.\nPlease enter your password.\nMain Menu\n1. View/edit your account\n" +
                        "2. View farmer's market\n3. Quit\nPlease enter a valid option!\n" +
                        "Main Menu\n1. View/edit your account\n2. View farmer's market\n3. Quit\n1. View booths\n" +
                        "2. Add booth\n" +
                        "3. Edit booth\n" +
                        "4. Remove booth\n" +
                        "5. Go back\nEnter the name of the booth: \n1. View booths\n" +
                        "2. Add booth\n" +
                        "3. Edit booth\n" +
                        "4. Remove booth\n" +
                        "5. Go back\nWhich booth would you like to view?\n" +
                        "1. booth1\nBooth: booth1\n" +
                        "1. View products\n" +
                        "2. View sales\n" +
                        "3. Add product\n" +
                        "4. Edit product\n" +
                        "5. Remove product\n" +
                        "6. Import product csv file\n" +
                        "7. Export product csv file\n" +
                        "8. Go back\nEnter the name of the product: \n" +
                        "Enter the description of the product: \nEnter the price of the product: " +
                        "\nEnter the quantity of the product: \nProduct successfully added!\n" +
                        "Booth: booth1\n" +
                        "1. View products\n" +
                        "2. View sales\n" +
                        "3. Add product\n" +
                        "4. Edit product\n" +
                        "5. Remove product\n" +
                        "6. Import product csv file\n" +
                        "7. Export product csv file\n" +
                        "8. Go back\nEnter the name of the file: \nBooth: booth1\n" +
                        "1. View products\n" +
                        "2. View sales\n" +
                        "3. Add product\n" +
                        "4. Edit product\n" +
                        "5. Remove product\n" +
                        "6. Import product csv file\n" +
                        "7. Export product csv file\n" +
                        "8. Go back\n1. View booths\n" +
                        "2. Add booth\n" +
                        "3. Edit booth\n" +
                        "4. Remove booth\n" +
                        "5. Go back\nMain Menu\n" +
                        "1. View/edit your account\n" +
                        "2. View farmer's market\n" +
                        "3. Quit\nSorry to see you go! Happy trails!";

                // Runs the program with the input values
                // Replace TestProgram with the name of the class with the main method
                receiveInput(input);
                Market.main(new String[0]);

                // Retrieves the output from the program
                String stuOut = getOutput();

                // Trims the output and verifies it is correct.
                stuOut = stuOut.replace("\r\n", "\n");
                assertEquals("Error! Output does not match expected",
                        expected.trim(), stuOut.trim());
            } catch (Exception e) {
                e.printStackTrace();
                fail();
            }
        }



    }
}

