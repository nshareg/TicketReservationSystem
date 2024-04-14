package exception;

public class InvalidUserCredentials extends Exception {
    public InvalidUserCredentials(){
        System.out.println("Corrupted user credentials");
    }
}
