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
    private String filenameOfUsers;
    private String fileNameOfActivities;
    public DatabaseWrapper(String filenameOfUsers, String fileNameOfActivities) {
        try{
        this.filenameOfUsers = filenameOfUsers;
        this.fileNameOfActivities = fileNameOfActivities;
        users = new ArrayList<>();
        activities = new ArrayList<>();
        fillUsers(filenameOfUsers);
        fillActivities(fileNameOfActivities);
        }
        catch (IOException e) {
            System.out.println("corrupted db of activites");
            System.exit(0);
        }
    }
    private void fillUsers(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String row;
            while ((row = reader.readLine()) != null) {
                String[] elements = row.split(":");
                try {
                    isValidUser(elements);
                    User temp = new User(elements[0],elements[1],elements[2], Integer.parseInt(elements[3]));
                    for(int i = 4; i< elements.length; i++){
                        temp.setActivities(elements[i]);
                    }
                    users.add(temp.clone());

                }catch (InvalidUserCredentials e){
                    System.out.println("at line " + row);
                    System.exit(0);
                }
            }
        }
    }
    public void isValidUser(String[] arr) throws InvalidUserCredentials{
        if(arr.length < 4) throw new InvalidUserCredentials();
    }
    public void fillActivities(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String row;
            while ((row = reader.readLine()) != null) {
                activities.add();
                }
            }
    }
    public Activity getActivity(String code){
        for(Activity codes : activities){

        }

        return null;
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
        return temp.getUsername().equals(username) && temp.getPassword().equals(password);
    }
    public int getRowNum(boolean flag){//method which returns number of users in db, if true it givers number of rows for users array, if false for activites
        if(flag) return users.size();
        else return activities.size();
    }

    public void close(){
        PrintWriter outputStream = null;
        PrintWriter outputStream2 = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream(filenameOfUsers));
            outputStream2 = new PrintWriter(new FileOutputStream(fileNameOfActivities));
            for(User user : users){
                outputStream.println(user.toString());
            }
            //for(String string : activities){
            //    outputStream2.println(string);
           // }
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}

