package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.*;

public class RegistrationPage extends JFrame {

    private Core core;
    private JFrame f;
    final JPasswordField password, repeatPassword;
    final JTextField username;
    public RegistrationPage(Core core){

        this.core = core;

        f = new JFrame("Registration");

        final JLabel label = new JLabel();
        label.setBounds(20,150, 200,50);

        JLabel l1=new JLabel("Username:");
        l1.setBounds(20,20, 80,30);
        JLabel l2=new JLabel("Password:");
        l2.setBounds(20,75, 80,30);
        JLabel l3=new JLabel("Repeat:");
        l3.setBounds(20,120, 80,30);

        JButton register = new JButton("Registration");
        register.setBounds(100,160, 120,30);

        username = new JTextField();
        username.setBounds(100,20, 120,30);
        password = new JPasswordField();
        password.setBounds(100,75,120,30);
        repeatPassword = new JPasswordField();
        repeatPassword.setBounds(100,120,120,30);

        f.add(password); f.add(l1); f.add(label); f.add(l2);
        f.add(l3); f.add(register); f.add(username); f.add(repeatPassword);

        f.setSize(300,300);
        f.setBackground(Color.CYAN);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);

        register.addActionListener(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent e) {
        String pass = new String(password.getPassword());
        String repeat = new String(repeatPassword.getPassword());

        if (pass.equals(repeat)){
            if (core.setUser(username.getText() + "#" + pass + "#" +
                    "USER#0")){
                JOptionPane.showMessageDialog(f, "Registered Successfully!!!",
                        "Registration", JOptionPane.INFORMATION_MESSAGE);
                core.login(username.getText(), pass);
                MenuPage page = new MenuPage(core);
                page.setLocationRelativeTo(null);
                page.setVisible(true);
                f.dispose();
            }
            else {
                JOptionPane.showMessageDialog(f, "Username Already Exist!!!",
                        "Registration", JOptionPane.ERROR_MESSAGE);
            }
        } else if (!pass.equals(repeat)) {
            JOptionPane.showMessageDialog(f, "Repeat The Password Properly!!!",
                    "Registration", JOptionPane.ERROR_MESSAGE);
        }
    }
}
