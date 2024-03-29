package userInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInputMain {

    public static void userInputStart() {
        // standard();

        // bufferedReader_older_method();

        scanner_newer_method();
    }

    private static void standard() {
        try {
            System.out.println("Enter a number:");
            int input = System.in.read();   // gets ascii value
            System.out.println(input - 48);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void bufferedReader_older_method() {
        // bufferedReader can also be used to get files, by using different reader in the bufferedReader constructor

        System.out.println("Enter characters:");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));) {
            String line = bufferedReader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void scanner_newer_method() {
        Scanner scanner = new Scanner(System.in);

        // String name;
        // int age;
        // float shoeSize;
        //
        // System.out.println("What is your name:");
        // name = scanner.nextLine();
        //
        // System.out.println("What is your age:");
        // age = scanner.nextInt();
        //
        // System.out.println("What is your shoeSize (separated with comma if decimals:");
        // shoeSize = scanner.nextFloat();
        //
        // System.out.println("name: " + name + "age: " +  age + "shoe size: " + shoeSize);


        // put in float and convert in do while
        boolean validFloatAge = false;
        System.out.println("Please enter a correct float");

        do {
            String line = scanner.nextLine();
            try {
                float floatStuff = Float.parseFloat(line);
                System.out.println("Float is: " + floatStuff);
                validFloatAge = true;
            } catch (NumberFormatException nfe) {
                System.out.println("put in a real float:");
            }
        } while (!validFloatAge);

        scanner.close();

        ArrayList<String> list = new ArrayList<>();
        int[] result;


    }

}
