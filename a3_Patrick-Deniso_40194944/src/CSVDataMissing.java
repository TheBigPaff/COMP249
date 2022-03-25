public class CSVDataMissing extends CSVException{
    public CSVDataMissing(){
        super();
    }
    public CSVDataMissing(String fileName, String msg){
        super(fileName, msg);
    }
}
