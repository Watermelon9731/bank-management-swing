package bank.management.system;

import bank.management.system.constants.Background;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.util.Date;

public class CustomWithdraw extends JFrame implements ActionListener {


    JLabel backgroundLabel, headingLabel, noticeLabel;
    JButton backButton, withdrawButton;
    TextField amountTextField;

    String pinCode;

    CustomWithdraw(String pinCode) {
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

        amountTextField = new TextField();
        amountTextField.setBackground(new Color(65, 125, 128));
        amountTextField.setBackground(Color.LIGHT_GRAY);
        amountTextField.setForeground(Color.BLACK);
        amountTextField.setBounds(Background.ATM_BUTTON_LEFT_START_X + 60, Background.ATM_BUTTON_START_Y, 320, 42);
        amountTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(amountTextField);

        withdrawButton = new JButton("Chuyển khoản");
        withdrawButton.setBounds(Background.ATM_BUTTON_RIGHT_START_X, Background.getPositionY(Background.ATM_BUTTON_START_Y, 2), 150, Background.ATM_BUTTON_HEIGHT);
        withdrawButton.setBackground(Background.BUTTON_PRIMARY);
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        backButton = new JButton("Quay lại");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Background.BUTTON_WARNING);
        backButton.setBounds(Background.ATM_BUTTON_RIGHT_START_X, Background.getPositionY(Background.ATM_BUTTON_START_Y, 3), 150, Background.ATM_BUTTON_HEIGHT);
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
        if (e.getSource() == withdrawButton) {
            try {
                String amount = amountTextField.getText();
                Date date = new Date();
                if (amountTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền bạn cần rút");
                } else {
                    try {
                        Integer.parseInt(amount);
                        Connector connector = new Connector();
                        ResultSet resultSet = connector.statement.executeQuery("select * from bank where pin = '" + pinCode + "'");

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

                        connector.statement.executeUpdate("insert into bank values('" + this.pinCode + "', '" + date + "', 'Withdraw', '" + amount + "' )");
                        JOptionPane.showMessageDialog(null, "Vnđ. " + amount + " Rút tiền thành công");
                        setVisible(false);
                        new Home(this.pinCode);
                    } catch (NumberFormatException numberException) {
                        JOptionPane.showMessageDialog(null, "Giá trị rút là số");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == backButton) {
            setVisible(false);
            new Home(this.pinCode);
        }
    }

    public static void main(String[] args) {
        new CustomWithdraw("");
    }
}



