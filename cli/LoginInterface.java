package cli;

import java.util.Scanner;

import core.DatabaseWrapper;
import core.User;
public class LoginInterface {
    public void execute(){
        Scanner sc = new Scanner(System.in);
        DatabaseWrapper db = new DatabaseWrapper();
        db.fillUsers("passdb.txt");
        User cos = null;
        boolean logedIn = false;
        while(!logedIn){
            System.out.println("Please login");
            String username = sc.next();
            String password = sc.next();
            if(db.ifLogin(username, password)){
                System.out.println("Logged in as " + username);
                cos = db.getUser(username);
                logedIn = true;
            }
            else{
                System.out.println("Wrong login info");
            }
        }
    }
}
