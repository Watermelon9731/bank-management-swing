package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
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

        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
