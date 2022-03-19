import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fileName = "covidStatistics.xlsx";
        try{
            FileInputStream stream = new FileInputStream(fileName);
            Scanner fileScanner = new Scanner(stream);

            String htmlFileName = fileName.split("\\.")[0] + ".html";
            PrintWriter writer = new PrintWriter(new FileOutputStream(fileName));
            CSV2HTML(fileScanner, writer);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    /***
     * The method will create an HTML file containing a table with the data from the CSV file.
     * @param file Scanner to the CSV file.
     * @param writer PrintWriter to the HTML file.
     */
    public static void CSV2HTML(Scanner file, PrintWriter writer){
        /* THIS IS NOT THE MOST GENERAL IMPLEMENTATION BECAUSE:
        * "In your design you may assume the following about the input CSV files:
            a. There are at least three lines in a CSV file.
            b. The first line represents the Title of the table.
            c. The second line contains exactly four attributes, whose names may vary depending on the CSV file.
            d. The third and possibly the following lines, if any, each represent the actual data records.
            e. The last line may represent a note line if it begins with the text “Note:” in its first data field."
        */

        String titleLine = file.nextLine().split(",")[0];
        String[] attributes = file.nextLine().split(",");
        while(file.hasNextLine()){
            String[] data = file.nextLine().split(",");
            // check if it's the last line
            if(!file.hasNextLine()){
                // then it's the last line

            }
        }

    }
}
