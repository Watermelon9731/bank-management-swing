package bank.management.system;

import bank.management.system.constants.Background;
import bank.management.system.services.HashUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel bankIconLabel, cardIconLabel, titleLabel, cardNumberLabel, pinNumberLabel, backgroundImageLabel;
    JTextField cardNumberTextField;
    JPasswordField pinNumberPasswordField;
    JButton loginButton, signUpButton, clearButton, exitButton;

    Login() {
        super("Bank Management System");

        setLayout(null);
        setSize(850, 600);
        setLocation(300, 150);

        ImageIcon bankIconRaw = new ImageIcon(ClassLoader.getSystemResource("images/icons/bank.png"));
        Image bankIconResizedImage = bankIconRaw.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankIcon = new ImageIcon(bankIconResizedImage);

        bankIconLabel = new JLabel(bankIcon);
        bankIconLabel.setBounds(350, 10, 100, 100);
        add(bankIconLabel);

        titleLabel = new JLabel("Chào mừng đến ngân hàng ảo");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setBounds(170, 125, 600, 40);
        add(titleLabel);

        cardNumberLabel = new JLabel("Mã thẻ:");
        cardNumberLabel.setFont(new Font("Arial", Font.BOLD, 26));
        cardNumberLabel.setForeground(Color.WHITE);
        cardNumberLabel.setBounds(170, 190, 200, 40);
        add(cardNumberLabel);

        cardNumberTextField = new JTextField();
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

        loginButton = new JButton("Đăng nhập");
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Background.BUTTON_PRIMARY);
        loginButton.setBounds(310, 300, 140, 40);
        loginButton.addActionListener(this);
        add(loginButton);

        clearButton = new JButton("Xóa");
        clearButton.setFont(new Font("Arial", Font.BOLD, 20));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.BLACK);
        clearButton.setBounds(470, 300, 140, 40);
        clearButton.addActionListener(this);
        add(clearButton);

        signUpButton = new JButton("Đăng ký");
        signUpButton.setFont(new Font("Arial", Font.BOLD, 20));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(Background.BUTTON_SUGGEST);
        signUpButton.setBounds(310, 350, 300, 40);
        signUpButton.addActionListener(this);
        add(signUpButton);

        exitButton = new JButton("Thoát");
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Background.BUTTON_WARNING);
        exitButton.setBounds(310, 400, 300, 40);
        exitButton.addActionListener(this);
        add(exitButton);


        ImageIcon backgroundRaw = new ImageIcon(ClassLoader.getSystemResource("images/backgrounds/skyscraper.png"));
        Image backgroundResizedImage = backgroundRaw.getImage().getScaledInstance(850, 600, Image.SCALE_DEFAULT);
        ImageIcon backgroundImage = new ImageIcon(backgroundResizedImage);

        backgroundImageLabel = new JLabel(backgroundImage);
        backgroundImageLabel.setBounds(0, 0, 850, 600);
        add(backgroundImageLabel);

        setVisible(true);

    }

    public void textFieldClear() {
        cardNumberTextField.setText("");
        pinNumberPasswordField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == loginButton) {
                String cardNumber = cardNumberTextField.getText();
                String pin = pinNumberPasswordField.getText();
                if (cardNumberTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số thẻ");
                } else if (pinNumberPasswordField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập mã pin");
                } else {
                    try {
                        Float.parseFloat(cardNumberTextField.getText());
                        Float.parseFloat(pinNumberPasswordField.getText());
                        try {
                            String pinCode = HashUtil.hashSHA256(pin + cardNumber);

                            Connector connector = new Connector();
                            String loginQuery = "select * from login where card_number='" + cardNumber + "' and pin='" + pinCode + "'";

                            ResultSet rs = connector.statement.executeQuery(loginQuery);

                            if (rs.next()) {
                                setVisible(false);
                                new Home(pinCode);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sai mã số thẻ hoặc mã PIN");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Tạm thời không thể đăng nhập");
                        }
                    } catch (NumberFormatException numberFormatException) {
                        numberFormatException.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Số thẻ và Mã PIN phải là số");
                    }
                }
            } else if (e.getSource() == signUpButton) {
                textFieldClear();
                new SignupFirst("");
                setVisible(false);
            } else if (e.getSource() == clearButton) {
                textFieldClear();
            } else if (e.getSource() == exitButton) {
                System.exit(0);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
