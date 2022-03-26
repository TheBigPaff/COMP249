/**
 * Name and ID: Patrick Deniso - 40194944
 * COMP249
 * Assignment 3
 * Due Date 25/03/2022
 */

/**
 * Exception for when a data value is missing in the CSV file to read from.
 */
public class CSVDataMissing extends CSVException{
    public CSVDataMissing(){
        super();
    }
    public CSVDataMissing(String msg){
        super(msg);
    }
}
