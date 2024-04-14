package cli;
import core.DatabaseWrapper;
import core.User;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        LoginInterface lg = new LoginInterface();
        lg.execute();
    }
}
