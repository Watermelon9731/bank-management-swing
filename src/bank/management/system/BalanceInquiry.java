package bank.management.system;

import bank.management.system.constants.Background;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceInquiry extends JFrame implements ActionListener {
    String pinCode;

    JLabel backgroundLabel, headingLabel ,balanceInquiryLabel;
    TextField balanceInquiryTextField;
    JButton depositButton, backButton;

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
        backButton.setBackground(new Color(65, 125, 128));
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
            Connector connector = new Connector();
            ResultSet resultSet = connector.statement.executeQuery("Select * from bank where pin_code = '" + pinCode + "'");
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        balanceInquiryLabel.setText("" + balance);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
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
