package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {
    JLabel bankIconLabel, headingLabel, pageNumberLabel, titleLabel, nameLabel, dobLabel, accountLabel, genderLabel, emailLabel, maritalStatusLabel, addressLabel, pinCodeLabel, cityLabel, provinceLabel;
    JTextField nameTextField, accountTextField, emailTextField, addressTextField, cityTextField, provinceTextField;
    JPasswordField pinCodeTextField, rePinCodeTextField;
    JDateChooser dateChooser;
    JRadioButton maleGenderRadioButton, femaleGenderRadioButton, marriedMaritalStatusRadioButton, unmarriedMaritalStatusRadioButton, otherMaritalStatusRadioButton;
    JButton nextButton;

    Random randomNumber = new Random();
    long fourDigitsId = (randomNumber.nextLong() % 9000L) + 1000L;

    String fourDigitsIdString = " " + Math.abs(fourDigitsId);

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
        nameLabel.setBounds(this.formStartX, this.formStartY, this.formLabelWidth, this.lineHeight);
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 16));
        nameTextField.setForeground(Color.BLACK);
        nameTextField.setBounds(this.formTextFieldStartX, this.formStartY, this.formTextFieldWidth, this.lineHeight);
        add(nameTextField);

        // Account name field
        accountLabel = new JLabel("Account Name");
        accountLabel.setForeground(Color.BLACK);
        accountLabel.setFont(new Font("Arial", Font.BOLD, 22));
        accountLabel.setBounds(this.formStartX, this.getPositionY(1), this.formLabelWidth, this.lineHeight);
        add(accountLabel);

        accountTextField = new JTextField();
        accountTextField.setFont(new Font("Arial", Font.BOLD, 16));
        accountTextField.setForeground(Color.BLACK);
        accountTextField.setBounds(this.formTextFieldStartX, this.getPositionY(1), this.formTextFieldWidth, this.lineHeight);
        add(accountTextField);

        // Date of birth field
        dobLabel = new JLabel("Date of Birth");
        dobLabel.setForeground(Color.BLACK);
        dobLabel.setFont(new Font("Arial", Font.BOLD, 22));
        dobLabel.setBounds(this.formStartX, this.getPositionY(2), this.formLabelWidth, this.lineHeight);
        add(dobLabel);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(this.formTextFieldStartX, this.getPositionY(2), this.formTextFieldWidth, this.lineHeight);
        add(dateChooser);

        // Gender field
        genderLabel = new JLabel("Gender");
        genderLabel.setForeground(Color.BLACK);
        genderLabel.setFont(new Font("Arial", Font.BOLD, 22));
        genderLabel.setBounds(this.formStartX, this.getPositionY(3), this.formLabelWidth, this.lineHeight);
        add(genderLabel);

        maleGenderRadioButton = new JRadioButton("Male");
        maleGenderRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        maleGenderRadioButton.setBounds(this.formTextFieldStartX, this.getPositionY(3), this.formRadioButtonWidth, this.lineHeight);
        add(maleGenderRadioButton);

        femaleGenderRadioButton = new JRadioButton("Female");
        femaleGenderRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        femaleGenderRadioButton.setBounds(this.formTextFieldStartX + this.formRadioButtonWidth, this.getPositionY(3), this.formRadioButtonWidth, this.lineHeight);
        add(femaleGenderRadioButton);

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleGenderRadioButton);
        genderButtonGroup.add(femaleGenderRadioButton);

        // Email field
        emailLabel = new JLabel("Email Address");
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 22));
        emailLabel.setBounds(this.formStartX, this.getPositionY(4), this.formLabelWidth, this.lineHeight);
        add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.BOLD, 16));
        emailTextField.setForeground(Color.BLACK);
        emailTextField.setBounds(this.formTextFieldStartX, this.getPositionY(4), this.formTextFieldWidth, this.lineHeight);
        add(emailTextField);

        // Marital field
        maritalStatusLabel = new JLabel("Marital Status");
        maritalStatusLabel.setForeground(Color.BLACK);
        maritalStatusLabel.setFont(new Font("Arial", Font.BOLD, 22));
        maritalStatusLabel.setBounds(this.formStartX, this.getPositionY(5), this.formLabelWidth, this.lineHeight);
        add(maritalStatusLabel);

        marriedMaritalStatusRadioButton = new JRadioButton("Married");
        marriedMaritalStatusRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        marriedMaritalStatusRadioButton.setBounds(this.formTextFieldStartX, this.getPositionY(5), this.formRadioButtonWidth, this.lineHeight);
        add(marriedMaritalStatusRadioButton);

        unmarriedMaritalStatusRadioButton = new JRadioButton("Unmarried");
        unmarriedMaritalStatusRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        unmarriedMaritalStatusRadioButton.setBounds(this.formTextFieldStartX + this.formRadioButtonWidth, this.getPositionY(5), this.formRadioButtonWidth, this.lineHeight);
        add(unmarriedMaritalStatusRadioButton);

        otherMaritalStatusRadioButton = new JRadioButton("Other");
        otherMaritalStatusRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        otherMaritalStatusRadioButton.setBounds(this.formTextFieldStartX + this.formRadioButtonWidth * 2, this.getPositionY(5), this.formRadioButtonWidth, this.lineHeight);
        add(otherMaritalStatusRadioButton);

        ButtonGroup maritalStatusButtonGroup = new ButtonGroup();
        maritalStatusButtonGroup.add(marriedMaritalStatusRadioButton);
        maritalStatusButtonGroup.add(unmarriedMaritalStatusRadioButton);
        maritalStatusButtonGroup.add(otherMaritalStatusRadioButton);

        // Address field
        addressLabel = new JLabel("Address");
        addressLabel.setForeground(Color.BLACK);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 22));
        addressLabel.setBounds(this.formStartX, this.getPositionY(6), this.formLabelWidth, this.lineHeight);
        add(addressLabel);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial", Font.BOLD, 16));
        addressTextField.setForeground(Color.BLACK);
        addressTextField.setBounds(this.formTextFieldStartX, this.getPositionY(6), this.formTextFieldWidth, this.lineHeight);
        add(addressTextField);

        // City field
        cityLabel = new JLabel("City");
        cityLabel.setForeground(Color.BLACK);
        cityLabel.setFont(new Font("Arial", Font.BOLD, 22));
        cityLabel.setBounds(this.formStartX, this.getPositionY(7), this.formLabelWidth, this.lineHeight);
        add(cityLabel);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial", Font.BOLD, 16));
        cityTextField.setForeground(Color.BLACK);
        cityTextField.setBounds(this.formTextFieldStartX, this.getPositionY(7), this.formTextFieldWidth, this.lineHeight);
        add(cityTextField);

        // Province field
        provinceLabel = new JLabel("Province");
        provinceLabel.setForeground(Color.BLACK);
        provinceLabel.setFont(new Font("Arial", Font.BOLD, 22));
        provinceLabel.setBounds(this.formStartX, this.getPositionY(8), this.formLabelWidth, this.lineHeight);
        add(provinceLabel);

        provinceTextField = new JTextField();
        provinceTextField.setFont(new Font("Arial", Font.BOLD, 16));
        provinceTextField.setForeground(Color.BLACK);
        provinceTextField.setBounds(this.formTextFieldStartX, this.getPositionY(8), this.formTextFieldWidth, this.lineHeight);
        add(provinceTextField);

        // Pin code field
        pinCodeLabel = new JLabel("Pin Code");
        pinCodeLabel.setForeground(Color.BLACK);
        pinCodeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        pinCodeLabel.setBounds(this.formStartX, this.getPositionY(9), this.formLabelWidth, this.lineHeight);
        add(pinCodeLabel);

        pinCodeTextField = new JPasswordField();
        pinCodeTextField.setFont(new Font("Arial", Font.BOLD, 16));
        pinCodeTextField.setForeground(Color.BLACK);
        pinCodeTextField.setBounds(this.formTextFieldStartX, this.getPositionY(9), this.formTextFieldWidth, this.lineHeight);
        add(pinCodeTextField);

        // Re-Pin code field
        pinCodeLabel = new JLabel("Pin Code Confirmation");
        pinCodeLabel.setForeground(Color.BLACK);
        pinCodeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        pinCodeLabel.setBounds(this.formStartX, this.getPositionY(10), this.formLabelWidth, this.lineHeight);
        add(pinCodeLabel);

        rePinCodeTextField = new JPasswordField();
        rePinCodeTextField.setFont(new Font("Arial", Font.BOLD, 16));
        rePinCodeTextField.setForeground(Color.BLACK);
        rePinCodeTextField.setBounds(this.formTextFieldStartX, this.getPositionY(10), this.formTextFieldWidth, this.lineHeight);
        add(rePinCodeTextField);

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.BLACK);
        nextButton.setBounds(560, this.getPositionY(12), 80, 50);
        nextButton.addActionListener(this);
        add(nextButton);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formId = fourDigitsIdString;
        String name = nameTextField.getText();
        String account = accountTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (maleGenderRadioButton.isSelected()) {
            gender = "Male";
        } else if (femaleGenderRadioButton.isSelected()) {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String maritalStatus = null;
        if (marriedMaritalStatusRadioButton.isSelected()) {
            maritalStatus = "Married";
        } else if (unmarriedMaritalStatusRadioButton.isSelected()) {
            maritalStatus = "Unmarried";
        } else if (otherMaritalStatusRadioButton.isSelected()) {
            maritalStatus = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pinCode = pinCodeTextField.getText();
        String province = provinceTextField.getText();


    }

    public static void main(String[] args) {
        new SignUp();
    }
}
