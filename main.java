import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User us = new User(sc.next());
        System.out.println(us.getUsername());
    }
}
