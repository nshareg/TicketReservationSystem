import java.io.*;
import java.util.*;
/*
     IMPORTANT NOTE
     here the row elements are separated with ":"'s, when first element is username, second is password,
     third one is role of the user, which can be admin or user
     also if it exists we have balance, in the 4th part

 */
public class FileInteract {
    public static boolean ifLogin(String username, String password){//boolean only for info regarding login info, so filename is fixed
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
    public static boolean ifUserExists(String key, String filename){//boolean method for determining does the row with some firs key name exists
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {//reads the file
            String rows;
            while ((rows = reader.readLine()) != null) {//loops until the last row
                String[] row = rows.split(":");//splits row by ":"
                if (row[0].equals(key)) {
                    return true; // if matched returns true
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;//returns false otherwise
    }
    public static void setRow(String var1, String var2, String filename) {//method for setting new row of information
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(var1); // Write the username
            writer.write(":"); // Delimiter
            writer.write(var2); // Write the password
            writer.write("\n"); // New line
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setNewPart(String key, String val, String filename){//method for finding the right row and adding new part
        ArrayList<String> list = new ArrayList<>();//create object of class arraylist
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {//opens the file
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
            if (credentials[0].equals(key)) {//choosing first part(username) and comparing with instance we have
                list.set(i, line + ":" + val);//if they matched adding our new part
                break;//breaking the loop
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {//copying the rows from arraylist into our blanked file
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i));//adding the row
                writer.newLine();//going to the next row
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void changePart(String key, String val, int pos, String filename){//method for finding and changing some instance in the row
        ArrayList<String> list = new ArrayList<>();//create object of class arraylist
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {//opens the file
            String row;
            while ((row = reader.readLine()) != null) {//loop for adding row to array list
                list.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < list.size(); i++){//loops until the end of list
            String[] credentials = list.get(i).split(":");//splits every row
            if(credentials[0].equals(key)){//if matched
                credentials[pos] = val;//changes the value in our pos, with given value
                list.set(i, String.join(":", credentials));//change the row with updated credentials array
                break;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {//copying the rows from arraylist into our blanked file
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i));//adding the row
                writer.newLine();//going to the next row
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getRow(int key, String filename){//method which returns the whole row by search key
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String rows;
            int num = 0;
            while ((rows = reader.readLine()) != null) {
                if (num == key) {
                    return rows;
                }
                num++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String getCred(String key, int position, String filename){//method which returns info from row regarding it's position
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String rows;
            while ((rows = reader.readLine()) != null) {//loops until the end of the file
                String[] credentials = rows.split(":");//splits our row
                if(credentials[0].equals(key) && position <= getLength(key, filename)) return credentials[position];//if matched returns the needed  element of the array, which is the role
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static int getLength(String key, String filename){//returns number of elements in a row
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {//reads the file
            String rows;
            while ((rows = reader.readLine()) != null) {//loops until the last row
                String[] row = rows.split(":");//splits row by ":"
                if (row[0].equals(key)) {//if matched
                    return row.length;//return length of the array, which is filled by the separated elements
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int getRowNum(String filename){//method which returns number of users in db
        int num = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {//reads the file
            String rows;
            while ((rows = reader.readLine()) != null) {//loops until the last row
                num++;//increments number of users
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }
}

