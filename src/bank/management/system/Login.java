package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JLabel bankIconLabel, cardIconLabel, titleLabel, cardNumberLabel, pinNumberLabel, backgroundImageLabel;
    JTextField cardNumberTextField;
    JPasswordField pinNumberPasswordField;
    JButton loginButton, signUpButton, clearButton;

    Login() {
        super("Bank Management System");

        setLayout(null);
        setSize(850, 480);
        setLocation(450, 200);

        ImageIcon bankIconRaw = new ImageIcon(ClassLoader.getSystemResource("images/icons/bank.png"));
        Image bankIconResizedImage = bankIconRaw.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankIcon = new ImageIcon(bankIconResizedImage);

        bankIconLabel = new JLabel(bankIcon);
        bankIconLabel.setBounds(350, 10, 100, 100);
        add(bankIconLabel);

        ImageIcon cardIconRaw = new ImageIcon(ClassLoader.getSystemResource("images/icons/card.png"));
        Image cardIconResizedImage = cardIconRaw.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon cardIcon = new ImageIcon(cardIconResizedImage);

        cardIconLabel = new JLabel(cardIcon);
        cardIconLabel.setBounds(630, 350, 100, 100);
        add(cardIconLabel);

        titleLabel = new JLabel("Welcome to Bank Management");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setBounds(170, 125, 600, 40);
        add(titleLabel);

        cardNumberLabel = new JLabel("Card No:");
        cardNumberLabel.setFont(new Font("Arial", Font.BOLD, 26));
        cardNumberLabel.setForeground(Color.WHITE);
        cardNumberLabel.setBounds(170, 190, 200, 40);
        add(cardNumberLabel);

        cardNumberTextField = new JTextField(15);
        cardNumberTextField.setBounds(310, 190, 300, 40);
        cardNumberTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(cardNumberTextField);

        pinNumberLabel = new JLabel("PIN:");
        pinNumberLabel.setFont(new Font("Arial", Font.BOLD, 26));
        pinNumberLabel.setForeground(Color.WHITE);
        pinNumberLabel.setBounds(170, 240, 200, 40);
        add(pinNumberLabel);

        pinNumberPasswordField = new JPasswordField(15);
        pinNumberPasswordField.setBounds(310, 240, 300, 40);
        pinNumberPasswordField.setFont(new Font("Arial", Font.BOLD, 20));
        add(pinNumberPasswordField);

        loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLACK);
        loginButton.setBounds(310, 300, 140, 40);
        loginButton.addActionListener(this);
        add(loginButton);

        clearButton = new JButton("CLEAR");
        clearButton.setFont(new Font("Arial", Font.BOLD, 20));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.BLACK);
        clearButton.setBounds(470, 300, 140, 40);
        clearButton.addActionListener(this);
        add(clearButton);

        signUpButton = new JButton("SIGN UP");
        signUpButton.setFont(new Font("Arial", Font.BOLD, 20));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(Color.BLACK);
        signUpButton.setBounds(310, 350, 300, 40);
        signUpButton.addActionListener(this);
        add(signUpButton);


        ImageIcon backgroundRaw = new ImageIcon(ClassLoader.getSystemResource("images/backgrounds/background.png"));
        Image backgroundResizedImage = backgroundRaw.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon backgroundImage = new ImageIcon(backgroundResizedImage);

        backgroundImageLabel = new JLabel(backgroundImage);
        backgroundImageLabel.setBounds(0, 0, 850, 480);
        add(backgroundImageLabel);


        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == loginButton) {

            } else if (e.getSource() == signUpButton) {
                cardNumberTextField.setText("");
                pinNumberPasswordField.setText("");
            } else if (e.getSource() == clearButton) {

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
