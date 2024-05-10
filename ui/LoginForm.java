package ui;

import core.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {

    private JButton login, register;
    final JPasswordField password;
    final JTextField username;

    final JFrame f;

    private boolean isOpen = true;

    Core core;
    public LoginForm(Core core){
        this.core = core;

        f = new JFrame("LogIn");

        final JLabel label = new JLabel();
        label.setBounds(20,150, 200,50);

        JLabel l1=new JLabel("Username:");
        l1.setBounds(20,20, 80,30);
        JLabel l2=new JLabel("Password:");
        l2.setBounds(20,75, 80,30);

        login = new JButton("Login");
        login.setBounds(100,120, 120,30);
        register = new JButton("Registration");
        register.setBounds(100,160, 120,30);

        username = new JTextField();
        username.setBounds(100,20, 120,30);
        password = new JPasswordField();
        password.setBounds(100,75,120,30);

        f.add(password); f.add(l1); f.add(label); f.add(l2); f.add(register); f.add(login); f.add(username);

        f.setSize(300,300);
        f.setBackground(Color.CYAN);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);

        login.addActionListener(this);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrationPage(core);
                f.dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent ae){


        String userValue = username.getText();
        String passValue = new String(password.getPassword());
        System.out.println(passValue);

        if (core.login(userValue, passValue)) {
            f.dispose();
            MenuPage page = new MenuPage(core);

            page.setLocationRelativeTo(null);
            page.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Invalid username or password",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
