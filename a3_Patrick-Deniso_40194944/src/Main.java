import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello! Welcome to the CSV2HTML converter software");
        while(true){
            System.out.print("Enter a filename (with .txt or .csv or extension): ");
            String fileName = input.next();
            fileHandling(fileName);

            System.out.print("Do you want to convert another file? Y/N: ");
            String answer = input.next();
            if(!answer.equalsIgnoreCase("y")) break;
        }
        input.close();
    }

    private static void fileHandling(String fileName) {
        try{
            File file = new File(fileName);
            if(!file.exists()) {
                System.out.println("Could not open input file "+fileName+" for reading.\n" +
                        "Please check that the file exists and is readable. This program will terminate after closing any opened files.");
            }
            Scanner fileScanner = new Scanner(file);

            String htmlFileName = fileName.split("\\.")[0] + ".html";
            if(verifyCSVFile(fileScanner, fileName)){
                // we have to reset the scanner
                fileScanner = new Scanner(file);

                PrintWriter writer = new PrintWriter(new FileOutputStream(htmlFileName));
                CSV2HTML(fileScanner, writer);
                System.out.println("File converted to HTML successfully!");
                writer.close();
            }

            fileScanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    /***
     * Validates the CSV file. If there are any missing attribute or data value, it will append call AppendExceptions() and then return false.
     * @param fileName The name of the CSV file.
     * @return true if the file was converted successfully, otherwise false.
     */
    public static boolean verifyCSVFile(Scanner scanner, String fileName){
        try{
            scanner.nextLine(); // ignore title
            String[] attributes = scanner.nextLine().split(",");

            // this condition is needed because when the last attribute is missing, split() will only return the 3 first attributes
            if(attributes.length != 4) {
                throw new CSVAttributeMissing(fileName, "Missing attribute.");
            }
            for (String attribute : attributes) {
                if(attribute.trim().isEmpty()){
                    throw new CSVAttributeMissing(fileName, "Missing attribute.");
                }
            }

            int counter = 3; // data always start from line 3 (line 1 is title and line 2 is headers)
            while(scanner.hasNextLine()){
                String[] data = scanner.nextLine().split(",");

                // check if it's NOT the last line
                if(scanner.hasNextLine()){
                    // this condition is needed because when the last attribute is missing, split() will only return the 3 first attributes
                    if(data.length != 4) {
                        throw new CSVDataMissing(fileName, "Missing data on line " + counter + ".");
                    }

                    for (String attribute : data) {
                        if(attribute.trim().isEmpty()){
                            throw new CSVDataMissing(fileName, "Missing data on line " + counter + ".");
                        }
                    }
                }

                counter++;
            }

            return true;
        } catch (CSVException csvException) {
            System.out.println(csvException.getMessage());
            return false;
        }
    }
    /***
     * The method will create an HTML file containing a table with the data from the CSV file.
     * @param scanner Scanner to the CSV file.
     * @param pw PrintWriter to the HTML file.
     */
    public static void CSV2HTML(Scanner scanner, PrintWriter pw){
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

        String titleLine = scanner.nextLine().split(",")[0];
        pw.write("<caption>"+titleLine+"</caption>\n");
        String[] attributes = scanner.nextLine().split(",");
        pw.write("<tr>\n");
        for (String attribute : attributes) {
            pw.write("\t<td>" + attribute + "</td>\n");
        }
        pw.write("</tr>\n");

        while(scanner.hasNextLine()){
            String[] data = scanner.nextLine().split(",");
            // check if it's the last line
            if(!scanner.hasNextLine()){
                // then it's the last line
                pw.write("</table>\n");
                pw.write("<span>"+data[0]+"</span>\n");
            }
            else{
                pw.write("<tr>\n");
                for (String attribute : data) {
                    pw.write("\t<td>" + attribute + "</td>\n");
                }
                pw.write("</tr>\n");
            }
        }


        // close initial tags
        pw.write("</table>\n</body>\n</html>\n");
    }


}
