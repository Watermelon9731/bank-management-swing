package bank.management.system;

import bank.management.system.constants.Background;
import bank.management.system.controller.AccountController;
import bank.management.system.model.Account;
import bank.management.system.services.StringUtil;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BalanceInquiry extends JFrame implements ActionListener {
    String pinCode;
    JLabel backgroundLabel, headingLabel, balanceInquiryLabel;
    JButton backButton;

    BalanceInquiry(String pinCode) {
        this.pinCode = pinCode;

        setLayout(null);
        setSize(Background.BACKGROUND_WIDTH, Background.BACKGROUND_HEIGHT);
        setLocation(0, 0);

        headingLabel = new JLabel("Số dư tài khoản hiện tại");
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headingLabel.setBounds(0, 180, Background.BACKGROUND_WIDTH, 35);
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headingLabel);

        balanceInquiryLabel = new JLabel("");
        balanceInquiryLabel.setForeground(Color.BLACK);
        balanceInquiryLabel.setFont(new Font("Arial", Font.BOLD, 20));
        balanceInquiryLabel.setBounds(0, 230, Background.BACKGROUND_WIDTH, 40);
        balanceInquiryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(balanceInquiryLabel);

        backButton = new JButton("Quay lại");
        backButton.setBounds(Background.ATM_BUTTON_RIGHT_START_X, Background.ATM_BUTTON_START_Y + 52, 150, Background.ATM_BUTTON_HEIGHT);
        backButton.setBackground(Background.BUTTON_INFO);
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

        int balance = 0;
        try {
            balance += AccountController.getAccountBalance(this.pinCode);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        balanceInquiryLabel.setText(StringUtil.parseIntValueToFormatStringValue(balance) + " vnđ");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Home(this.pinCode);
    }

    public static void main(String[] args) {
        new BalanceInquiry("");
    }
}
