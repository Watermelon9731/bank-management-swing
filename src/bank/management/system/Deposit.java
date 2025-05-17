package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;

    JLabel backgroundLabel, amountLabel;
    TextField amountTextField;
    JButton depositButton, backButton;

    Deposit(String pin) {
        this.pin = pin;

        ImageIcon atmBackgroundRaw = new ImageIcon(ClassLoader.getSystemResource("images/backgrounds/atm.png"));
        Image atmImage = atmBackgroundRaw.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon backgroundImage = new ImageIcon(atmImage);

        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0,0,1550,830);
        add(backgroundLabel);

        amountLabel = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        amountLabel.setForeground(Color.WHITE);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        amountLabel.setBounds(460,180,400,35);
        backgroundLabel.add(amountLabel);

        amountTextField = new TextField();
        amountTextField.setBackground(new Color(65,125,128));
        amountTextField.setForeground(Color.WHITE);
        amountTextField.setBounds(460,230,320,25);
        amountTextField.setFont(new Font("Arial", Font.BOLD,22));
        backgroundLabel.add(amountTextField);

        depositButton = new JButton("DEPOSIT");
        depositButton.setBounds(700,362,150,35);
        depositButton.setBackground(new Color(65,125,128));
        depositButton.setForeground(Color.WHITE);
        depositButton.addActionListener(this);
        backgroundLabel.add(depositButton);

        backButton = new JButton("BACK");
        backButton.setBounds(700,406,150,35);
        backButton.setBackground(new Color(65,125,128));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        backgroundLabel.add(backButton);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = amountTextField.getText();
            Date date = new Date();

            if (e.getSource() == depositButton) {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                } else {
                    Connector connector = new Connector();
                    String addQuery = "insert into bank values('"+this.pin+"', '"+date+"', 'Deposit', '"+amount+"')";
                    connector.statement.executeUpdate(addQuery);
                    JOptionPane.showMessageDialog(null, "Deposited successfully '"+amount+"'");
                    new Home(this.pin);
                    setVisible(false);
                }
            } else if (e.getSource() == backButton) {
                setVisible(false);
                new Home(this.pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
