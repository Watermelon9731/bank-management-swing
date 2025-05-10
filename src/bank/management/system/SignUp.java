package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Random;

public class SignUp extends JFrame {
    JLabel bankIconLabel, headingLabel, pageNumberLabel, titleLabel, nameLabel, dobLabel, accountLabel, genderLabel, emailLabel, maritalStatusLabel, addressLabel, pinCodeLabel;
    JTextField nameTextField, accountTextField, emailTextField, maritalStatusTextField, addressTextField;
    JPasswordField pinCodeTextField, rePinCodeTextField;
    JDateChooser dateChooser;
    JRadioButton maleGenderRadioButton, femaleGenderRadioButton;

    Random randomNumber = new Random();
    long fourDigitsId = (randomNumber.nextLong() % 9000L) + 1000L;

    String fourDigitsIdString = " " + Math.abs(fourDigitsId);

    SignUp() {
        super("Application Form");

        ImageIcon bankIconRaw = new ImageIcon(ClassLoader.getSystemResource("images/icons/bank.png"));
        Image bankIconResizedImage = bankIconRaw.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankIcon = new ImageIcon(bankIconResizedImage);

        bankIconLabel = new JLabel(bankIcon);
        bankIconLabel.setBounds(25, 10, 100, 100);
        add(bankIconLabel);

        headingLabel = new JLabel("Application Form No." + fourDigitsIdString);
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headingLabel.setBounds(150, 30, 600, 40);
        add(headingLabel);

        pageNumberLabel = new JLabel("Page 1");
        pageNumberLabel.setForeground(Color.BLACK);
        pageNumberLabel.setFont(new Font("Arial", Font.BOLD, 22));
        pageNumberLabel.setBounds(150, 70, 600, 40);
        add(pageNumberLabel);

        titleLabel = new JLabel("Personal Information");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(25, 120, 600, 40);
        add(titleLabel);

        // Full name field
        nameLabel = new JLabel("Full Name");
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 22));
        nameLabel.setBounds(45, 160, 350, 40);
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 16));
        nameTextField.setForeground(Color.BLACK);
        nameTextField.setBounds(300, 160, 200, 40);
        add(nameTextField);

        // Account name field
        accountLabel = new JLabel("Account Name");
        accountLabel.setForeground(Color.BLACK);
        accountLabel.setFont(new Font("Arial", Font.BOLD, 22));
        accountLabel.setBounds(45, 200, 350, 40);
        add(accountLabel);

        accountTextField = new JTextField();
        accountTextField.setFont(new Font("Arial", Font.BOLD, 16));
        accountTextField.setForeground(Color.BLACK);
        accountTextField.setBounds(300, 200, 200, 40);
        add(accountTextField);

        // Date of birth field
        dobLabel = new JLabel("Date of Birth");
        dobLabel.setForeground(Color.BLACK);
        dobLabel.setFont(new Font("Arial", Font.BOLD, 22));
        dobLabel.setBounds(45, 240, 350, 40);
        add(dobLabel);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 240, 200, 40);
        add(dateChooser);

        // Gender field
        genderLabel = new JLabel("Gender");
        genderLabel.setForeground(Color.BLACK);
        genderLabel.setFont(new Font("Arial", Font.BOLD, 22));
        genderLabel.setBounds(45, 280, 350, 40);
        add(genderLabel);

        maleGenderRadioButton = new JRadioButton("Male");
        maleGenderRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        maleGenderRadioButton.setBounds(300, 280, 100, 40);
        add(maleGenderRadioButton);

        femaleGenderRadioButton = new JRadioButton("Female");
        femaleGenderRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        femaleGenderRadioButton.setBounds(400, 280, 100, 40);
        add(femaleGenderRadioButton);

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleGenderRadioButton);
        genderButtonGroup.add(femaleGenderRadioButton);

        // Email field
        emailLabel = new JLabel("Email Address");
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 22));
        emailLabel.setBounds(45, 320, 350, 40);
        add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.BOLD, 16));
        emailTextField.setForeground(Color.BLACK);
        emailTextField.setBounds(300, 320, 200, 40);
        add(emailTextField);

        // Marital field
        maritalStatusLabel = new JLabel("Marital Status");
        maritalStatusLabel.setForeground(Color.BLACK);
        maritalStatusLabel.setFont(new Font("Arial", Font.BOLD, 22));
        maritalStatusLabel.setBounds(45, 360, 350, 40);
        add(maritalStatusLabel);

        maritalStatusTextField = new JTextField();
        maritalStatusTextField.setFont(new Font("Arial", Font.BOLD, 16));
        maritalStatusTextField.setForeground(Color.BLACK);
        maritalStatusTextField.setBounds(300, 360, 200, 40);
        add(maritalStatusTextField);

        // Address field
        addressLabel = new JLabel("Address");
        addressLabel.setForeground(Color.BLACK);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 22));
        addressLabel.setBounds(45, 400, 350, 40);
        add(addressLabel);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial", Font.BOLD, 16));
        addressTextField.setForeground(Color.BLACK);
        addressTextField.setBounds(300, 400, 200, 40);
        add(addressTextField);

        // Pin code field
        pinCodeLabel = new JLabel("Pin Code");
        pinCodeLabel.setForeground(Color.BLACK);
        pinCodeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        pinCodeLabel.setBounds(45, 440, 350, 40);
        add(pinCodeLabel);

        pinCodeTextField = new JPasswordField();
        pinCodeTextField.setFont(new Font("Arial", Font.BOLD, 16));
        pinCodeTextField.setForeground(Color.BLACK);
        pinCodeTextField.setBounds(300, 440, 200, 40);
        add(pinCodeTextField);

        // Re-Pin code field
        pinCodeLabel = new JLabel("Pin Code Confirmation");
        pinCodeLabel.setForeground(Color.BLACK);
        pinCodeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        pinCodeLabel.setBounds(45, 480, 350, 40);
        add(pinCodeLabel);

        rePinCodeTextField = new JPasswordField();
        rePinCodeTextField.setFont(new Font("Arial", Font.BOLD, 16));
        rePinCodeTextField.setForeground(Color.BLACK);
        rePinCodeTextField.setBounds(300, 480, 200, 40);
        add(rePinCodeTextField);


        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
