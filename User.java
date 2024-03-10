public class User extends SuperUser{
    private String balance;
    private final int BALANCE_POSITION = 3;//position indicator for balance
    /**
     * Constructs a newly allocated <code>RectangleOnPlane</code> object that represents
     * user account with it username and password inherited from superclass, and balance.
     * balance set to the balance in db and role to the user by default.
     *
     * @param username     username in String
     * @param password     password in String
     */
    public User(String username, String password){
        setCreds(username, password);//call of parent class method to set username and password
        setRole("user");//sets role user in any case
        setBalance("");//since we need to initialize the balance in any case, we call the method with empty string
    }
    /**
     * Constructs a newly allocated <code>RectangleOnPlane</code> object that represents
     * user account with it username and password inherited from superclass, and balance.
     * balance set to the new balance and role to the user by default.
     *
     * @param username     username in String
     * @param password     password in String
     * @param balance      balance in String
     */
    public User(String username, String password, String balance){
        setCreds(username, password);//sets username and password
        setRole("user");//sets role user in any case
        setBalance(balance);//sets balance to the value we got
    }

    /**
     * Updates the balance of the customer to the specified String value,
     * if the value of parameter and spot for balance in db are empty, the value set 0
     * set to the new value otherwise
     *
     * @param balance     the new String value for the balance
     */
    public void setBalance(String balance) {
        boolean state = balance.isEmpty();
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
    /**
     * returns the balance of the customer
     *
     * @return balance     the new String value for the x coordinate
     */
    public String getBalance(){//get method for balance
        return this.balance;
    }
}
