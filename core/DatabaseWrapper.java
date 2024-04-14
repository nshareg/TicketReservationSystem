package core;
import java.io.*;
import java.util.*;
/*
     IMPORTANT NOTE
     here the row elements are separated with ":"'s, when first element is username, second is password,
     third one is role of the user, which can be admin or user
     also if it exists we have balance, in the 4th part

 */
public class DatabaseWrapper {//Database wrapper
    private ArrayList<User> users;
    private ArrayList<Activity> activities;
    public void fillUsers(String filename){//initilize everything during run, fill the array and then append with this class to that
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {//reads the file
            String rows;
            while ((rows = reader.readLine()) != null) {//loops until the last row
                String[] elements = rows.split(":");
                this.users.add(new User(elements[0],elements[1],elements[2],Integer.parseInt(elements[3])));
            }
        } catch (IOException e) {
            System.err.format("%s%n", e);
        }
    }
    public void getActivity(String filename){
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {//reads the file
            String rows;
            while ((rows = reader.readLine()) != null) {//loops until the last row
                String[] elements = rows.split(":");
                this.activities.add(new Activity(elements[0], elements[1], elements[2], Integer.parseInt(elements[3]), ) {
                });
            }
        } catch (IOException e) {
            System.err.format("%s%n", e);
        }
    }

    public void changeElement(ArrayList<Object> list){
        
    }
    public static int getRowNum(String filename){//method which returns number of users in db
        int num = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {//reads the file
            String rows;
            while ((rows = reader.readLine()) != null) {//loops until the last row
                num++;//increments number of users
            }
        } catch (IOException e) {
            System.err.format("%s%n", e);
        }
        return num;
    }
    public void close(String filename){
        
    }
}

