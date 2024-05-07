package exception;

public class InvalidDatabaseException extends Exception{
    public InvalidDatabaseException(){
        super("InvalidDatabaseException");
    }
    public InvalidDatabaseException(String line){
        super(line);
    }
}
