package ui;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarEntry;
import core.*;

public class GamesPage extends JFrame {
    public GamesPage(Core core) {

        String[] elements = core.getUser().split("#");

        setTitle("Games Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel userInfoPanel = new JPanel();
        JLabel userInfoLabel = new JLabel("Username: " + elements[0] + " | Balance: $" + elements[1]);
        userInfoPanel.add(userInfoLabel);
        add(userInfoPanel, BorderLayout.NORTH);

        setVisible(true);
    }
}
