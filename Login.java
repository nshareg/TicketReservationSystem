import java.io.*;
import java.util.*;
/*
     IMPORTANT NOTE
     here the row elements are separated with ":"'s, when first element is username, second is password,
     third one is role of the user, which can be admin or user
     also if it exists we have balance, in the 4th part

 */
public class Login {
    public static boolean readLoginInfo(String username, String password){//boolean for searching if we have login and password in our file.
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
    public static void setLoginInfo(String username, String password){//method for writing new credentials
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("passdb.txt"))) {//opens the file
            writer.write(username);//writes the username
            writer.write(":");//adds delimiter
            writer.write(password);//writes the password

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setInfo(String username, String val){//method for finding the right row and adding new part
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
        return "error";//prints error otherwise
    }
    public static String getRole(String username){//method which returns the role of the username, all the same as in the previous method, with changes in only commented places
        try (BufferedReader reader = new BufferedReader(new FileReader("passdb.txt"))) {
            String rows;
            while ((rows = reader.readLine()) != null) {
                String[] credentials = rows.split(":");
                if(credentials[0].equals(username)) return credentials[2];//if matched returns third element of the array, which is the role
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
    public static String getBalance(String username){//method for getting the balance and all the same is in previous ones
        try (BufferedReader reader = new BufferedReader(new FileReader("passdb.txt"))) {
            String rows;
            while ((rows = reader.readLine()) != null) {
                String[] credentials = rows.split(":");
                if(credentials[0].equals(username)) return credentials[3];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
}

