package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import core.Core;

public class MenuPage extends JFrame {

    private String username;
    private Core core;

    public MenuPage(Core core) {

        this.core = core;
        String[] elements = core.getUser().split("#");

        setTitle("Main Page");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel userInfoPanel = new JPanel();
        JLabel userInfoLabel = new JLabel("Username: " + elements[0] + " | Balance: $" + elements[1]);
        userInfoPanel.add(userInfoLabel);
        add(userInfoPanel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        add(panel, BorderLayout.CENTER);

        BufferedImage amusementImage = loadImage("./Images/photo2.jpg");
        BufferedImage gamesImage = loadImage("./Images/photo.jpg");
        BufferedImage transportationImage  ;
        transportationImage = loadImage("./Images/photo3.jpg");

        JButton amusementButton = createCategoryButton("Amusement", amusementImage);
        JButton gamesButton = createCategoryButton("Games", gamesImage);
        JButton transportationButton = createCategoryButton("Transportation", transportationImage);

        amusementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAmusementPage();
            }
        });

        gamesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGamesPage();
            }
        });

        transportationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTransportationPage();
            }
        });

        panel.add(amusementButton);
        panel.add(gamesButton);
        panel.add(transportationButton);
    }

    private BufferedImage loadImage(String imagePath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private JButton createCategoryButton(String text, BufferedImage image) {
        JButton button = new JButton(text);
        if (image != null) {
            ImageIcon icon = new ImageIcon(image.getScaledInstance(250, 250, Image.SCALE_SMOOTH));
            button.setIcon(icon);
        }
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        return button;
    }

    private void openAmusementPage() {
        AmusementPage page = new AmusementPage(core);
        page.setVisible(true);
        dispose();
    }

    private void openGamesPage() {
        GamesPage page = new GamesPage(core);
        page.setVisible(true);
        dispose();
    }

    private void openTransportationPage() {
        // Open the Transportation Page
    }

}
