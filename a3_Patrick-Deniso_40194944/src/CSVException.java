import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class CSVException extends Exception{
    String exceptionLogFileName = "Exceptions.log";

    public CSVException(){
        super("Error: Input row cannot be parsed due to missing information");
    }
    public CSVException(String fileName, String msg){
        super("ERROR: In file " + fileName + ". " + msg + " File is not converted to HTML.");
        AppendException();
    }

    /***
     * Appends exception to "Exceptions.log" file and deleted the newly created HTML file.
     */
    public void AppendException(){
        try{
            PrintWriter writer = new PrintWriter(new FileOutputStream(exceptionLogFileName, true));
            writer.println(super.getMessage());
            writer.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
