package bank.management.system;

import bank.management.system.constants.Background;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pinCode;

    JLabel backgroundLabel, amountLabel;
    TextField amountTextField;
    JButton depositButton, backButton;

    Deposit(String pinCode) {
        this.pinCode = pinCode;

        setLayout(null);
        setSize(Background.BACKGROUND_WIDTH, Background.BACKGROUND_HEIGHT);
        setLocation(0, 0);

        amountLabel = new JLabel("Nhập số tiền muốn nộp");
        amountLabel.setForeground(Color.BLACK);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        amountLabel.setBounds(0, 180, Background.BACKGROUND_WIDTH, 35);
        amountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(amountLabel);

        amountTextField = new TextField();
        amountTextField.setBackground(new Color(65, 125, 128));
        amountTextField.setBackground(Color.LIGHT_GRAY);
        amountTextField.setForeground(Color.BLACK);
        amountTextField.setBounds(Background.ATM_BUTTON_LEFT_START_X + 60, 230, 320, 42);
        amountTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(amountTextField);

        depositButton = new JButton("Nộp tiền");
        depositButton.setBounds(Background.ATM_BUTTON_RIGHT_START_X, Background.ATM_BUTTON_START_Y, 150, Background.ATM_BUTTON_HEIGHT);
        depositButton.setBackground(Background.BUTTON_PRIMARY);
        depositButton.setForeground(Color.WHITE);
        depositButton.addActionListener(this);
        add(depositButton);

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = amountTextField.getText();
            Date date = new Date();

            if (e.getSource() == depositButton) {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền muốn nộp");
                } else {
                    try {
                        Float.parseFloat(amount);
                        Connector connector = new Connector();
                        String addQuery = "insert into bank values('" + this.pinCode + "', '" + date + "', 'Deposit', '" + amount + "')";
                        connector.statement.executeUpdate(addQuery);
                        JOptionPane.showMessageDialog(null, "Nạp tiền thành công '" + amount + "'");
                        new Home(this.pinCode);
                        setVisible(false);
                    } catch (NumberFormatException numberException) {
                        JOptionPane.showMessageDialog(null, "Giá trị tiền nộp là số");
                    }

                }
            } else if (e.getSource() == backButton) {
                setVisible(false);
                new Home(this.pinCode);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
