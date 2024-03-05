public class User extends SuperUser{
    private int balance;
    public User(String name, String surname, int balance){
        setName(name);
        setSurname(surname);
        setBalance(balance);
    }
    public User(String name, String surname, String username){
        setName(name);
        setSurname(surname);
        setUsername(username);
    }
    public User(String username){
        setUsername(username);
    }
    public User(String username, int balance){
        setUsername(username);
        setBalance(balance);
    }
    public void setBalance(int balance){
        if(balance >= 0) this.balance = balance;
        else System.out.println("Please enter valid number");
    }
    public int getBalance(){
        return this.balance;
    }
}
