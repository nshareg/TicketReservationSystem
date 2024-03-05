import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login {
    public static boolean readLoginInfo(String username, String password){
        try (BufferedReader reader = new BufferedReader(new FileReader("passdb.txt"))) {
            String rows;
            while ((rows = reader.readLine()) != null) {
                String[] row = rows.split(":");
                String usname = row[0];
                String pass = row[1];
                if (usname.equals(username) && pass.equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void setLoginInfo(String username, String password){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("passdb.txt"))) {
            writer.write(username);
            writer.write(":");
            writer.write(password);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setInfo(String username, String val){
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("passdb.txt"))) {
            String row;
            while ((row = reader.readLine()) != null) {
                list.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {
            String line = list.get(i);
            String[] credentials = line.split(":");
            if (credentials[0].equals(username)) {
                list.set(i, line + ":" + val);
                break;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("passdb.txt"))) {
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getRow(String username){
        try (BufferedReader reader = new BufferedReader(new FileReader("passdb.txt"))) {
            String rows;
            while ((rows = reader.readLine()) != null) {
                String[] credentials = rows.split(":");
                if(credentials[0].equals(username)) return rows;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
}

