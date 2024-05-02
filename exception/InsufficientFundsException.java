package exception;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(){
        super("Not enough funds");
    }
    public InsufficientFundsException(String string){
        super(string);
    }
}
