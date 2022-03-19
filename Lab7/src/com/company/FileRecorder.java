package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileRecorder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a file name: ");
        String fileName = scanner.nextLine();

        PrintWriter pw = null;
        try
        {
            // if file doesn't exist it will be created
            pw = new PrintWriter(new FileOutputStream(fileName, true));
        } catch (FileNotFoundException e)
        {
            System.out.println("Error opening " + fileName);
            System.exit(0);
        }
        writeToFile(pw, scanner);
        pw.close();


        Scanner fileScanner = null;
        try{
            fileScanner = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e){
            System.out.println("Error opening " + fileName);
            System.exit(0);
        }
        readFromFile(fileScanner);
        fileScanner.close();


        scanner.close();
    }

    public static void writeToFile(PrintWriter pw, Scanner keyboardScanner){
        System.out.print("Enter university name: ");
        String name = keyboardScanner.nextLine();

        int studentsCount = 0;
        boolean validInput = false;
        while(!validInput) {
            try {
                System.out.print("Enter the number of students: ");
                studentsCount = keyboardScanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again.");
            }
            finally{
                keyboardScanner.nextLine(); // trailing newline from nextInt()
            }
        }

        System.out.print("Enter the city: ");
        String city = keyboardScanner.nextLine();
        System.out.print("Enter the country: ");
        String country = keyboardScanner.nextLine();

        pw.printf("%s in %s, %s: %d students\n", name, city, country, studentsCount);
    }

    public static void readFromFile(Scanner fileScanner){
        while(fileScanner.hasNextLine()){
            System.out.println(fileScanner.nextLine());
        }
    }
}