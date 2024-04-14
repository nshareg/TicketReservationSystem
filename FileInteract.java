import java.io.*;
import java.nio.file.attribute.UserPrincipal;
import java.util.*;
/*
     IMPORTANT NOTE
     here the row elements are separated with ":"'s, when first element is username, second is password,
     third one is role of the user, which can be admin or user
     also if it exists we have balance, in the 4th part

 */
public class FileInteract {
    public static ArrayList<User> getUsers(String filename){
        ArrayList<User> db = new ArrayList<>(getRowNum(filename));
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {//reads the file
            String rows;
            while ((rows = reader.readLine()) != null) {//loops until the last row
                String[] elements = rows.split(":");
                db.add(new User(elements[0],elements[1],elements[2],Integer.parseInt(elements[3])));
            }
        } catch (IOException e) {
            System.err.format("%s%n", e);
        }
        //returns false otherwise
    return db;
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
}

