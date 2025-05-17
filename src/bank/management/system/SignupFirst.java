package bank.management.system;

import bank.management.system.constants.Background;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupFirst extends JFrame implements ActionListener {
    JLabel bankIconLabel, headingLabel, pageNumberLabel, titleLabel, nameLabel, dobLabel, accountLabel, genderLabel, emailLabel, maritalStatusLabel, addressLabel, passwordLabel, passwordConfirmLabel, cityLabel, provinceLabel, backgroundImageLabel;
    JTextField nameTextField, accountTextField, emailTextField, addressTextField, cityTextField, provinceTextField;
    JPasswordField pinCodeTextField, passwordTextField, passwordConfirmTextField;
    JDateChooser dateChooser;
    JRadioButton maleGenderRadioButton, femaleGenderRadioButton, marriedMaritalStatusRadioButton, unmarriedMaritalStatusRadioButton, otherMaritalStatusRadioButton;
    JButton nextButton;

    Random randomNumber = new Random();
    long fourDigitsId = (randomNumber.nextLong() % 9000L) + 1000L;

    String fourDigitsIdString = "" + Math.abs(fourDigitsId);

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

    SignupFirst() {
        super("Application Form");

        ImageIcon bankIconRaw = new ImageIcon(ClassLoader.getSystemResource("images/icons/bank.png"));
        Image bankIconResizedImage = bankIconRaw.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankIcon = new ImageIcon(bankIconResizedImage);

        bankIconLabel = new JLabel(bankIcon);
        bankIconLabel.setBounds(25, 10, 100, 100);
        add(bankIconLabel);

        headingLabel = new JLabel("Application Form No." + fourDigitsIdString);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headingLabel.setBounds(150, 30, 600, 40);
        add(headingLabel);

        pageNumberLabel = new JLabel("Personal Information - Page 1");
        pageNumberLabel.setForeground(Color.WHITE);
        pageNumberLabel.setFont(new Font("Arial", Font.BOLD, 22));
        pageNumberLabel.setBounds(150, 70, 600, 40);
        add(pageNumberLabel);

        // Full name field
        nameLabel = new JLabel("Full Name");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 22));
        nameLabel.setBounds(this.formStartX, this.formStartY, this.formLabelWidth, this.lineHeight);
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 16));
        nameTextField.setForeground(Color.WHITE);
        nameTextField.setBounds(this.formTextFieldStartX, this.formStartY, this.formTextFieldWidth, this.lineHeight);
        add(nameTextField);

        // Account name field
        accountLabel = new JLabel("Account Name");
        accountLabel.setForeground(Color.WHITE);
        accountLabel.setFont(new Font("Arial", Font.BOLD, 22));
        accountLabel.setBounds(this.formStartX, this.getPositionY(1), this.formLabelWidth, this.lineHeight);
        add(accountLabel);

        accountTextField = new JTextField();
        accountTextField.setFont(new Font("Arial", Font.BOLD, 16));
        accountTextField.setForeground(Color.WHITE);
        accountTextField.setBounds(this.formTextFieldStartX, this.getPositionY(1), this.formTextFieldWidth, this.lineHeight);
        add(accountTextField);

        // Date of birth field
        dobLabel = new JLabel("Date of Birth");
        dobLabel.setForeground(Color.WHITE);
        dobLabel.setFont(new Font("Arial", Font.BOLD, 22));
        dobLabel.setBounds(this.formStartX, this.getPositionY(2), this.formLabelWidth, this.lineHeight);
        add(dobLabel);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(this.formTextFieldStartX, this.getPositionY(2), this.formTextFieldWidth, this.lineHeight);
        add(dateChooser);

        // Gender field
        genderLabel = new JLabel("Gender");
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setFont(new Font("Arial", Font.BOLD, 22));
        genderLabel.setBounds(this.formStartX, this.getPositionY(3), this.formLabelWidth, this.lineHeight);
        add(genderLabel);

        maleGenderRadioButton = new JRadioButton("Male");
        maleGenderRadioButton.setBackground(Background.BACKGROUND_COLOR);
        maleGenderRadioButton.setForeground(Color.WHITE);
        maleGenderRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        maleGenderRadioButton.setBounds(this.formTextFieldStartX, this.getPositionY(3), this.formRadioButtonWidth, this.lineHeight);
        add(maleGenderRadioButton);

        femaleGenderRadioButton = new JRadioButton("Female");
        femaleGenderRadioButton.setBackground(Background.BACKGROUND_COLOR);
        femaleGenderRadioButton.setForeground(Color.WHITE);
        femaleGenderRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        femaleGenderRadioButton.setBounds(this.formTextFieldStartX + this.formRadioButtonWidth, this.getPositionY(3), this.formRadioButtonWidth, this.lineHeight);
        add(femaleGenderRadioButton);

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleGenderRadioButton);
        genderButtonGroup.add(femaleGenderRadioButton);

        // Email field
        emailLabel = new JLabel("Email Address");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 22));
        emailLabel.setBounds(this.formStartX, this.getPositionY(4), this.formLabelWidth, this.lineHeight);
        add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.BOLD, 16));
        emailTextField.setForeground(Color.WHITE);
        emailTextField.setBounds(this.formTextFieldStartX, this.getPositionY(4), this.formTextFieldWidth, this.lineHeight);
        add(emailTextField);

        // Marital field
        maritalStatusLabel = new JLabel("Marital Status");
        maritalStatusLabel.setForeground(Color.WHITE);
        maritalStatusLabel.setFont(new Font("Arial", Font.BOLD, 22));
        maritalStatusLabel.setBounds(this.formStartX, this.getPositionY(5), this.formLabelWidth, this.lineHeight);
        add(maritalStatusLabel);

        marriedMaritalStatusRadioButton = new JRadioButton("Married");
        marriedMaritalStatusRadioButton.setForeground(Color.WHITE);
        marriedMaritalStatusRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        marriedMaritalStatusRadioButton.setBounds(this.formTextFieldStartX, this.getPositionY(5), this.formRadioButtonWidth, this.lineHeight);
        add(marriedMaritalStatusRadioButton);

        unmarriedMaritalStatusRadioButton = new JRadioButton("Unmarried");
        unmarriedMaritalStatusRadioButton.setForeground(Color.WHITE);
        unmarriedMaritalStatusRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        unmarriedMaritalStatusRadioButton.setBounds(this.formTextFieldStartX + this.formRadioButtonWidth, this.getPositionY(5), this.formRadioButtonWidth, this.lineHeight);
        add(unmarriedMaritalStatusRadioButton);

        otherMaritalStatusRadioButton = new JRadioButton("Other");
        otherMaritalStatusRadioButton.setForeground(Color.WHITE);
        otherMaritalStatusRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        otherMaritalStatusRadioButton.setBounds(this.formTextFieldStartX + this.formRadioButtonWidth * 2, this.getPositionY(5), this.formRadioButtonWidth, this.lineHeight);
        add(otherMaritalStatusRadioButton);

        ButtonGroup maritalStatusButtonGroup = new ButtonGroup();
        maritalStatusButtonGroup.add(marriedMaritalStatusRadioButton);
        maritalStatusButtonGroup.add(unmarriedMaritalStatusRadioButton);
        maritalStatusButtonGroup.add(otherMaritalStatusRadioButton);

        // Address field
        addressLabel = new JLabel("Address");
        addressLabel.setForeground(Color.WHITE);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 22));
        addressLabel.setBounds(this.formStartX, this.getPositionY(6), this.formLabelWidth, this.lineHeight);
        add(addressLabel);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial", Font.BOLD, 16));
        addressTextField.setForeground(Color.WHITE);
        addressTextField.setBounds(this.formTextFieldStartX, this.getPositionY(6), this.formTextFieldWidth, this.lineHeight);
        add(addressTextField);

        // City field
        cityLabel = new JLabel("City");
        cityLabel.setForeground(Color.WHITE);
        cityLabel.setFont(new Font("Arial", Font.BOLD, 22));
        cityLabel.setBounds(this.formStartX, this.getPositionY(7), this.formLabelWidth, this.lineHeight);
        add(cityLabel);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial", Font.BOLD, 16));
        cityTextField.setForeground(Color.WHITE);
        cityTextField.setBounds(this.formTextFieldStartX, this.getPositionY(7), this.formTextFieldWidth, this.lineHeight);
        add(cityTextField);

        // Province field
        provinceLabel = new JLabel("Province");
        provinceLabel.setForeground(Color.WHITE);
        provinceLabel.setFont(new Font("Arial", Font.BOLD, 22));
        provinceLabel.setBounds(this.formStartX, this.getPositionY(8), this.formLabelWidth, this.lineHeight);
        add(provinceLabel);

        provinceTextField = new JTextField();
        provinceTextField.setFont(new Font("Arial", Font.BOLD, 16));
        provinceTextField.setForeground(Color.WHITE);
        provinceTextField.setBounds(this.formTextFieldStartX, this.getPositionY(8), this.formTextFieldWidth, this.lineHeight);
        add(provinceTextField);

        // Pin code field
        passwordLabel = new JLabel("Pin Code");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 22));
        passwordLabel.setBounds(this.formStartX, this.getPositionY(9), this.formLabelWidth, this.lineHeight);
        add(passwordLabel);

        passwordTextField = new JPasswordField();
        passwordTextField.setFont(new Font("Arial", Font.BOLD, 16));
        passwordTextField.setForeground(Color.WHITE);
        passwordTextField.setBounds(this.formTextFieldStartX, this.getPositionY(9), this.formTextFieldWidth, this.lineHeight);
        add(passwordTextField);

        // Re-Pin code field
        passwordConfirmLabel = new JLabel("Pin Code Confirmation");
        passwordConfirmLabel.setForeground(Color.WHITE);
        passwordConfirmLabel.setFont(new Font("Arial", Font.BOLD, 22));
        passwordConfirmLabel.setBounds(this.formStartX, this.getPositionY(10), this.formLabelWidth, this.lineHeight);
        add(passwordConfirmLabel);

        passwordConfirmTextField = new JPasswordField();
        passwordConfirmTextField.setFont(new Font("Arial", Font.BOLD, 16));
        passwordConfirmTextField.setForeground(Color.WHITE);
        passwordConfirmTextField.setBounds(this.formTextFieldStartX, this.getPositionY(10), this.formTextFieldWidth, this.lineHeight);
        add(passwordConfirmTextField);

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(560, this.getPositionY(12), 80, 50);
        nextButton.addActionListener(this);
        add(nextButton);

//        getContentPane().setBackground(Background.BACKGROUND_COLOR);
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
    public void actionPerformed(ActionEvent event) {
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
        String pinCodeConfirmation = pinCodeTextField.getText();
        String province = provinceTextField.getText();

        try {
            if (nameTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your name");
            } else if (accountTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your account");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your dob");
            } else if (gender.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your Gender");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your email");
            } else if (maritalStatus.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your marital status");
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your address");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your city");
            } else if (pinCode.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your pin code");
            } else if (!pinCodeConfirmation.equals(pinCode)) {
                JOptionPane.showMessageDialog(null, "Please confirm your pin code");
            } else if (province.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your province");
            } else {
                Connector connector = new Connector();
                String addValuesQuery = "insert into signup values ('" + formId + "', '" + name + "','" + account + "','" + dob + "','" + gender + "','" + email + "', '" + maritalStatus + "', '" + address + "', '" + city + "','" + pinCode + "','" + province + "' )";
                connector.statement.executeUpdate(addValuesQuery);
                new SignupSecond(formId);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new SignupFirst();
    }
}
