package bank.management.system;

import bank.management.system.constants.Background;
import bank.management.system.controller.AccountController;
import bank.management.system.model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserDetail extends JFrame implements ActionListener {

    String pinCode;
    JLabel backgroundLabel, headingLabel, cardNumberLabel, usernameLabel, emailLabel, phoneLabel, passwordLabel, confirmPasswordLabel;
    JTextField cardNumberTextField;
    JButton backButton;

    UserDetail() {
        this.pinCode = pinCode;

        setLayout(null);
        setSize(Background.BACKGROUND_WIDTH, Background.BACKGROUND_HEIGHT);
        setLocation(0, 0);

        headingLabel = new JLabel("Thông tin tài khoản");
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headingLabel.setBounds(0, 180, Background.BACKGROUND_WIDTH, 35);
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headingLabel);

        cardNumberLabel = new JLabel("Nhập số thẻ");
        cardNumberLabel.setForeground(Color.BLACK);
        cardNumberLabel.setFont(new Font("Arial", Font.BOLD, 20));
        cardNumberLabel.setBounds(0, 230, Background.BACKGROUND_WIDTH, 40);
        cardNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(cardNumberLabel);

        cardNumberTextField = new JTextField();
        cardNumberTextField.setFont(new Font("Arial", Font.BOLD, 20));
        cardNumberTextField.setHorizontalAlignment(SwingConstants.CENTER);
        cardNumberTextField.setBounds(Background.ATM_BUTTON_LEFT_START_X + 60, 280, 300, 40);
        add(cardNumberTextField);

        usernameLabel = new JLabel("");
        usernameLabel.setForeground(Color.BLACK);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        usernameLabel.setBounds(0, 400, Background.BACKGROUND_WIDTH, 40);
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(usernameLabel);

        backButton = new JButton("Tìm kiếm");
        backButton.setBounds(Background.ATM_BUTTON_RIGHT_START_X, Background.ATM_BUTTON_START_Y + 60, 150, Background.ATM_BUTTON_HEIGHT);
        backButton.setBackground(Background.BUTTON_SUGGEST);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon atmBackgroundRaw = new ImageIcon(ClassLoader.getSystemResource("images/backgrounds/atm-machine.png"));
        Image atmImage = atmBackgroundRaw.getImage().getScaledInstance(Background.BACKGROUND_WIDTH, Background.BACKGROUND_HEIGHT, Image.SCALE_DEFAULT);
        ImageIcon atmBackgroundImage = new ImageIcon(atmImage);

        backgroundLabel = new JLabel(atmBackgroundImage);
        backgroundLabel.setBounds(0, 0, Background.BACKGROUND_WIDTH, Background.BACKGROUND_HEIGHT);
        add(backgroundLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cardNumber = cardNumberTextField.getText();

        if (cardNumber.equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số thẻ");
            return;
        }

        try {
            Account res = AccountController.getAccountByCardNumber(cardNumber);
            Account account;
            account = res;
            JOptionPane.showMessageDialog(null, account.getCardNumber());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void main(String[] args) {
        new UserDetail();
    }
}
