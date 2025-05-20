package bank.management.system;

import bank.management.system.constants.Background;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame implements ActionListener {
    String pinCode;
    JLabel bankIconLabel, backgroundLabel;

    JButton depositButton, cashWithdrawButton, pinChangeButton, balanceInquiryButton, exitButton;

    int bankIconWidth = 80, bankIconHeight = 80;

    int leftStartX = Background.ATM_BUTTON_LEFT_START_X;
    int rightStartX = Background.ATM_BUTTON_RIGHT_START_X;

    int buttonStartY = Background.ATM_BUTTON_START_Y;
    int buttonHeight = Background.ATM_BUTTON_HEIGHT;

    public int getPositionY(int level) {
        return Background.getPositionY(this.buttonStartY, level);
    }

    Home(String pinCode) {
        super("Bank Management System");
        this.pinCode = pinCode;

        setLayout(null);
        setSize(Background.BACKGROUND_WIDTH, Background.BACKGROUND_HEIGHT);
        setLocation(0, 0);

        ImageIcon bankIconRaw = new ImageIcon(ClassLoader.getSystemResource("images/icons/bank.png"));
        Image bankIconResizedImage = bankIconRaw.getImage().getScaledInstance(this.bankIconWidth, this.bankIconHeight, Image.SCALE_DEFAULT);
        ImageIcon bankIcon = new ImageIcon(bankIconResizedImage);

        bankIconLabel = new JLabel(bankIcon);
        bankIconLabel.setBounds(this.leftStartX + 180, 160, this.bankIconWidth, this.bankIconHeight);
        add(bankIconLabel);

        JLabel label = new JLabel("Xin vui lòng lựa chọn giao dịch");
        label.setBounds(0, 250, 840, 35);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        add(label);

        depositButton = new JButton("Nộp tiền");
        depositButton.setForeground(Color.WHITE);
        depositButton.setBackground(Background.BUTTON_PRIMARY);
        depositButton.setBounds(this.leftStartX, this.getPositionY(1), 150, this.buttonHeight);
        depositButton.addActionListener(this);
        add(depositButton);

        cashWithdrawButton = new JButton("Rút tiền");
        cashWithdrawButton.setForeground(Color.WHITE);
        cashWithdrawButton.setBackground(Background.BUTTON_PRIMARY);
        cashWithdrawButton.setBounds(this.rightStartX, this.getPositionY(1), 150, this.buttonHeight);
        cashWithdrawButton.addActionListener(this);
        add(cashWithdrawButton);

        pinChangeButton = new JButton("Đổi mã PIN");
        pinChangeButton.setForeground(Color.WHITE);
        pinChangeButton.setBackground(Background.BUTTON_PRIMARY);
        pinChangeButton.setBounds(this.rightStartX, this.getPositionY(2), 150, this.buttonHeight);
        pinChangeButton.addActionListener(this);
        add(pinChangeButton);

        balanceInquiryButton = new JButton("Xem số dư");
        balanceInquiryButton.setForeground(Color.WHITE);
        balanceInquiryButton.setBackground(Background.BUTTON_PRIMARY);
        balanceInquiryButton.setBounds(this.leftStartX, this.getPositionY(2), 150, this.buttonHeight);
        balanceInquiryButton.addActionListener(this);
        add(balanceInquiryButton);

        exitButton = new JButton("Hủy giao dịch");
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Background.BUTTON_WARNING);
        exitButton.setBounds(this.rightStartX, this.getPositionY(3), 150, this.buttonHeight);
        exitButton.addActionListener(this);
        add(exitButton);

        ImageIcon atmBackgroundRaw = new ImageIcon(ClassLoader.getSystemResource("images/backgrounds/atm-machine.png"));
        Image atmImage = atmBackgroundRaw.getImage().getScaledInstance(Background.BACKGROUND_WIDTH, Background.BACKGROUND_HEIGHT, Image.SCALE_DEFAULT);
        ImageIcon atmBackgroundImage = new ImageIcon(atmImage);

        backgroundLabel = new JLabel(atmBackgroundImage);
        backgroundLabel.setBounds(0, 0, Background.BACKGROUND_WIDTH, Background.BACKGROUND_HEIGHT);
        add(backgroundLabel);

        setVisible(true);
    }

    ;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            new Deposit(this.pinCode);
            setVisible(false);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == cashWithdrawButton) {
            new Withdraw(this.pinCode);
            setVisible(false);
        } else if (e.getSource() == balanceInquiryButton) {
            new BalanceInquiry(this.pinCode);
            setVisible(false);
        } else if (e.getSource() == pinChangeButton) {
            new Pin(this.pinCode);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Home("");
    }
}
