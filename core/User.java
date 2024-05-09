package core;
import exception.InvalidUserCredentials;

import java.util.ArrayList;
import java.util.Collections;
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

    /**
     * Constructor
     *
     * @param username
     * @param password
     * @param role
     * @param balance
     * @throws InvalidUserCredentials Exception warning about if the one of the parameters is corrupted
     */
    public User(String username, String password, Role role, int balance) throws InvalidUserCredentials{
        this.username = username;
        this.password = password;
        this.ifAdmin = role.equals(Role.ADMIN);
        this.activities = new ArrayList<>();
        setBalance(balance);
    }

    /**
     * Copy constructor
     *
     * @param user
     */
    public User(User user){
        this.username = user.username;
        this.password = user.password;
        this.ifAdmin = user.ifAdmin;
        this.activities = new ArrayList<>(List.of(user.getActivities()));
        this.balance = user.balance;
    }

    /**
     * Method for checking is the User admin or not
     *
     * @return boolean representation
     */
    public boolean getIfAdmin(){
        return ifAdmin;
    }

    /**
     * add Activity name to Users array of Strings
     * @param activity name of the activity
     */
    public void addActivity(String activity){
       activities.add(activity);
    }

    /**
     * Mutator for balance
     * @param balance new balance
     */
    public void setBalance(int balance){
        this.balance = balance;
    }

    /**
     * Accessor for balance
     * @return int of the balance
     */
    public int getBalance(){
        return balance;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }

    /**
     * toString method, to be used only during file writing
     * @return String representation of the user
     */
    public String toString(){
        String result = username + "#" + password + "#" + adminGenerator() + "#" + balance;
        for(String activityID : activities){
            result += "#" + activityID;
        }
        return result;
    }

    /**
     * Method for changing boolean to String
     * @return String representation of the role of the User
     */
    public String adminGenerator(){
        if (ifAdmin) return Role.ADMIN.toString();
        if (!ifAdmin) return Role.USER.toString();
        return null;
    }

    /**
     * Method for adding new activity to user
     *
     * @param code name of the activity
     */
    public void setActivities(String code){
        if(code != null){
            this.activities.add(code);
        }
    }

    /**
     * Override of equals method
     *
     * @param object Object class object
     * @return boolean representation
     */
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
    public boolean deleteRegistration(String activityID){
        for(String ID : activities){
            if(ID.equals(activityID)){
                activities.remove(ID);
                return true;
            }
        }
        return false;
    }
    public int deleteAllRegistrationOccurrences(String activityID){
        int num = 0;
        for(String ID :activities){
            if(ID.equals(activityID)){
                num++;
            }
        }
        activities.removeAll(Collections.singleton(activityID));
        return num;
    }
    /**
     * Method for getting all activities User is registered for
     * @return Array of Strings with names of each activity
     */
    public String[] getActivities(){
        return activities.toArray(new String[0]);
    }
}
