package core;
import exception.InvalidUserCredentials;

import java.util.ArrayList;
import java.util.List;

public class User implements Cloneable{
    public enum Role{
        ADMIN,USER;
    }
    private String username;
    private String password;
    private int balance;
    private boolean ifAdmin;
    private ArrayList<String> activities;
    public final String DB_NAME = "passdb.txt";
    public User(){
    }

    public User(String username, String password, Role role, int balance) throws InvalidUserCredentials{
        this.username = username;
        this.password = password;
        this.ifAdmin = role.equals(Role.ADMIN);
        this.activities = new ArrayList<>();
        setBalance(balance);
    }
    public User(User user){
        this.username = user.username;
        this.password = user.password;
        this.ifAdmin = user.ifAdmin;
        this.activities = new ArrayList<>(List.of(user.getActivities()));
        this.balance = user.balance;
    }
    public boolean getIfAdmin(){
        return ifAdmin;
    }
    public void addActivity(String activity){
       activities.add(activity);
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public int getBalance(){
        return balance;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String toString(){
        return username + "#" + password + "#" + adminGenerator() + "#" + balance;
    }
    public String adminGenerator(){
        if (ifAdmin) return Role.ADMIN.toString();
        if (!ifAdmin) return Role.USER.toString();
        return null;
    }
    public void setActivities(String code){
        if(code != null){
            this.activities.add(code);
        }
    }
    public boolean equals(Object object){
        if(object == null) return false;
        if(object.getClass() != getClass()) return false;
        else{
            User copy = (User) object;
            boolean username = getUsername().equals(copy.getUsername());
            boolean password = getPassword().equals(copy.getPassword());
            return username && password;
        }
    }
    public String[] getActivities(){
        return activities.toArray(new String[0]);
    }
}
