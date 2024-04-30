package core;
import exception.InvalidUserCredentials;

import java.util.ArrayList;
import java.util.List;

public class User implements Cloneable{
    public enum Role{
        ADMIN, USER
    }
    private String username;
    private String password;
    private Role role;
    private int balance;
    private ArrayList<String> activities;
    public final String DB_NAME = "passdb.txt";
    public User(){}//empty constructor

    public User(String username, String password,String role, int balance) throws InvalidUserCredentials{
        this.username = username;
        this.password = password;
        this.activities = new ArrayList<>();
        setRole(role);
        setBalance(balance);
    }
    public User(User user){
        this.username = user.username;
        this.password = user.password;
        this.activities = new ArrayList<>(List.of(user.getActivities()));
        this.role = user.role;
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
    public void setRole(String role) throws InvalidUserCredentials {
        if(role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("user")) this.role = Role.valueOf(role.toUpperCase());
        else throw new InvalidUserCredentials();
    }
    public Role getRole(){
        return role;
    }
    public String toString(){
        return username + " " + role +" "+ balance;
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
    public User clone() {
        try {
            User clone = (User) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
