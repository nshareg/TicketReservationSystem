package exception;

public class InvalidUserCredentials extends Exception {
    public InvalidUserCredentials(){
        super("Corrupted user credentials");
    }
    public InvalidUserCredentials(String line){
        super(line);
    }
}
