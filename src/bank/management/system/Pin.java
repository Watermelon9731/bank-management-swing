package bank.management.system;

import bank.management.system.constants.Background;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JLabel backgroundLabel, headingLabel, newPinLabel, confirmPinLabel;
    JButton confirmButton, backButton;
    JPasswordField pinCodePasswordField, pinCodeConfirmPasswordField;
    String pinCode;

    Pin(String pinCode) {
        this.pinCode = pinCode;

        setLayout(null);
        setSize(Background.BACKGROUND_WIDTH, Background.BACKGROUND_HEIGHT);
        setLocation(0, 0);

        headingLabel = new JLabel("Đổi mã PIN");
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("Arial", Font.BOLD, Background.HEADING_FONT_SIZE));
        headingLabel.setBounds(0, 180, Background.BACKGROUND_WIDTH, 35);
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headingLabel);


        newPinLabel = new JLabel("Mã PIN mới: ");
        newPinLabel.setForeground(Color.BLACK);
        newPinLabel.setFont(new Font("System", Font.BOLD, 16));
        newPinLabel.setBounds(Background.ATM_BUTTON_LEFT_START_X + 20, 230, 150, Background.ATM_BUTTON_HEIGHT);
        add(newPinLabel);

        pinCodePasswordField = new JPasswordField();
        pinCodePasswordField.setBackground(Color.LIGHT_GRAY);
        pinCodePasswordField.setForeground(Color.BLACK);
        pinCodePasswordField.setBounds(Background.ATM_BUTTON_LEFT_START_X + 170, 230, 180, Background.ATM_BUTTON_HEIGHT);
        pinCodePasswordField.setFont(new Font("Arial", Font.BOLD, 22));
        add(pinCodePasswordField);

        confirmPinLabel = new JLabel("Xác nhận mã PIN: ");
        confirmPinLabel.setForeground(Color.BLACK);
        confirmPinLabel.setFont(new Font("System", Font.BOLD, 16));
        confirmPinLabel.setBounds(Background.ATM_BUTTON_LEFT_START_X + 20, 270, 150, Background.ATM_BUTTON_HEIGHT);
        add(confirmPinLabel);

        pinCodeConfirmPasswordField = new JPasswordField();
        pinCodeConfirmPasswordField.setBackground(Color.LIGHT_GRAY);
        pinCodeConfirmPasswordField.setForeground(Color.BLACK);
        pinCodeConfirmPasswordField.setBounds(Background.ATM_BUTTON_LEFT_START_X + 170, 270, 180, Background.ATM_BUTTON_HEIGHT);
        pinCodeConfirmPasswordField.setFont(new Font("Arial", Font.BOLD, Background.ATM_BUTTON_HEIGHT));
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

        try {

            String newPin = pinCodePasswordField.getText();
            String confirmPin = pinCodeConfirmPasswordField.getText();

            if (!newPin.equals(confirmPin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if (e.getSource() == confirmButton) {
                if (pinCodePasswordField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (pinCodeConfirmPasswordField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                }

                Connector connector = new Connector();
                String updateBankQuery = "update bank set pin_code = '" + newPin + "' where pin_code = '" + pinCode + "'";
                String updateLoginQuery = "update login set pin_code = '" + newPin + "' where pin = '" + pinCode + "'";
                String updateSignupThird = "update signupthree set pin_code = '" + newPin + "' where pin_code = '" + pinCode + "'";

                connector.statement.executeUpdate(updateBankQuery);
                connector.statement.executeUpdate(updateLoginQuery);
                connector.statement.executeUpdate(updateSignupThird);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Home(this.pinCode);

            } else if (e.getSource() == backButton) {
                new Home(this.pinCode);
                setVisible(false);
            }


        } catch (Exception E) {
            E.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new Pin("");
    }
}