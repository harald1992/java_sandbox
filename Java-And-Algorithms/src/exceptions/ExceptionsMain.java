package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsMain {

    public static void exceptionsStart() {
        baseExceptions();
        checkedVsUncheckedExceptions();
    }

    private static void baseExceptions() {
        try {
            int myInt = Integer.parseInt("pants");
        } catch (NumberFormatException nfe) {
            System.out.println("Caught numberFormatException");
        } catch (Exception e) {
            System.out.println("Exception");
        }

        System.out.println("The code continues and is not terminated, because the exception was caught.\n");

        /*  Exception Hierarchy
        Object -> Throwable -> Exception -> RuntimeException -> IllegalArgumentException -> NumberFormatException
        This hierarchy also needs to align with the order that you catch exceptions, so first catch the most specific exception
        (NumberFormatException), and only below that catch Exception
        */

        /*
        Call stack:
        A thrown exception goes up the call stack until it is caught by a catch statement.
         */

        // Catch MultiCatch statement and finally statement:
        try {
            int myInt = Integer.parseInt("pants");
            System.out.println("This is not executed because the myInt already fails");
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Caught numberFormatException or nullPointerException");
        } finally {
            System.out.println(
                    "Perform this finally block always, regardless of there being an exception or not. Even executes if you have return; in the try" +
                            " block.");
            // finally is handy for example when closing connection when doing filestream or database stuff.
        }
    }

    private static void checkedVsUncheckedExceptions() {
        /*
        Checked exception: Compilation is blocked if there is an checked exception that is not handled, for example FileNotFoundException, IOException, SQLException. These are not the runtimExceptions.
        UnChecked exception:  can still do compilation. These are all the RuntimeExceptions, like NullPointerException or IndexOutOfBoundsException
         */
        int readFile = readFile("notExisting.txt");
        System.out.println(readFile);
        int readFile2 = readFile("myFile.txt");
        System.out.println(readFile2);

    }

    private static int readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            return fileReader.read();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found.");
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }


    }

}
