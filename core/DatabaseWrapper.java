package core;
import exception.InvalidDatabaseException;
import exception.InvalidUserCredentials;
import java.io.*;
import java.util.*;
/*
     IMPORTANT NOTE
     here the row elements are separated with "#"'s, when first element is username, second is password,
     third one is role of the user, which can be admin or user
     also if it exists we have balance, in the 4th part

 */
public class DatabaseWrapper {
    private ArrayList<User> users;
    private ArrayList<Activity> activities;
    private String filenameOfUsers;
    private String fileNameOfActivities;

    /**
     * Constructor for initializing object with two db names.
     *
     * @param filenameOfUsers filename of database of usernames
     * @param fileNameOfActivities filename of database of activities
     * @throws InvalidDatabaseException exception warning about difficulties with opening any of the files
     */
    public DatabaseWrapper(String filenameOfUsers, String fileNameOfActivities) throws InvalidDatabaseException {
        try{
        this.filenameOfUsers = filenameOfUsers;
        this.fileNameOfActivities = fileNameOfActivities;
        users = new ArrayList<>();
        activities = new ArrayList<>();
        fillUsers(filenameOfUsers);
        fillActivities(fileNameOfActivities);
        }
        catch (IOException e) {
            throw new InvalidDatabaseException();
        }
    }

    /**
     * Method for creating and placing User class object in our instance variable of ArrayList type
     *
     * @param filename name of the file
     * @throws IOException exception warning about file opening problems
     */
    private void fillUsers(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String row;
            while ((row = reader.readLine()) != null) {
                String[] elements = row.split("#");
                try {
                    isValidUser(elements);
                    User temp = new User(elements[0],elements[1], User.Role.valueOf(elements[2]), Integer.parseInt(elements[3]));
                    for(int i = 3; i< elements.length; i++){
                        temp.setActivities(elements[i]);
                    }
                    users.add(temp);

                }catch (InvalidUserCredentials e){
                    System.out.println("at line " + row);
                    System.exit(0);
                }
            }
        }

    }

    /**
     * Method for checking does there are user having the same username
     *
     * @param usernameOfNew String of username to check
     * @return boolean representation
     */
    public boolean ifUserExists(String usernameOfNew){
        for(User user : users){
            if(user.getUsername().equals(usernameOfNew)) return true;
        }
        return false;
    }
    /**
     *  Adding user class object to our instance variable of ArrayList typw
     *
     * @param line String line representing credentials of user delimited with # sign
     * @throws InvalidUserCredentials warns about corrupted credentials
     */
    public void setUser(String line) throws InvalidUserCredentials {
        String[] elements = line.split("#");
        User temp = new User(elements[0],elements[1], User.Role.valueOf(elements[2]), Integer.parseInt(elements[3]));
        users.add(temp);
    }

    /**
     * Adds activity class object to our instance of ArrayList class
     *
     * @param row string representation of the Activity
     */
    public void setActivity(String row){
        activities.add(activityGenerator(row));
    }

    /**
     * returns array of all activities we have
     *
     * @return Array of type Activity
     */
    public Activity[] getActivityDB(){
        return activities.toArray(new Activity[0]);
    }

    /**
     * Checks if the line with user credentials is valid
     *
     * @param arr array of credentials
     * @throws InvalidUserCredentials warns about corrupted line
     */
    public void isValidUser(String[] arr) throws InvalidUserCredentials{
        if(arr.length < 4) throw new InvalidUserCredentials();
    }

    /**
     * Fills instance ArrayList of activities with respective objects
     *
     * @param filename filename of database
     * @throws IOException exception warning about difficulties opening the file
     */
    public void fillActivities(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String row;
            while ((row = reader.readLine()) != null) {
                activities.add(activityGenerator(row));
            }
        }
    }

    /**
     * Creates object of class Activity from string
     *
     * @param row String with information about activity
     * @return object of class Activity
     */
    private Activity activityGenerator(String row){
        return switch (row.charAt(0)) {
            case 'g' -> new Game(row.substring(1));
            case 'a' -> new Amusement(row.substring(1));
            case 't' -> new Transportation(row.substring(1));
            default -> null;
        };
    }

    /**
     * returns activity by name
     * @param code name of the activity
     * @return object of class Activity
     */
    public Activity getActivity(String code){
        for(Activity codes : activities){
            if(codes.getName().equals(code)){
                return codes;
            }
        }
        return null;
    }

    /**
     * Returns object of class User by its username
     *
     * @param name username of User
     * @return object of class User
     */
    public User getUser(String name){
        for(User user : users){
            if(user.getUsername().equals(name)) return user;
        }
        return null;
    }

    /**
     * Method for checking if there are object of User class with respective login and password
     *
     * @param username username of User
     * @param password password of User
     * @return boolean about if login was successful or not
     */
    public boolean ifLogin(String username, String password){
        User temp = getUser(username);
        if(temp == null) return false;
        return temp.getUsername().equals(username) && temp.getPassword().equals(password);
    }

    /**
     * Method for closing the DW object, by writing all the objects to their databases by calling their toString method
     */
    public void close(){
        try {
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(filenameOfUsers));
            users.trimToSize();
            for(User user : users){
                outputStream.println(user);
            }
            outputStream.close();

        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        try {
            PrintWriter outputStream2 = new PrintWriter(new FileOutputStream(fileNameOfActivities));
            activities.trimToSize();
            for(Activity string : activities){
                String symb = "";
                if(string.getClass() == Amusement.class) symb = "a";
                if(string.getClass() == Transportation.class) symb = "t";
                if(string.getClass() == Game.class) symb = "g";
                outputStream2.println(symb + string);
            }
            outputStream2.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}

