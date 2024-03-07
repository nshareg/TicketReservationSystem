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
        if(FileInteract.getLength(getUsername(),DB_NAME) <= 3) FileInteract.setNewPart(getUsername(), balance, DB_NAME);
        else FileInteract.changePart(getUsername(), balance, 3, DB_NAME);
    }
    public String getBalance(){
        return FileInteract.getCred(getUsername(), 3, DB_NAME);
    }
}
