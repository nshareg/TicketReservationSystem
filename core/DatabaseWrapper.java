package core;
import exception.InvalidUserCredentials;
import java.io.*;
import java.util.*;
/*
     IMPORTANT NOTE
     here the row elements are separated with ":"'s, when first element is username, second is password,
     third one is role of the user, which can be admin or user
     also if it exists we have balance, in the 4th part

 */
public class DatabaseWrapper {
    private ArrayList<User> users;
    private ArrayList<Activity> activities;
    public DatabaseWrapper(){
        users = new ArrayList<>();
        activities = new ArrayList<Activity>();
    }
    public void fillUsers(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String row;
            while ((row = reader.readLine()) != null) {
                String[] elements = row.split(":");
                try {
                    isValidUser(elements);
                    users.add(new User(elements[0],elements[1],elements[2], Integer.parseInt(elements[3])));
                }catch (InvalidUserCredentials e){
                    System.out.println("at line " + row);
                    System.exit(0);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.format("Error reading file: %s%n", e);
        }
    }
    public void isValidUser(String[] arr) throws InvalidUserCredentials{
        if(arr.length < 4) throw new InvalidUserCredentials();
    }
    public void fillActivities(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String row;
            while ((row = reader.readLine()) != null) {
                String[] elements = row.split("/");
                switch (elements[0]){
                    //case "amusement": activities.add(new Amusement());//empty for now than after deciding major design choices would be added respective variables
                  //  case "game": activities.add(new Game());
                  //  case "transportation": activities.add(new Transportation());
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.format("Error reading file: %s%n", e);
        }
    }
    public User getUser(String name){
        for(User user : users){
            if(user.getUsername().equals(name)) return new User(user);
        }
        return null;
    }
    public void addUserActivity(String name, String activity){
        getUser(name).addActivity(activity);
    }
    public boolean ifLogin(String username, String password){
        User temp = getUser(username);
        if(temp == null) return false;
        return getUser(username).getPassword().equals(password);
    }
    public int getRowNum(boolean flag){//method which returns number of users in db, if true it givers number of rows for users array, if false for activites
        if(flag) return users.size();
        else return activities.size();
    }
    public void close(String filename){
        
    }
}

