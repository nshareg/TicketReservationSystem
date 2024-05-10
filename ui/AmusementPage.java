package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import core.*;

public class AmusementPage extends JFrame {

    private String username;

    public AmusementPage(Core core) {

        String[] elements = core.getUser().split("#");

        setTitle("Amusement Page");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel userInfoPanel = new JPanel();
        JLabel userInfoLabel = new JLabel("Username: " + elements[0] + " | Balance: $" + elements[1]);
        userInfoPanel.add(userInfoLabel);
        add(userInfoPanel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null); // Center the frame on the screen
    }


}