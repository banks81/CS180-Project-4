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

public class TestOne {
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
        public void testA() {
            try {
                // Set the input
                // Separate each input with a newline (\n).
                String input = "2\n1\nTestName1\nTestEmail1\nTestPassword1\n3\n";

                // Pair the input with the expected result
                String expected = "Welcome to the CS 180 Farmer's Market!\nAre you an existing user?\n" +
                        "1. Yes\n2. No\nWould you like to join as a\n1. Customer\n2. Farmer\nPlease enter your name\n" +
                        "Please enter your email address.\nPlease enter your password.\nMain Menu\n1. View/edit your account\n" +
                        "2. View farmer's market\n3. Quit\nSorry to see you go! Happy trails!";

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

