public class User extends SuperUser{
    private String balance;
    private final int BALANCE_POSITION = 3;//position indicator for balance
    public User(String username, String password){
        setCreds(username, password);//call of parent class method to set username and password
        setRole("user");//sets role user in any case
        setBalance("");//since we need to call set balance method in any case, we call it with empty String
    }
    public User(String username, String password, String balance){
        setCreds(username, password);//sets username and password
        setRole("user");//sets role user in any case
        setBalance(balance);//sets balance to the value we got
    }
    public void setBalance(String balance){//method for setting balance if its position is empty or initializing it from the database
        if(balance.isEmpty()){//if balance is empty value, it simply sets our object instance variable to the value we have in db
            this.balance = FileInteract.getCred(getUsername(),BALANCE_POSITION,DB_NAME);
        }
        else{//if the value is not empty executes part down below
            if(FileInteract.getLength(this.getUsername(),DB_NAME) < 4){//if length is smaller than 4, that means the place dedicated for balance is empty
                FileInteract.setNewPart(getUsername(), balance, DB_NAME);//adds part with our balance from the right
            }
            else{//if we already have the value in balance position
                FileInteract.changePart(getUsername(),balance,BALANCE_POSITION,DB_NAME);//change balance with the String we got
            }
            this.balance = balance;//set object balance variable to the one we got
        }
    }
    public String getBalance(){//get method for balance
        return this.balance;
    }
}
