package core;

import exception.InvalidDatabaseException;
import exception.InvalidUserCredentials;

import java.util.Arrays;

public class Core {
    private DatabaseWrapper db;
    private User tempUser;
    private final String USERDB = "passdb.txt";
    private final String ACTIVITYDB = "activitydb.txt";
    public Core() {
        try {
            db = new DatabaseWrapper(USERDB, ACTIVITYDB);
        }catch (InvalidDatabaseException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    public boolean login(String username, String password){
        boolean loginFlag = db.ifLogin(username, password);
        if(loginFlag){
            tempUser = db.getUser(username);
        }
        return loginFlag;
    }
    public boolean register(String activityID){
        Activity temp = db.getActivity(activityID);
        if(temp.getPrice() <= tempUser.getBalance()){
            System.out.println(temp.getBusySeats());
            tempUser.addActivity(activityID);
            temp.increment();
            tempUser.setBalance(tempUser.getBalance() - temp.getPrice());
            System.out.println(temp.getBusySeats());
            return true;
        }
        else{
            return false;
        }
    }
    public Activity[] getActivityDB(){//to be added logic, use with this definition
        System.out.println(Arrays.toString(db.getActivityDB()));
        return db.getActivityDB();
    }
    public String getUser(){
        return tempUser.getUsername() + tempUser.getBalance();
    }
    public void setUser(String line){
        try {
            db.setUser(line);
        }catch (InvalidUserCredentials e){
            System.out.println(e.getMessage());
        }

    }
    public boolean ifUserAdmin(){
        return tempUser.getIfAdmin();
    }
    public String[] getUserActivites(){
        String[] temp = new String[tempUser.getActivities().length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = db.getActivity(tempUser.getActivities()[i]).toString();
        }
        return temp;
    }
    public void setNewActivity(String row){
        db.setActivity(row);
    }
    public boolean setBalance(int balance){
        if(balance > 0) tempUser.setBalance(balance);
        return balance > 0;
    }

    public void logOut(){
        tempUser = null;
    }
    public void exit(){
        db.close();
    }
}
