public class User extends SuperUser{
    private String balance;
    public User(String username, String password){
        setCreds(username, password);
        setBalance("0");
    }
    public User(String username, String password, String balance){
        setCreds(username, password);
        setBalance(balance);
    }
    public void setBalance(String balance){
        if(FileInteract.getLength(this.getUsername(),DB_NAME) <= 3 & !balance.equals(FileInteract.getCred(getUsername(), 3, DB_NAME))){
            FileInteract.setNewPart(getUsername(), balance, DB_NAME);
        }
        this.balance = balance;
    }
    public String getBalance(){
        return this.balance;
    }
}
