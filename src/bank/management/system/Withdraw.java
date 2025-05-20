package bank.management.system;

import bank.management.system.constants.Background;
import bank.management.system.services.StringUtil;

import javax.swing.*;
import java.awt.event.ActionListener;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JLabel backgroundLabel, headingLabel, noticeLabel;
    JButton withdraw1500Button, withdraw1000Button, withdraw300Button, withdraw2000Button, withdraw500Button, withdraw5000Button, backButton, customWithdrawButton;

    String pinCode;

    Withdraw(String pinCode) {
        this.pinCode = pinCode;

        setLayout(null);
        setSize(Background.BACKGROUND_WIDTH, Background.BACKGROUND_HEIGHT);
        setLocation(0, 0);

        headingLabel = new JLabel("Nhập số tiền cần rút");
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("Arial", Font.BOLD, Background.HEADING_FONT_SIZE));
        headingLabel.setBounds(0, 180, Background.BACKGROUND_WIDTH, 35);
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headingLabel);

        noticeLabel = new JLabel("Ngân hàng sẽ thu phí chủ thẻ khi giao dịch tại ATM");
        noticeLabel.setForeground(Color.BLACK);
        noticeLabel.setFont(new Font("Arial", Font.BOLD, Background.DETAIL_FONT_SIZE));
        noticeLabel.setBounds(0, 230, Background.BACKGROUND_WIDTH, 35);
        noticeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(noticeLabel);

        withdraw1500Button = new JButton("1.500.000");
        withdraw1500Button.setForeground(Color.WHITE);
        withdraw1500Button.setBackground(Background.BUTTON_PRIMARY);
        withdraw1500Button.setBounds(Background.ATM_BUTTON_LEFT_START_X, Background.ATM_BUTTON_START_Y, 150, Background.ATM_BUTTON_HEIGHT);
        withdraw1500Button.addActionListener(this);
        add(withdraw1500Button);

        withdraw300Button = new JButton("300.000");
        withdraw300Button.setForeground(Color.WHITE);
        withdraw300Button.setBackground(Background.BUTTON_PRIMARY);
        withdraw300Button.setBounds(Background.ATM_BUTTON_RIGHT_START_X, Background.ATM_BUTTON_START_Y, 150, Background.ATM_BUTTON_HEIGHT);
        withdraw300Button.addActionListener(this);
        add(withdraw300Button);

        withdraw1000Button = new JButton("1.000.000");
        withdraw1000Button.setForeground(Color.WHITE);
        withdraw1000Button.setBackground(Background.BUTTON_PRIMARY);
        withdraw1000Button.setBounds(Background.ATM_BUTTON_LEFT_START_X, Background.getPositionY(Background.ATM_BUTTON_START_Y, 1), 150, Background.ATM_BUTTON_HEIGHT);
        withdraw1000Button.addActionListener(this);
        add(withdraw1000Button);

        withdraw2000Button = new JButton("2.000.000");
        withdraw2000Button.setForeground(Color.WHITE);
        withdraw2000Button.setBackground(Background.BUTTON_PRIMARY);
        withdraw2000Button.setBounds(Background.ATM_BUTTON_RIGHT_START_X, Background.getPositionY(Background.ATM_BUTTON_START_Y, 1), 150, Background.ATM_BUTTON_HEIGHT);
        withdraw2000Button.addActionListener(this);
        add(withdraw2000Button);

        withdraw500Button = new JButton("500.000");
        withdraw500Button.setForeground(Color.WHITE);
        withdraw500Button.setBackground(Background.BUTTON_PRIMARY);
        withdraw500Button.setBounds(Background.ATM_BUTTON_LEFT_START_X, Background.getPositionY(Background.ATM_BUTTON_START_Y, 2), 150, Background.ATM_BUTTON_HEIGHT);
        withdraw500Button.addActionListener(this);
        add(withdraw500Button);

        withdraw5000Button = new JButton("5.000.000");
        withdraw5000Button.setForeground(Color.WHITE);
        withdraw5000Button.setBackground(Background.BUTTON_PRIMARY);
        withdraw5000Button.setBounds(Background.ATM_BUTTON_RIGHT_START_X, Background.getPositionY(Background.ATM_BUTTON_START_Y, 2), 150, Background.ATM_BUTTON_HEIGHT);
        withdraw5000Button.addActionListener(this);
        add(withdraw5000Button);

        customWithdrawButton = new JButton("Số khác");
        customWithdrawButton.setForeground(Color.WHITE);
        customWithdrawButton.setBackground(Background.BUTTON_SUGGEST);
        customWithdrawButton.setBounds(Background.ATM_BUTTON_LEFT_START_X, Background.getPositionY(Background.ATM_BUTTON_START_Y, 3), 150, Background.ATM_BUTTON_HEIGHT);
        customWithdrawButton.addActionListener(this);
        add(customWithdrawButton);

        backButton = new JButton("Quay lại");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Background.BUTTON_WARNING);
        backButton.setBounds(Background.ATM_BUTTON_LEFT_START_X, Background.getPositionY(Background.ATM_BUTTON_START_Y, 3), 150, Background.ATM_BUTTON_HEIGHT);
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
        if (e.getSource() == backButton) {
            setVisible(false);
            new Home(this.pinCode);
        } else if (e.getSource() == customWithdrawButton) {
            setVisible(false);
            new CustomWithdraw(this.pinCode);
        } else {
            String rawAmount = ((JButton) e.getSource()).getText();
            String amount = StringUtil.parseStringToValue(rawAmount);

            Connector connector = new Connector();
            Date date = new Date();

            try {
                ResultSet resultSet = connector.statement.executeQuery("select * from bank where pin = '" + this.pinCode + "'");
                int balance = 0;

                while (resultSet.next()) {
                    if (resultSet.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Số dư không đủ để thực hiện giao dịch");
                    return;
                }

                connector.statement.executeUpdate("insert into bank values('" + this.pinCode + "','" + date + "', 'Withdraw', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "Vnđ " + amount + " Rút tiền thành công");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
