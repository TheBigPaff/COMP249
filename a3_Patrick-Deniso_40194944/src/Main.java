/**
 * Name and ID: Patrick Deniso - 40194944
 * COMP249
 * Assignment 3
 * Due Date 25/03/2022
 */
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final String SEP = ",";

    /**
     * MAIN METHOD.
     * This method does all the file handling, exception handling & user interaction.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello! Welcome to the CSV2HTML converter software");

        int size;
        while(true){
            System.out.print("How many CSV files do you want to open? >>> ");
            try{
                size = input.nextInt();
                break;
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }

        String[] fileNames = new String[size];
        for (int i = 0; i < fileNames.length; i++) {
            System.out.print("Enter a filename (with .txt or .csv or extension): ");
            fileNames[i] = input.next();

            // as requested in the assignment, check if any of the files given exists, if it doesn't, terminate program.
            File file = new File(fileNames[i]);
            if(!file.exists()){
                String message = "Could not open input file "+fileNames[i]+" for reading.\n" +
                        "Please check that the file exists and is readable. This program will terminate after closing any opened files.";
                CSVException.AppendException(message, "Exceptions.log");
                System.out.println(message);
                return; // terminate program
            }
        }

        // FINALLY, NOW OPEN PRINTWRITER AND CREATE HTML FILES
        for (int i = 0; i < fileNames.length; i++) {
            File file = new File(fileNames[i]);

            Scanner fileScanner = null;
            PrintWriter writer = null;
            try{
                fileScanner = new Scanner(file);
                // create html file with new filename
                writer = new PrintWriter(new FileOutputStream(fileNames[i].split("\\.")[0] + ".html"));

                ConvertCSVtoHTML(fileScanner, writer, fileNames[i]);

                System.out.println(fileNames[i] + " converted to HTML successfully!");
            }
            catch(FileNotFoundException e){
                // DELETE ANY CREATED FILES!!!
                for(int j = 0; j <= i; j++){
                    File f = new File(fileNames[j].split("\\.")[0] + ".html");
                    // wait for f to be created (there could be a delay)
                    while(!f.exists()){}
                    f.delete();
                }
                System.out.println(e.getMessage() + "\nAll other opened files were deleted.");
            }
            catch (CSVAttributeMissing e) {
                e.AppendException();
                System.out.println(e.getMessage());

                // delete this file
                File f = new File(e.fileName.split("\\.")[0] + ".html");
                // wait for f to be created (there could be a delay)
                while(!f.exists()){}
                f.delete();
            }
            finally{
                if(fileScanner != null) fileScanner.close();
                if(writer != null) writer.close();
            }
        }

        System.out.println("Files conversion finished.");

        // PRINT AN HTML FILE
        int counter = 0;
        while(counter < 2){
            System.out.print("Do you want to see an HTML file? If yes, enter filename, otherwise, enter \"no\": ");
            String answer = input.next();

            try{
                BufferedReader reader = new BufferedReader(new FileReader(answer));
                String line = reader.readLine();
                while(line != null){
                    System.out.println(line);
                    line = reader.readLine();
                }
            }
            catch (FileNotFoundException e) {
                counter++;
                if(counter < 2) System.out.println("File doesn't exist. You have a second and final chance.");
                else System.out.println("File doesn't exist. You wasted your second chance. Terminating program.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        input.close();
    }

    /***
     * The method will create an HTML file containing a table with the data from the CSV file.
     * @param scanner Scanner to the CSV file.
     * @param pw PrintWriter to the HTML file.
     * @param fileName the CSV filename.
     */
    public static void ConvertCSVtoHTML(Scanner scanner, PrintWriter pw, String fileName) throws CSVAttributeMissing {
        /* THIS IS NOT THE MOST GENERAL IMPLEMENTATION BECAUSE:
        * "In your design you may assume the following about the input CSV files:
            a. There are at least three lines in a CSV file.
            b. The first line represents the Title of the table.
            c. The second line contains exactly four attributes, whose names may vary depending on the CSV file.
            d. The third and possibly the following lines, if any, each represent the actual data records.
            e. The last line may represent a note line if it begins with the text “Note:” in its first data field."
        */

        // write boilerplate html
        pw.write("<!DOCTYPE html>\n<html>\n");
        pw.write("<head><style>table {font-family: arial, sans-serif;border-collapse: collapse;}td, th {border: 1px solid #000000;text-align: left;padding: 8px;} tr:nth-child(even) {background-color: #dddddd;}span{font-size: small}</style></head>");
        pw.write("\n<body>\n<table>\n");

        String titleLine = scanner.nextLine().split(SEP)[0];
        pw.write("<caption>"+titleLine+"</caption>\n");
        String attributeLine = scanner.nextLine();
        String[] attributes = attributeLine.split(SEP);
        pw.write("<tr>\n");


        // check if last attribute is empty (last char is a comma)
        if(attributeLine.trim().charAt(attributeLine.length()-1) == SEP.toCharArray()[0]) {
            String msg = "ERROR: In file " + fileName + ". Missing attribute. File is not converted to HTML";
            pw.close(); // CLOSE PRINTWRITER SINCE YOU'LL BE DELETING THIS FILE ANYWAY
            throw new CSVAttributeMissing(msg, fileName);
        }
        for (String attribute : attributes) {
            if(attribute.trim().isEmpty()){
                String msg = "ERROR: In file " + fileName + ". Missing attribute. File is not converted to HTML";
                pw.close(); // CLOSE PRINTWRITER SINCE YOU'LL BE DELETING THIS FILE ANYWAY
                throw new CSVAttributeMissing(msg, fileName);
            }
            pw.write("\t<td>" + attribute + "</td>\n");
        }
        pw.write("</tr>\n");

        int counter = 3; // data always start from line 3 (line 1 is title and line 2 is headers)
        while(scanner.hasNextLine()){
            String dataLine = scanner.nextLine();
            String[] data = dataLine.split(SEP);

            // check if it's the last line
            if(!scanner.hasNextLine()){
                // then it's the last line
                pw.write("</table>\n");
                pw.write("<span>"+data[0]+"</span>\n");
            }
            else{
                try{
                    // check if last attribute is empty (last char is a comma)
                    if(dataLine.trim().charAt(dataLine.length()-1) == SEP.toCharArray()[0]) {
                        String msg = "WARNING: In file " + fileName + " line " + counter + " is not converted to HTML: missing data: " + attributes[attributes.length-1];
                        throw new CSVDataMissing(msg);
                    }

                    for (int i = 0; i < data.length; i++) {
                        if(data[i].trim().isEmpty()){
                            String msg = "WARNING: In file " + fileName + " line " + counter + " is not converted to HTML: missing data: " + attributes[i];
                            throw new CSVDataMissing(msg);
                        }
                    }
                }
                catch (CSVDataMissing e){
                    e.AppendException();
                    System.out.println(e.getMessage());

                    continue; // skip this row, continue with conversion
                }

                pw.write("<tr>\n");
                for (String attribute : data) {
                    pw.write("\t<td>" + attribute + "</td>\n");
                }
                pw.write("</tr>\n");
            }
            counter++;
        }


        // close initial tags
        pw.write("</table>\n</body>\n</html>\n");
    }
}
