package bank.management.system;

import bank.management.system.constants.Background;
import bank.management.system.services.HashUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JLabel backgroundLabel, headingLabel, cardNumberLabel, oldPinCodeLabel, newPinLabel, confirmPinLabel;
    JButton confirmButton, backButton;
    JTextField cardNumberTextField;
    JPasswordField oldPinCodePasswordField, pinCodePasswordField, pinCodeConfirmPasswordField;
    String pinCode;

    int formStartY = 200;

    Pin(String pinCode) {
        this.pinCode = pinCode;

        setLayout(null);
        setSize(Background.BACKGROUND_WIDTH, Background.BACKGROUND_HEIGHT);
        setLocation(0, 0);

        headingLabel = new JLabel("Đổi mã PIN");
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("Arial", Font.BOLD, Background.HEADING_FONT_SIZE));
        headingLabel.setBounds(0, 160, Background.BACKGROUND_WIDTH, 35);
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headingLabel);

        cardNumberLabel = new JLabel("Số thẻ: ");
        cardNumberLabel.setForeground(Color.BLACK);
        cardNumberLabel.setFont(new Font("System", Font.BOLD, 16));
        cardNumberLabel.setBounds(Background.ATM_BUTTON_LEFT_START_X + 20, this.formStartY, 150, Background.ATM_BUTTON_HEIGHT);
        add(cardNumberLabel);

        cardNumberTextField = new JTextField();
        cardNumberTextField.setBackground(Color.LIGHT_GRAY);
        cardNumberTextField.setForeground(Color.BLACK);
        cardNumberTextField.setBounds(Background.ATM_BUTTON_LEFT_START_X + 170, this.formStartY, 180, Background.ATM_BUTTON_HEIGHT);
        cardNumberTextField.setFont(new Font("Arial", Font.BOLD, 16));
        add(cardNumberTextField);

        oldPinCodeLabel = new JLabel("Mã PIN: ");
        oldPinCodeLabel.setForeground(Color.BLACK);
        oldPinCodeLabel.setFont(new Font("System", Font.BOLD, 16));
        oldPinCodeLabel.setBounds(Background.ATM_BUTTON_LEFT_START_X + 20, Background.getPositionY(this.formStartY, 1), 150, Background.ATM_BUTTON_HEIGHT);
        add(oldPinCodeLabel);

        oldPinCodePasswordField = new JPasswordField();
        oldPinCodePasswordField.setBackground(Color.LIGHT_GRAY);
        oldPinCodePasswordField.setForeground(Color.BLACK);
        oldPinCodePasswordField.setBounds(Background.ATM_BUTTON_LEFT_START_X + 170, Background.getPositionY(this.formStartY, 1), 180, Background.ATM_BUTTON_HEIGHT);
        oldPinCodePasswordField.setFont(new Font("Arial", Font.BOLD, 16));
        add(oldPinCodePasswordField);

        newPinLabel = new JLabel("Mã PIN mới: ");
        newPinLabel.setForeground(Color.BLACK);
        newPinLabel.setFont(new Font("System", Font.BOLD, 16));
        newPinLabel.setBounds(Background.ATM_BUTTON_LEFT_START_X + 20, Background.getPositionY(this.formStartY, 2), 150, Background.ATM_BUTTON_HEIGHT);
        add(newPinLabel);

        pinCodePasswordField = new JPasswordField();
        pinCodePasswordField.setBackground(Color.LIGHT_GRAY);
        pinCodePasswordField.setForeground(Color.BLACK);
        pinCodePasswordField.setBounds(Background.ATM_BUTTON_LEFT_START_X + 170, Background.getPositionY(this.formStartY, 2), 180, Background.ATM_BUTTON_HEIGHT);
        pinCodePasswordField.setFont(new Font("Arial", Font.BOLD, 16));
        add(pinCodePasswordField);

        confirmPinLabel = new JLabel("Xác nhận mã PIN: ");
        confirmPinLabel.setForeground(Color.BLACK);
        confirmPinLabel.setFont(new Font("System", Font.BOLD, 16));
        confirmPinLabel.setBounds(Background.ATM_BUTTON_LEFT_START_X + 20, Background.getPositionY(this.formStartY, 3), 150, Background.ATM_BUTTON_HEIGHT);
        add(confirmPinLabel);

        pinCodeConfirmPasswordField = new JPasswordField();
        pinCodeConfirmPasswordField.setBackground(Color.LIGHT_GRAY);
        pinCodeConfirmPasswordField.setForeground(Color.BLACK);
        pinCodeConfirmPasswordField.setBounds(Background.ATM_BUTTON_LEFT_START_X + 170, Background.getPositionY(this.formStartY, 3), 180, Background.ATM_BUTTON_HEIGHT);
        pinCodeConfirmPasswordField.setFont(new Font("Arial", Font.BOLD, 16));
        add(pinCodeConfirmPasswordField);


        confirmButton = new JButton("Đổi mã PIN");
        confirmButton.setBounds(Background.ATM_BUTTON_RIGHT_START_X, Background.getPositionY(Background.ATM_BUTTON_START_Y, 2), 150, Background.ATM_BUTTON_HEIGHT);
        confirmButton.setBackground(Background.BUTTON_PRIMARY);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.addActionListener(this);
        add(confirmButton);

        backButton = new JButton("Quay lại");
        backButton.setBounds(Background.ATM_BUTTON_RIGHT_START_X, Background.getPositionY(Background.ATM_BUTTON_START_Y, 3), 150, Background.ATM_BUTTON_HEIGHT);
        backButton.setBackground(Background.BUTTON_WARNING);
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
        if (e.getSource() == confirmButton) {
            if (cardNumberTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số thẻ");
                return;
            } else if (oldPinCodePasswordField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu hiện tại");
                return;
            } else if (pinCodePasswordField.getText().equals("") || pinCodeConfirmPasswordField.getText().length() != 4) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu mới");
                return;
            } else if (pinCodeConfirmPasswordField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng xác nhận mật khẩu");
                return;
            }

            String cardNumber = cardNumberTextField.getText();

            String oldPinCode = oldPinCodePasswordField.getText();
            String oldPinCodeHash = HashUtil.hashSHA256(oldPinCode + cardNumber);

            String newPinCode = pinCodePasswordField.getText();
            String confirmPinCode = pinCodeConfirmPasswordField.getText();

            String newPinCodeHash = HashUtil.hashSHA256(newPinCode + cardNumber);

            if (!oldPinCodeHash.equals(this.pinCode)) {
                JOptionPane.showMessageDialog(null, "Số thẻ hoặc mã PIN không đúng");
                return;
            } else if (newPinCodeHash.equals(this.pinCode)) {
                JOptionPane.showMessageDialog(null, "Mật khẩu mới không được trùng với mật khẩu cũ");
                return;
            } else if (!newPinCode.equals(confirmPinCode)) {
                JOptionPane.showMessageDialog(null, "Mã PIN mới xác nhận không chính xác");
                return;
            }

            try {
                Connector connector = new Connector();

                String updateBankQuery = "update bank set pin = '" + newPinCodeHash + "' where pin = '" + this.pinCode + "'";

                String updateLoginQuery = "update login set pin = '" + newPinCodeHash + "' where pin = '" + this.pinCode + "'";

                String updateSignupThird = "update signup_third set pin = '" + newPinCodeHash + "' where pin = '" + this.pinCode + "'";

                connector.statement.executeUpdate(updateBankQuery);
                connector.statement.executeUpdate(updateLoginQuery);
                connector.statement.executeUpdate(updateSignupThird);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Home(this.pinCode);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == backButton) {
            setVisible(false);
            new Home(this.pinCode);
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}