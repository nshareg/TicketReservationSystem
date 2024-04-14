import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class main {

    public static void main(String[] args) {
        ArrayList<User> arrayList = FileInteract.getUsers("passdb.txt");
        System.out.println(arrayList.get(1));
    }

}
