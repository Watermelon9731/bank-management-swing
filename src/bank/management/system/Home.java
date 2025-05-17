package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame implements ActionListener {
    String pinCode;
    JLabel backgroundLabel;

    JButton depositButton, cashWithdrawButton, fastCashButton, pinChangeButton, balanceInquiryButton, exitButton;

    Home(String pinCode) {
        this.pinCode = pinCode;
        ImageIcon atmBackgroundRaw = new ImageIcon(ClassLoader.getSystemResource("images/backgrounds/atm.png"));
        Image atmImage = atmBackgroundRaw.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon backgroundImage = new ImageIcon(atmImage);

        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0,0,1550,830);
        add(backgroundLabel);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(430,180,700,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,28));
        backgroundLabel.add(label);

        depositButton = new JButton("DEPOSIT");
        depositButton.setForeground(Color.WHITE);
        depositButton.setBackground(new Color(65,125,128));
        depositButton.setBounds(410,274,150,35);
        depositButton.addActionListener(this);
        backgroundLabel.add(depositButton);

        cashWithdrawButton = new JButton("CASH WITHDRAW");
        cashWithdrawButton.setForeground(Color.WHITE);
        cashWithdrawButton.setBackground(new Color(65,125,128));
        cashWithdrawButton.setBounds(700,274,150,35);
        cashWithdrawButton.addActionListener(this);
        backgroundLabel.add(cashWithdrawButton);

        fastCashButton = new JButton("FAST CASH");
        fastCashButton.setForeground(Color.WHITE);
        fastCashButton.setBackground(new Color(65,125,128));
        fastCashButton.setBounds(410,318,150,35);
        fastCashButton.addActionListener(this);
        backgroundLabel.add(fastCashButton);

        pinChangeButton = new JButton("PIN CHANGE");
        pinChangeButton.setForeground(Color.WHITE);
        pinChangeButton.setBackground(new Color(65,125,128));
        pinChangeButton.setBounds(410,362,150,35);
        pinChangeButton.addActionListener(this);
        backgroundLabel.add(pinChangeButton);

        balanceInquiryButton = new JButton("BALANCE INQUIRY");
        balanceInquiryButton.setForeground(Color.WHITE);
        balanceInquiryButton.setBackground(new Color(65,125,128));
        balanceInquiryButton.setBounds(700,362,150,35);
        balanceInquiryButton.addActionListener(this);
        backgroundLabel.add(balanceInquiryButton);

        exitButton = new JButton("EXIT");
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(65,125,128));
        exitButton.setBounds(700,406,150,35);
        exitButton.addActionListener(this);
        backgroundLabel.add(exitButton);

        setLayout(null);
        setSize(1500,1080);
        setLocation(0,0);
        setVisible(true);
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            new Deposit(this.pinCode);
            setVisible(false);
        }else if (e.getSource() == exitButton){
            System.exit(0);
        } else if (e.getSource() == cashWithdrawButton) {
            new Withdraw(this.pinCode);
            setVisible(false);
        } else if (e.getSource() == balanceInquiryButton) {
            new BalanceInquiry(this.pinCode);
            setVisible(false); 
        } else if (e.getSource() == fastCashButton) {
            new FastCash(this.pinCode);
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
