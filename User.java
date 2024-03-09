public class User extends SuperUser{
    private String balance;
    private final int BALANCE_POSITION = 3;//position indicator for balance
    public User(String username, String password){
        setCreds(username, password);//call of parent class method to set username and password
        setRole("user");//sets role user in any case
        setBalance("");//since we need to initialize the balance in any case, we call the method with empty string
    }
    public User(String username, String password, String balance){
        setCreds(username, password);//sets username and password
        setRole("user");//sets role user in any case
        setBalance(balance);//sets balance to the value we got
    }

    public void setBalance(String balance) {
        boolean state = balance.isEmpty();//check if obtained String is empty
        if(FileInteract.getLength(getUsername(),DB_NAME) < 4){//if spot for balance is empty
            FileInteract.setNewPart(getUsername(), state ? "0" : balance, DB_NAME);//depending on if obtained string is empty or not, we set 0 or the balance value
        }
        else {//if we already have value in our BALANCE_POSITION
            if(!state){//if obtained string is non-empty we set new value on that place
                FileInteract.changePart(getUsername(), balance, BALANCE_POSITION, DB_NAME);
            }
        }
        this.balance = FileInteract.getCred(getUsername(),BALANCE_POSITION,DB_NAME);//set objects "balance" instance to the value recorded in db
    }

    public String getBalance(){//get method for balance
        return this.balance;
    }
}
