import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fileName = "doctorList.txt";
        try{
            File file = new File(fileName);
            if(!file.exists()) return;

            Scanner fileScanner = new Scanner(file);

            String htmlFileName = fileName.split("\\.")[0] + ".html";
            PrintWriter writer = new PrintWriter(new FileOutputStream(htmlFileName));
            CSV2HTML(fileScanner, writer);

            fileScanner.close();
            writer.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
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
        pw.write("""
                <head>
                <style>
                table {font-family: arial, sans-serif;border-collapse: collapse;}
                td, th {border: 1px solid #000000;text-align: left;padding: 8px;}
                tr:nth-child(even) {background-color: #dddddd;}
                span{font-size: small}
                </style>
                </head>
                """);
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
