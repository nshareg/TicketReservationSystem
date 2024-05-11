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
            if(current.login(username, password) && current.getIfAdmin()){
                System.out.println("1| add activity 2| remove activity 3| for logout");
                if(sc.nextint() == 1){
                    System.out.println("Write all infromation with # used as space");
                    String temp = sc.next();
                    current.setNewActivity(temp);
                }else if(sc.nextint() == 2){
                    int index = 1;
                    for(String line : current.getActivityDB()){
                        System.out.println(index + line);                    
                    }
                    System.out.println("Which index to remove?");
                    int removeIndex = sc.nextint();
                    current.removeActivityByAdmin(current.getActivityDB()[removeIndex - 1]);
                }else if(sc.nextint() == 3){
                    current.logout();
                    current.exit();
                }
            }
            else{
                System.out.println("Wrong login info or invalid access level");
            }
        }
    }
}
