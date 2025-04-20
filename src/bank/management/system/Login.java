package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    JLabel titleLabel;

    Login() {
        super("Bank Management System");

        setLayout(null);
        setSize(850, 480);
        setLocation(450, 200);

        ImageIcon bankIconRaw = new ImageIcon(ClassLoader.getSystemResource("images/icons/bank.png"));
        Image bankIconResizedImage = bankIconRaw.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankIcon = new ImageIcon(bankIconResizedImage);

        JLabel bankLabel = new JLabel(bankIcon);
        bankLabel.setBounds(350, 10, 100, 100);
        add(bankLabel);

        ImageIcon cardIconRaw = new ImageIcon(ClassLoader.getSystemResource("images/icons/card.png"));
        Image cardIconResizedImage = cardIconRaw.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon cardIcon = new ImageIcon(cardIconResizedImage);

        JLabel cardLabel = new JLabel(cardIcon);
        cardLabel.setBounds(630, 350, 100, 100);
        add(cardLabel);

        titleLabel = new JLabel("Welcome to Bank Management");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setBounds(170, 125, 600, 40);
        add(titleLabel);

        ImageIcon backgroundRaw = new ImageIcon(ClassLoader.getSystemResource("images/backgrounds/background.png"));
        Image backgroundResizedImage = backgroundRaw.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon backgroundImage = new ImageIcon(backgroundResizedImage);

        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 850, 480);
        add(backgroundLabel);



        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
