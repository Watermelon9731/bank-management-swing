package bank.management.system;

import bank.management.system.constants.Background;
import bank.management.system.services.HashUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.security.SecureRandom;

public class SignupThird extends JFrame implements ActionListener {
    JLabel bankIconLabel, headingLabel, pageNumberLabel, titleLabel, accountTypeLabel, serviceRequiredLabel, backgroundImageLabel;
    JRadioButton savingAccountRadioButton, fixedDepositRadioButton, currentAccountRadioButton, recurringDepositAccountRadioButton;
    JCheckBox atmCardCheckBox, internetBankingCheckBox, mobileBankingCheckBox, emailAlertCheckBox, chequeBookCheckbox, eStatementCheckbox, confirmCheckbox;

    JButton backButton, cancelButton, submitButton;

    String formId, citizenId;

    int lineHeight = 40;
    int formStartY = 160;
    int formStartX = 45;
    int formLabelWidth = 300;
    int formTextFieldWidth = 300;

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

        headingLabel = new JLabel("Đơn đăng ký Số." + this.formId);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headingLabel.setBounds(150, 30, 600, 40);
        add(headingLabel);

        pageNumberLabel = new JLabel("Thông tin tài khoản - Page 3");
        pageNumberLabel.setForeground(Color.WHITE);
        pageNumberLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pageNumberLabel.setBounds(150, 70, 600, 40);
        add(pageNumberLabel);

        // Account field
        accountTypeLabel = new JLabel("Loại tài khoản");
        accountTypeLabel.setForeground(Color.WHITE);
        accountTypeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        accountTypeLabel.setBounds(this.formStartX, this.formStartY, this.formLabelWidth, this.lineHeight);
        add(accountTypeLabel);

        savingAccountRadioButton = new JRadioButton("Tài khoản tiết kiệm");
        savingAccountRadioButton.setOpaque(false);
        savingAccountRadioButton.setForeground(Color.WHITE);
        savingAccountRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        savingAccountRadioButton.setBounds(this.formStartX, this.getPositionY(1), this.formTextFieldWidth, this.lineHeight);
        add(savingAccountRadioButton);

        fixedDepositRadioButton = new JRadioButton("Tài khoản tiền gửi có kỳ hạn");
        fixedDepositRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        fixedDepositRadioButton.setOpaque(false);
        fixedDepositRadioButton.setForeground(Color.WHITE);
        fixedDepositRadioButton.setBounds(this.formStartX + this.formTextFieldWidth, this.getPositionY(1), this.formTextFieldWidth, this.lineHeight);
        add(fixedDepositRadioButton);

        currentAccountRadioButton = new JRadioButton("Tài khoản vãng lai");
        currentAccountRadioButton.setOpaque(false);
        currentAccountRadioButton.setForeground(Color.WHITE);
        currentAccountRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        currentAccountRadioButton.setBounds(this.formStartX, this.getPositionY(2), this.formTextFieldWidth, this.lineHeight);
        add(currentAccountRadioButton);

