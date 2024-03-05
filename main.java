import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        String password = sc.next();

        if(Login.readLoginInfo(username,password)){
            if(Login.getRole(username).equals("user")){
                System.out.println(Login.getBalance(username));
            }
            else System.out.println("Wrong access");
        }
        else System.out.println("Account doesn't exist");



    }
}
