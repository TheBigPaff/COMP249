/**
 * Name and ID: Patrick Deniso - 40194944
 * COMP249
 * Assignment 3
 * Due Date 25/03/2022
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Parent Exception of CSVAttributeMissing and CSVDataMissing
 */
public class CSVException extends Exception{
    String exceptionLogFileName = "Exceptions.log";

    public CSVException(){
        super("Error: Input row cannot be parsed due to missing information");
        AppendException();
    }
    public CSVException(String msg){
        super(msg);
    }

    /***
     * Appends exception to "Exceptions.log" file.
     */
    public void AppendException(){
        AppendException(super.getMessage(), exceptionLogFileName);
    }

    /***
     * Appends exception to the specified file.
     */
    public static void AppendException(String msg, String exceptionLogFileName){
        try{
            PrintWriter writer = new PrintWriter(new FileOutputStream(exceptionLogFileName, true));
            writer.println(msg);
            writer.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
