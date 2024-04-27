package core;
import exception.InvalidUserCredentials;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private boolean ifAdmin;
    private int balance;
    private ArrayList<String> activities;
    public final String DB_NAME = "passdb.txt";
    public User(){}//empty constructor

    public User(String username, String password,String role, int balance) throws InvalidUserCredentials{
        this.username = username;
        this.password = password;
        setIfAdmin(role);
        setBalance(balance);
    }
    public User(User user){
        this.username = user.username;
        this.password = user.password;
        this.ifAdmin = user.ifAdmin;
        this.balance = user.balance;
    }
    public void addActivity(String activity){
       activities.add(activity);
    }

    public void setBalance(int balance){
        if(balance > 0) this.balance = balance;
    }
    public String getUsername(){
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    public void setIfAdmin(String role) throws InvalidUserCredentials {
        if(role.equals("admin")) this.ifAdmin = true;
        if(role.equals("user")) this.ifAdmin = false;
        else throw new InvalidUserCredentials();
    }
    public boolean getRole(){
        return ifAdmin;
    }
    public String toString(){
        return username + " is a admin " + ifAdmin +" "+ balance;
    }
}