        recurringDepositAccountRadioButton = new JRadioButton("Tài khoản tiền gửi định kỳ");
        recurringDepositAccountRadioButton.setOpaque(false);
        recurringDepositAccountRadioButton.setForeground(Color.WHITE);
        recurringDepositAccountRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        recurringDepositAccountRadioButton.setBounds(this.formStartX + this.formTextFieldWidth, this.getPositionY(2), this.formTextFieldWidth, this.lineHeight);
        add(recurringDepositAccountRadioButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(savingAccountRadioButton);
        buttonGroup.add(fixedDepositRadioButton);
        buttonGroup.add(currentAccountRadioButton);
        buttonGroup.add(recurringDepositAccountRadioButton);

        // Service Required field
        serviceRequiredLabel = new JLabel("Đăng ký dịch vụ");
        serviceRequiredLabel.setForeground(Color.WHITE);
        serviceRequiredLabel.setFont(new Font("Arial", Font.BOLD, 22));
        serviceRequiredLabel.setBounds(this.formStartX, this.getPositionY(3), this.formLabelWidth, this.lineHeight);
        add(serviceRequiredLabel);

        atmCardCheckBox = new JCheckBox("Thẻ ATM", false);
        atmCardCheckBox.setOpaque(false);
        atmCardCheckBox.setForeground(Color.WHITE);
        atmCardCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        atmCardCheckBox.setBounds(this.formStartX, this.getPositionY(4), 200, this.lineHeight);
        add(atmCardCheckBox);

        internetBankingCheckBox = new JCheckBox("Internet Banking", false);
        internetBankingCheckBox.setOpaque(false);
        internetBankingCheckBox.setForeground(Color.WHITE);
        internetBankingCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        internetBankingCheckBox.setBounds(this.formStartX + 200, this.getPositionY(4), 200, this.lineHeight);
        add(internetBankingCheckBox);

        mobileBankingCheckBox = new JCheckBox("Mobile Banking", false);
        mobileBankingCheckBox.setOpaque(false);
        mobileBankingCheckBox.setForeground(Color.WHITE);
        mobileBankingCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        mobileBankingCheckBox.setBounds(this.formStartX + 400, this.getPositionY(4), 200, this.lineHeight);
        add(mobileBankingCheckBox);

        emailAlertCheckBox = new JCheckBox("Thông báo qua Email", false);
        emailAlertCheckBox.setOpaque(false);
        emailAlertCheckBox.setForeground(Color.WHITE);
        emailAlertCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        emailAlertCheckBox.setBounds(this.formStartX, this.getPositionY(5), 200, this.lineHeight);
        add(emailAlertCheckBox);

        chequeBookCheckbox = new JCheckBox("Sổ séc", false);
        chequeBookCheckbox.setOpaque(false);
        chequeBookCheckbox.setForeground(Color.WHITE);
        chequeBookCheckbox.setFont(new Font("Arial", Font.BOLD, 16));
        chequeBookCheckbox.setBounds(this.formStartX + 200, this.getPositionY(5), 200, this.lineHeight);
        add(chequeBookCheckbox);

        eStatementCheckbox = new JCheckBox("Sao kê điện tử", false);
        eStatementCheckbox.setOpaque(false);
        eStatementCheckbox.setForeground(Color.WHITE);
        eStatementCheckbox.setFont(new Font("Arial", Font.BOLD, 16));
        eStatementCheckbox.setBounds(this.formStartX + 400, this.getPositionY(5), 200, this.lineHeight);
        add(eStatementCheckbox);

        confirmCheckbox = new JCheckBox("<html><div style='width:500px;'>Tôi xin cam đoan rằng mọi thông tin được điền đều chính xác và chịu trách nhiệm trước pháp luật về nội dung trên.</div></html>", false);
        confirmCheckbox.setOpaque(false);
        confirmCheckbox.setForeground(Color.WHITE);
        confirmCheckbox.setFont(new Font("Arial", Font.BOLD, 16));
        confirmCheckbox.setBounds(this.formStartX, this.getPositionY(6), 755, this.lineHeight);
        add(confirmCheckbox);

        backButton = new JButton("Quay lại");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(Background.BUTTON_INFO);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(this.formStartX, this.getPositionY(8) - 20, 100, this.lineHeight);
        backButton.addActionListener(this);
        add(backButton);

        cancelButton = new JButton("Hủy");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 16));
        cancelButton.setBackground(Background.BUTTON_WARNING);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(this.formStartX + 130, this.getPositionY(8) - 20, 100, this.lineHeight);
        cancelButton.addActionListener(this);
        add(cancelButton);

        submitButton = new JButton("Tạo tài khoản");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBackground(Background.BUTTON_PRIMARY);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(this.formStartX + 260, this.getPositionY(8) - 20, 150, this.lineHeight);
        submitButton.addActionListener(this);
        add(submitButton);

        ImageIcon backgroundRaw = new ImageIcon(ClassLoader.getSystemResource("images/backgrounds/signup.png"));
        Image backgroundResizedImage = backgroundRaw.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon backgroundImage = new ImageIcon(backgroundResizedImage);
        backgroundImageLabel = new JLabel(backgroundImage);
        backgroundImageLabel.setBounds(0, 0, 800, 800);
        add(backgroundImageLabel);

        setLayout(null);
        setSize(800, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionType = "";
        if (savingAccountRadioButton.isSelected()) {
            actionType = "Saving Account";
        } else if (fixedDepositRadioButton.isSelected()) {
            actionType = "Fixed Deposit Account";
        } else if (currentAccountRadioButton.isSelected()) {
            actionType = "Current Account";
        } else if (recurringDepositAccountRadioButton.isSelected()) {
            actionType = "Recurring Deposit Account";
        }

        SecureRandom randomNumber = new SecureRandom();
        long elevenDigitsNumber = 1_000_000_0000L + (Math.abs(randomNumber.nextLong()) % 9_000_000_0000L);

        String cardNumber = "" + Math.abs(elevenDigitsNumber);

        long threeDigitsNumber = (randomNumber.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(threeDigitsNumber);
        String pinCode = HashUtil.hashSHA256(pin + cardNumber);

        String services = "";
        if (atmCardCheckBox.isSelected()) {
            services = services + "ATM Card ";
        } else if (internetBankingCheckBox.isSelected()) {
            services = services + "Internet Banking";
        } else if (mobileBankingCheckBox.isSelected()) {
            services = services + "Mobile Banking";
        } else if (emailAlertCheckBox.isSelected()) {
            services = services + "Email Alerts";
        } else if (chequeBookCheckbox.isSelected()) {
            services = services + "Cheque Book";
        } else if (eStatementCheckbox.isSelected()) {
            services = services + "E-Statement";
        }

        try {
            if (e.getSource() == submitButton) {
                if (actionType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn loại tài khoản");
                } else if (services.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn ít nhất 1 dịch vụ");
                } else if (!confirmCheckbox.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn xác nhận thông tin");
                }                else {
                    Connector connector = new Connector();

                    String addInformationQuery = "insert into signup_third values('" + this.formId + "', '" + actionType + "','" + cardNumber + "','" + pinCode + "','" + services + "')";

                    String loginQuery = "insert into login values('" + this.formId + "','" + cardNumber + "','" + pinCode + "')";
                    connector.statement.executeUpdate(addInformationQuery);

                    connector.statement.executeUpdate(loginQuery);
                    JOptionPane.showMessageDialog(null, "Số thẻ : " + cardNumber + "  Mã Pin : " + pin);
                    new Home(pinCode);
                    setVisible(false);
                }
            } else if (e.getSource() == backButton) {
                setVisible(false);
                new SignupSecond(this.formId);
            } else if (e.getSource() == cancelButton) {
                setVisible(false);
                new Login();
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupThird("");
    }
}
