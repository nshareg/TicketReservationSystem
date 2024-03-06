import java.io.*;
import java.util.*;
/*
     IMPORTANT NOTE
     here the row elements are separated with ":"'s, when first element is username, second is password,
     third one is role of the user, which can be admin or user
     also if it exists we have balance, in the 3th part

 */
public class Login {
    public static boolean ifLogin(String username, String password){//boolean for logging in into the system
        try (BufferedReader reader = new BufferedReader(new FileReader("passdb.txt"))) {//reads the file
            String rows;
            while ((rows = reader.readLine()) != null) {//loops until the last row
                String[] row = rows.split(":");//splits row by ":"
                String usname = row[0];//extracts username
                String pass = row[1];//password
                if (usname.equals(username) && pass.equals(password)) {
                    return true; // if matched returns true
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;//returns false otherwise
    }
    public static boolean ifUserExists(String username){//boolean method for determining does the user exists
        try (BufferedReader reader = new BufferedReader(new FileReader("passdb.txt"))) {//reads the file
            String rows;
            while ((rows = reader.readLine()) != null) {//loops until the last row
                String[] row = rows.split(":");//splits row by ":"
                if (row[0].equals(username)) {
                    return true; // if matched returns true
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;//returns false otherwise
    }
    public static void setAccount(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("passdb.txt", true))) {
            writer.write(username); // Write the username
            writer.write(":"); // Delimiter
            writer.write(password); // Write the password
            writer.write("\n"); // New line
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setNewPart(String username, String val){//method for finding the right row and adding new part
        ArrayList<String> list = new ArrayList<>();//create object of class arraylist
        try (BufferedReader reader = new BufferedReader(new FileReader("passdb.txt"))) {//opens the file
            String row;
            while ((row = reader.readLine()) != null) {//loop for adding row to array list
                list.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {//loop for searching desirable row and adding the part we need
            String line = list.get(i);
            String[] credentials = line.split(":");//splitting the line into parts
            if (credentials[0].equals(username)) {//choosing first part(username) and comparing with instance we have
                list.set(i, line + ":" + val);//if they matched adding our new part
                break;//breaking the loop
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("passdb.txt"))) {//copying the rows from arraylist into our blanked file
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i));//adding the row
                writer.newLine();//going to the next row
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getRow(String username){//method which returns the whole row by username
        try (BufferedReader reader = new BufferedReader(new FileReader("passdb.txt"))) {// reads the file
            String rows;
            while ((rows = reader.readLine()) != null) {//goes until last row
                String[] credentials = rows.split(":");//splits our row for future comparing
                if(credentials[0].equals(username)) return rows;//if matched returns row
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String getCred(String username, int position){//method which returns info about user with the username
        try (BufferedReader reader = new BufferedReader(new FileReader("passdb.txt"))) {
            String rows;
            while ((rows = reader.readLine()) != null) {//loops until the end of the file
                String[] credentials = rows.split(":");//splits our row
                if(credentials[0].equals(username)) return credentials[position];//if matched returns the needed  element of the array, which is the role
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static int getLength(String username){//returns number of elements
        try (BufferedReader reader = new BufferedReader(new FileReader("passdb.txt"))) {//reads the file
            String rows;
            while ((rows = reader.readLine()) != null) {//loops until the last row
                String[] row = rows.split(":");//splits row by ":"
                if (row[0].equals(username)) {//if matched
                    return row.length;//return length of the array, which is filled by the separated elements
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

