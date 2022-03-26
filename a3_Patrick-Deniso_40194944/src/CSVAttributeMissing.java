/**
 * Name and ID: Patrick Deniso - 40194944
 * COMP249
 * Assignment 3
 * Due Date 25/03/2022
 */

/**
 * Exception for when an attribute is missing in the CSV file to read from.
 */
public class CSVAttributeMissing extends CSVException{
    String fileName;

    public CSVAttributeMissing(){
        super();
    }

    /**
     * @param msg message of the exception
     * @param fileName CSV filename. needed to delete that file whenever the exception is called
     */
    public CSVAttributeMissing(String msg, String fileName){
        super(msg);
        this.fileName = fileName;
    }


}
