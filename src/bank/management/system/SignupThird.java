package bank.management.system;

import bank.management.system.constants.Background;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThird extends JFrame implements ActionListener {
    JLabel bankIconLabel, headingLabel, pageNumberLabel, titleLabel, accountTypeLabel, serviceRequiredLabel;
    JTextField citizenIdentificationTextField, placeOfIssueTextField;
    JDateChooser dateOfIssueChooser;
    JRadioButton savingAccountRadioButton, fixedDepositRadioButton, currentAccountRadioButton, recurringDepositAccountRadioButton;
    JCheckBox atmCardCheckBox, internetBankingCheckBox, mobileBankingCheckBox, emailAlertCheckBox, chequeBookCheckbox, eStatementCheckbox, confirmCheckbox;

    JButton cancelButton, submitButton;

    String formId;

    int lineHeight = 40;
    int formStartY = 160;
    int formStartX = 45;
    int formLabelWidth = 300;
    int formTextFieldWidth = 300;
    int formTextFieldStartX = formStartX + formLabelWidth;
    int formRadioButtonWidth = 150;

    public int getPositionY(int level) {
        return this.formStartY + lineHeight * level;
    }

    SignupThird(String formId) {
        super("Application Form");
        this.formId = formId;

        ImageIcon bankIconRaw = new ImageIcon(ClassLoader.getSystemResource("images/icons/bank.png"));
        Image bankIconResizedImage = bankIconRaw.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankIcon = new ImageIcon(bankIconResizedImage);

        bankIconLabel = new JLabel(bankIcon);
        bankIconLabel.setBounds(25, 10, 100, 100);
        add(bankIconLabel);

        headingLabel = new JLabel("Application Form No." + this.formId);
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headingLabel.setBounds(150, 30, 600, 40);
        add(headingLabel);

        pageNumberLabel = new JLabel("Account Information - Page 3");
        pageNumberLabel.setForeground(Color.BLACK);
        pageNumberLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pageNumberLabel.setBounds(150, 70, 600, 40);
        add(pageNumberLabel);

        // Account field
        accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setForeground(Color.BLACK);
        accountTypeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        accountTypeLabel.setBounds(this.formStartX, this.formStartY, this.formLabelWidth, this.lineHeight);
        add(accountTypeLabel);

        savingAccountRadioButton = new JRadioButton("Saving Account");
        savingAccountRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        savingAccountRadioButton.setBackground(new Color(215, 252, 252));
        savingAccountRadioButton.setBounds(this.formStartX, this.getPositionY(1), this.formTextFieldWidth, this.lineHeight);
        add(savingAccountRadioButton);

        fixedDepositRadioButton = new JRadioButton("Fixed Deposit Account");
        fixedDepositRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        fixedDepositRadioButton.setBackground(new Color(215, 252, 252));
        fixedDepositRadioButton.setBounds(this.formStartX + this.formTextFieldWidth, this.getPositionY(1), this.formTextFieldWidth, this.lineHeight);
        add(fixedDepositRadioButton);

        currentAccountRadioButton = new JRadioButton("Current Account");
        currentAccountRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        currentAccountRadioButton.setBackground(new Color(215, 252, 252));
        currentAccountRadioButton.setBounds(this.formStartX, this.getPositionY(2), this.formTextFieldWidth, this.lineHeight);
        add(currentAccountRadioButton);

        recurringDepositAccountRadioButton = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccountRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        recurringDepositAccountRadioButton.setBackground(new Color(215, 252, 252));
        recurringDepositAccountRadioButton.setBounds(this.formStartX + this.formTextFieldWidth, this.getPositionY(2), this.formTextFieldWidth, this.lineHeight);
        add(recurringDepositAccountRadioButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(savingAccountRadioButton);
        buttonGroup.add(fixedDepositRadioButton);
        buttonGroup.add(currentAccountRadioButton);
        buttonGroup.add(recurringDepositAccountRadioButton);

        // Service Required field
        serviceRequiredLabel = new JLabel("Service Required");
        serviceRequiredLabel.setForeground(Color.BLACK);
        serviceRequiredLabel.setFont(new Font("Arial", Font.BOLD, 22));
        serviceRequiredLabel.setBounds(this.formStartX, this.getPositionY(3), this.formLabelWidth, this.lineHeight);
        add(serviceRequiredLabel);

        atmCardCheckBox = new JCheckBox("ATM Card", false);
        atmCardCheckBox.setBackground(new Color(215, 252, 252));
        atmCardCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        atmCardCheckBox.setBounds(this.formStartX, this.getPositionY(4), 200, this.lineHeight);
        add(atmCardCheckBox);

        internetBankingCheckBox = new JCheckBox("Internet Banking", false);
        internetBankingCheckBox.setBackground(new Color(215, 252, 252));
        internetBankingCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        internetBankingCheckBox.setBounds(this.formStartX + 200, this.getPositionY(4), 200, this.lineHeight);
        add(internetBankingCheckBox);

        mobileBankingCheckBox = new JCheckBox("Mobile Banking", false);
        mobileBankingCheckBox.setBackground(new Color(215, 252, 252));
        mobileBankingCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        mobileBankingCheckBox.setBounds(this.formStartX + 400, this.getPositionY(4), 200, this.lineHeight);
        add(mobileBankingCheckBox);

        emailAlertCheckBox = new JCheckBox("Email Alert", false);
        emailAlertCheckBox.setBackground(new Color(215, 252, 252));
        emailAlertCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        emailAlertCheckBox.setBounds(this.formStartX, this.getPositionY(5), 200, this.lineHeight);
        add(emailAlertCheckBox);

        chequeBookCheckbox = new JCheckBox("E-Statement", false);
        chequeBookCheckbox.setBackground(new Color(215, 252, 252));
        chequeBookCheckbox.setFont(new Font("Arial", Font.BOLD, 16));
        chequeBookCheckbox.setBounds(this.formStartX + 200, this.getPositionY(5), 200, this.lineHeight);
        add(chequeBookCheckbox);

        eStatementCheckbox = new JCheckBox("E-Statement", true);
        eStatementCheckbox.setBackground(new Color(215, 252, 252));
        eStatementCheckbox.setFont(new Font("Arial", Font.BOLD, 16));
        eStatementCheckbox.setBounds(this.formStartX + 400, this.getPositionY(5), 200, this.lineHeight);
        add(eStatementCheckbox);

        confirmCheckbox = new JCheckBox("I here by declare that the above entered details correct to the best of my knowledge.", true);
        confirmCheckbox.setBackground(new Color(215, 252, 252));
        confirmCheckbox.setFont(new Font("Arial", Font.BOLD, 16));
        confirmCheckbox.setBounds(this.formStartX, this.getPositionY(6), 755, this.lineHeight);
        add(confirmCheckbox);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(this.formStartX, this.getPositionY(8) - 20, 100, this.lineHeight);
        cancelButton.addActionListener(this);
        add(cancelButton);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(Color.BLUE);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(this.formStartX + 130, this.getPositionY(8) - 20, 100, this.lineHeight);
        submitButton.addActionListener(this);
        add(submitButton);

        getContentPane().setBackground(Background.BACKGROUND_COLOR);
        setLayout(null);
        setSize(800, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionType = null;
        if (savingAccountRadioButton.isSelected()) {
            actionType = "Saving Account";
        } else if (fixedDepositRadioButton.isSelected()) {
            actionType = "Fixed Deposit Account";
        } else if (currentAccountRadioButton.isSelected()) {
            actionType = "Current Account";
        } else if (recurringDepositAccountRadioButton.isSelected()) {
            actionType = "Recurring Deposit Account";
        }

        Random randomNumber = new Random();
        long sevenDigitsNumber = (randomNumber.nextLong() % 90000000L) + 1409963000000000L;
        String cardNumber = "" + Math.abs(sevenDigitsNumber);

        long threeDigitsNumber = (randomNumber.nextLong() % 9000L)+ 1000L;
        String pin = "" + Math.abs(threeDigitsNumber);

        String services = "";
        if(atmCardCheckBox.isSelected()){
            services = services+"ATM Card ";
        } else if (internetBankingCheckBox.isSelected()) {
            services = services+"Internet Banking";
        } else if (mobileBankingCheckBox.isSelected()) {
            services = services+"Mobile Banking";
        } else if (emailAlertCheckBox.isSelected()) {
            services = services+"Email Alerts";
        } else if (chequeBookCheckbox.isSelected()) {
            services = services+"Cheque Book";
        } else if (eStatementCheckbox.isSelected()) {
            services = services+"E-Statement";
        }

        try {
            if (e.getSource()== submitButton){
                if (actionType.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }else {
                    Connector connector = new Connector();

                    String addInformationQuery = "insert into signupthree values('"+this.formId+"', '"+actionType+"','"+cardNumber+"','"+pin+"','"+services+"')";

                    String loginQuery = "insert into login values('"+this.formId+"','"+cardNumber+"','"+pin+"')";
                    connector.statement.executeUpdate(addInformationQuery);

                    connector.statement.executeUpdate(loginQuery);
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardNumber+" Pin : "+pin );
                    new Deposit(pin);
                    setVisible(false);
                }
            } else if (e.getSource() == cancelButton) {
                System.exit(0);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupThird("");
    }
}
