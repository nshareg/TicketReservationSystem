package cli;

import java.util.Arrays;
import java.util.Scanner;

import core.DatabaseWrapper;
import core.User;
public class LoginInterface {
    public void execute(){
        Scanner sc = new Scanner(System.in);
        DatabaseWrapper db = new DatabaseWrapper("passdb.txt","activitydb.txt");
        User cos = null;
        boolean logedIn = false;
        while(!logedIn){
            System.out.println("Please login");
            String username = sc.next();
            String password = sc.next();
            if(db.ifLogin(username, password)){
                cos = new User(db.getUser(username));
                System.out.println(cos);
                logedIn = true;
                System.out.println(db.getActivity(cos.getActivities()[0]));
                System.out.println(Arrays.toString(cos.getActivities()));
            }
            else{
                System.out.println("Wrong login info");
            }
        }
    }
}
