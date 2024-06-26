package core;

import exception.InvalidDatabaseException;
import exception.InvalidUserCredentials;

import java.util.Arrays;

public class Core {
    private DatabaseWrapper db;
    private User tempUser;
    private final String USERDB = "passdb.txt";
    private final String ACTIVITYDB = "activitydb.txt";

    /**
     * Constructor initializing DW object, and creating null reference for the tempUser
     */
    public Core() {
        try {
            db = new DatabaseWrapper(USERDB, ACTIVITYDB);
        }catch (InvalidDatabaseException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * If login was successful gives the reference of the respective user to our instance
     * to work with it in future
     *
     * @param username username of the User
     * @param password password of the User
     * @return boolean representing does the login was successful or not
     */
    public boolean login(String username, String password){
        boolean loginFlag = db.ifLogin(username, password);
        if(loginFlag){
            tempUser = db.getUser(username);
        }
        return loginFlag;
    }

    /**
     * method for registering for activity for the user by activity's id
     *
     * @param activityID name of the activity
     * @return boolean representing was attempt successful or not
     */
    public boolean register(String activityID){
        Activity temp = db.getActivity(activityID);
        if(temp.getPrice() <= tempUser.getBalance()){
            tempUser.addActivity(activityID);
            temp.increment();
            tempUser.setBalance(tempUser.getBalance() - temp.getPrice());
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Method for calling respective method from the DW
     * @return Array of class Activity
     */
    public Activity[] getActivityDB(){
        return db.getActivityDB();
    }
    /**
     * return User class object Username and balance, for usages in GUI
     *
     * @return String delimited by # sign
     */
    public String getUser(){
        return tempUser.getUsername()+ "#" + tempUser.getBalance();
    }

    /**
     * Accessor for username of current User
     *
     * @return String of username
     */
    public String getUserName(){
        return tempUser.getUsername();
    }

    /**
     * Accessor for balance of current User
     * @return int of balance
     */
    public int getBalance(){
        return tempUser.getBalance();
    }
    /**
     * method for setting new user, or alternatively registering a new user
     * @param line String representation of all User credentials
     * @return boolean telling was operation successful or not
     */
    public boolean setUser(String line){
        try {
            if(db.ifUserExists(line.split("#")[0])){
                return false;
            }else{
                db.setUser(line);
                return true;
            }
        }catch (InvalidUserCredentials e){
            return false;
        }
    }

    /**
     * method for checking if user has Admin privileges or not
     *
     * @return respective boolean
     */
    public boolean ifUserAdmin(){
        return tempUser.getIfAdmin();
    }

    /**
     * Method returning all the activities for which tempUser is registered
     * @return Array of strings
     */
    public String[] getUserActivites(){
        return tempUser.getActivities();
    }
    public String getActivity(String name){
        return db.getActivity(name).toString();
    }
    /**
     * Calling respective method of the DW
     * @param row String with representation of activity details
     */
    public void setNewActivity(String row){
        db.setActivity(row);
    }

    /**
     * Method for setting new balance for the user
     * @param balance amount to be set
     * @return boolean warning about possible problems with negative balance
     */
    public boolean setBalance(int balance){
        if(balance > 0) tempUser.setBalance(balance);
        return balance > 0;
    }
    public boolean removeActivity(String ID){
        if(tempUser.deleteRegistration(ID)){
            db.getActivity(ID).decrement(1);
            return true;
        }
        return false;
    }

    /**
     * Method for admin users to delete some available activity
     * and by that also remove them from all the registered places
     * @param ID name of the activity
     * @return boolean warning about does the user has the admin privileges or not
     */
    public boolean removeActivityByAdmin(String ID){
        if(tempUser.getIfAdmin()){
            for(int i = 0; i < db.getLength(true); i++){
                User temp = db.getUser(i);
                db.getActivity(ID).decrement(temp.deleteAllRegistrationOccurrences(ID));
            }
            return true;
        }
        return false;
    }
    /**
     * Method for detach current reference of tempUser
     */
    public void logOut(){
        tempUser = null;
    }

    /**
     * Method representing end of the program, by calling method for writing all data stored in instances of DW
     * into their databases
     */
    public void exit(){
        db.close();
    }
}
