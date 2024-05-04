package cli;

import java.util.Arrays;
import java.util.Scanner;

import core.Core;
import core.DatabaseWrapper;
import core.User;
public class LoginInterface {
    public void execute(){
        Scanner sc = new Scanner(System.in);
        Core current = new Core();
        boolean logedIn = false;
        while(!logedIn){
            System.out.println("Please login");
            String username = sc.next();
            String password = sc.next();
            if(current.login(username, password)){
                logedIn = true;
                current.register("liverpoolvsbarca");
                current.logOut();
            }
            else{
                System.out.println("Wrong login info");
            }
        }
    }
}