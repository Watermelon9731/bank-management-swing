package bank.management.system;

import bank.management.system.constants.Background;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

public class SignupFirst extends JFrame implements ActionListener {
    JLabel bankIconLabel, headingLabel, pageNumberLabel, titleLabel, nameLabel, dobLabel, accountLabel, genderLabel, emailLabel, maritalStatusLabel, addressLabel, passwordLabel, passwordConfirmLabel, cityLabel, provinceLabel, backgroundImageLabel;
    JTextField nameTextField, accountTextField, emailTextField, addressTextField, cityTextField, provinceTextField;
    JPasswordField passwordTextField, passwordConfirmTextField;
    JDateChooser dateChooser;
    JRadioButton maleGenderRadioButton, femaleGenderRadioButton, marriedMaritalStatusRadioButton, unmarriedMaritalStatusRadioButton, otherMaritalStatusRadioButton;
    JButton nextButton, backButton;

    int lineHeight = 40;
    int formStartY = 140;
    int formStartX = 45;
    int formLabelWidth = 300;
    int formTextFieldWidth = 300;
    int formTextFieldStartX = this.formStartX + this.formLabelWidth;
    int formRadioButtonWidth = 150;

    Random randomNumber = new Random();

    String formId;

    public int getPositionY(int level) {
        return Background.getPositionY(this.formStartY, level);
    }

    public void checkFormId(String id) {
        if (id.isBlank()) {
            long fourDigitsId = (this.randomNumber.nextLong() % 9000L) + 1000L;
            String fourDigitsIdString = "" + Math.abs(fourDigitsId);
            this.formId = fourDigitsIdString + "";
        } else {
            this.formId = id;
        }
    }

    SignupFirst(String formId) {
        super("Application Form");

        checkFormId(formId);

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

        pageNumberLabel = new JLabel("Thông tin cá nhân - Page 1");
        pageNumberLabel.setForeground(Color.WHITE);
        pageNumberLabel.setFont(new Font("Arial", Font.BOLD, 22));
        pageNumberLabel.setBounds(150, 70, 600, 40);
        add(pageNumberLabel);

        // Full name field
        nameLabel = new JLabel("Họ và tên");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 22));
        nameLabel.setBounds(this.formStartX, this.formStartY, this.formLabelWidth, this.lineHeight);
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 16));
        nameTextField.setForeground(Color.BLACK);
        nameTextField.setBounds(this.formTextFieldStartX, this.formStartY, this.formTextFieldWidth, this.lineHeight);
        add(nameTextField);

        // Account name field
        accountLabel = new JLabel("Tên tài khoản");
        accountLabel.setForeground(Color.WHITE);
        accountLabel.setFont(new Font("Arial", Font.BOLD, 22));
        accountLabel.setBounds(this.formStartX, this.getPositionY(1), this.formLabelWidth, this.lineHeight);
        add(accountLabel);

        accountTextField = new JTextField();
        accountTextField.setFont(new Font("Arial", Font.BOLD, 16));
        accountTextField.setForeground(Color.BLACK);
        accountTextField.setBounds(this.formTextFieldStartX, this.getPositionY(1), this.formTextFieldWidth, this.lineHeight);
        add(accountTextField);

        // Date of birth field
        dobLabel = new JLabel("Ngày sinh");
        dobLabel.setForeground(Color.WHITE);
        dobLabel.setFont(new Font("Arial", Font.BOLD, 22));
        dobLabel.setBounds(this.formStartX, this.getPositionY(2), this.formLabelWidth, this.lineHeight);
        add(dobLabel);

        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("Arial", Font.BOLD, 16));
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(this.formTextFieldStartX, this.getPositionY(2), this.formTextFieldWidth, this.lineHeight);
        add(dateChooser);

        // Gender field
        genderLabel = new JLabel("Giới tính");
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setFont(new Font("Arial", Font.BOLD, 22));
        genderLabel.setBounds(this.formStartX, this.getPositionY(3), this.formLabelWidth, this.lineHeight);
        add(genderLabel);

        maleGenderRadioButton = new JRadioButton("Nam");
        maleGenderRadioButton.setOpaque(false);
        maleGenderRadioButton.setForeground(Color.WHITE);
        maleGenderRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        maleGenderRadioButton.setBounds(this.formTextFieldStartX, this.getPositionY(3), this.formRadioButtonWidth, this.lineHeight);
        add(maleGenderRadioButton);

        femaleGenderRadioButton = new JRadioButton("Nữ");
        femaleGenderRadioButton.setOpaque(false);
        femaleGenderRadioButton.setForeground(Color.WHITE);
        femaleGenderRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        femaleGenderRadioButton.setBounds(this.formTextFieldStartX + this.formRadioButtonWidth, this.getPositionY(3), this.formRadioButtonWidth, this.lineHeight);
        add(femaleGenderRadioButton);

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleGenderRadioButton);
        genderButtonGroup.add(femaleGenderRadioButton);

        // Email field
        emailLabel = new JLabel("Địa chỉ email");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 22));
        emailLabel.setBounds(this.formStartX, this.getPositionY(4), this.formLabelWidth, this.lineHeight);
        add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.BOLD, 16));
        emailTextField.setForeground(Color.BLACK);
        emailTextField.setBounds(this.formTextFieldStartX, this.getPositionY(4), this.formTextFieldWidth, this.lineHeight);
        add(emailTextField);

        // Marital field
        maritalStatusLabel = new JLabel("Tình trạng hôn nhân");
        maritalStatusLabel.setOpaque(false);
        maritalStatusLabel.setForeground(Color.WHITE);
        maritalStatusLabel.setFont(new Font("Arial", Font.BOLD, 22));
        maritalStatusLabel.setBounds(this.formStartX, this.getPositionY(5), this.formLabelWidth, this.lineHeight);
        add(maritalStatusLabel);

        marriedMaritalStatusRadioButton = new JRadioButton("Đã kết hôn");
        marriedMaritalStatusRadioButton.setOpaque(false);
        marriedMaritalStatusRadioButton.setForeground(Color.WHITE);
        marriedMaritalStatusRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        marriedMaritalStatusRadioButton.setBounds(this.formTextFieldStartX, this.getPositionY(5), this.formRadioButtonWidth, this.lineHeight);
        add(marriedMaritalStatusRadioButton);

        unmarriedMaritalStatusRadioButton = new JRadioButton("Độc thân");
        unmarriedMaritalStatusRadioButton.setOpaque(false);
        unmarriedMaritalStatusRadioButton.setForeground(Color.WHITE);
        unmarriedMaritalStatusRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        unmarriedMaritalStatusRadioButton.setBounds(this.formTextFieldStartX + this.formRadioButtonWidth, this.getPositionY(5), this.formRadioButtonWidth, this.lineHeight);
        add(unmarriedMaritalStatusRadioButton);

        otherMaritalStatusRadioButton = new JRadioButton("Khác");
        otherMaritalStatusRadioButton.setOpaque(false);
        otherMaritalStatusRadioButton.setForeground(Color.WHITE);
        otherMaritalStatusRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
        otherMaritalStatusRadioButton.setBounds(this.formTextFieldStartX + this.formRadioButtonWidth * 2, this.getPositionY(5), this.formRadioButtonWidth, this.lineHeight);
        add(otherMaritalStatusRadioButton);

        ButtonGroup maritalStatusButtonGroup = new ButtonGroup();
        maritalStatusButtonGroup.add(marriedMaritalStatusRadioButton);
        maritalStatusButtonGroup.add(unmarriedMaritalStatusRadioButton);
        maritalStatusButtonGroup.add(otherMaritalStatusRadioButton);

        // Address field
        addressLabel = new JLabel("Địa chỉ");
        addressLabel.setForeground(Color.WHITE);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 22));
        addressLabel.setBounds(this.formStartX, this.getPositionY(6), this.formLabelWidth, this.lineHeight);
        add(addressLabel);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial", Font.BOLD, 16));
        addressTextField.setForeground(Color.BLACK);
        addressTextField.setBounds(this.formTextFieldStartX, this.getPositionY(6), this.formTextFieldWidth, this.lineHeight);
        add(addressTextField);

        // City field
        cityLabel = new JLabel("Thành phố");
        cityLabel.setForeground(Color.WHITE);
        cityLabel.setFont(new Font("Arial", Font.BOLD, 22));
        cityLabel.setBounds(this.formStartX, this.getPositionY(7), this.formLabelWidth, this.lineHeight);
        add(cityLabel);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial", Font.BOLD, 16));
        cityTextField.setForeground(Color.BLACK);
        cityTextField.setBounds(this.formTextFieldStartX, this.getPositionY(7), this.formTextFieldWidth, this.lineHeight);
        add(cityTextField);

        // Province field
        provinceLabel = new JLabel("Tỉnh");
        provinceLabel.setForeground(Color.WHITE);
        provinceLabel.setFont(new Font("Arial", Font.BOLD, 22));
        provinceLabel.setBounds(this.formStartX, this.getPositionY(8), this.formLabelWidth, this.lineHeight);
        add(provinceLabel);

        provinceTextField = new JTextField();
        provinceTextField.setFont(new Font("Arial", Font.BOLD, 16));
        provinceTextField.setForeground(Color.BLACK);
        provinceTextField.setBounds(this.formTextFieldStartX, this.getPositionY(8), this.formTextFieldWidth, this.lineHeight);
        add(provinceTextField);

        // Pin code field
        passwordLabel = new JLabel("Mật khẩu");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 22));
        passwordLabel.setBounds(this.formStartX, this.getPositionY(9), this.formLabelWidth, this.lineHeight);
        add(passwordLabel);

        passwordTextField = new JPasswordField();
        passwordTextField.setFont(new Font("Arial", Font.BOLD, 16));
        passwordTextField.setForeground(Color.BLACK);
        passwordTextField.setBounds(this.formTextFieldStartX, this.getPositionY(9), this.formTextFieldWidth, this.lineHeight);
        add(passwordTextField);

        // Re-Pin code field
        passwordConfirmLabel = new JLabel("Xác nhận mật khẩu");
        passwordConfirmLabel.setForeground(Color.WHITE);
        passwordConfirmLabel.setFont(new Font("Arial", Font.BOLD, 22));
        passwordConfirmLabel.setBounds(this.formStartX, this.getPositionY(10), this.formLabelWidth, this.lineHeight);
        add(passwordConfirmLabel);

        passwordConfirmTextField = new JPasswordField();
        passwordConfirmTextField.setFont(new Font("Arial", Font.BOLD, 16));
        passwordConfirmTextField.setForeground(Color.BLACK);
        passwordConfirmTextField.setBounds(this.formTextFieldStartX, this.getPositionY(10), this.formTextFieldWidth, this.lineHeight);
        add(passwordConfirmTextField);

        backButton = new JButton("Quay lại");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(Background.BUTTON_WARNING);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(320, this.getPositionY(11), 150, 50);
        backButton.addActionListener(this);
        add(backButton);

        nextButton = new JButton("Tiếp theo");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setBackground(Background.BUTTON_PRIMARY);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(500, this.getPositionY(11), 150, 50);
        nextButton.addActionListener(this);
        add(nextButton);

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
        if (e.getSource() == backButton) {
            setVisible(false);
            new Home("");
        } else if (e.getSource() == nextButton) {
            String name = nameTextField.getText();
            String account = accountTextField.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if (maleGenderRadioButton.isSelected()) {
                gender = "Nam";
            } else if (femaleGenderRadioButton.isSelected()) {
                gender = "Nữ";
            }
            String email = emailTextField.getText();
            String maritalStatus = null;
            if (marriedMaritalStatusRadioButton.isSelected()) {
                maritalStatus = "Đã kết hôn";
            } else if (unmarriedMaritalStatusRadioButton.isSelected()) {
                maritalStatus = "Độc thân";
            } else if (otherMaritalStatusRadioButton.isSelected()) {
                maritalStatus = "Khác";
            }

            String address = addressTextField.getText();
            String city = cityTextField.getText();
            String password = passwordTextField.getText();
            String passwordConfirm = passwordConfirmTextField.getText();
            String province = provinceTextField.getText();
            Date selectedDate = dateChooser.getDate();

            try {
                if (nameTextField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền họ và tên");
                } else if (accountTextField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền tên tài khoản");
                } else if (selectedDate == null || dob.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền ngày tháng năm sinh");
                } else if (gender.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính");
                } else if (email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền địa chỉ email");
                } else if (maritalStatus.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn tình trạng hôn nhân");
                } else if (address.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền địa chỉ hiện tại");
                } else if (city.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền tên thành phố");
                } else if (password.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng đặt mật khẩu");
                } else if (!passwordConfirm.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Vui lòng xác nhận mật khẩu");
                } else if (province.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền tên tỉnh");
                } else {
                    Connector connector = new Connector();
                    String addValuesQuery = "insert into signup values ('" + this.formId + "', '" + name + "','" + account + "','" + dob + "','" + gender + "','" + email + "', '" + maritalStatus + "', '" + address + "', '" + city + "','" + password + "','" + province + "' )";
                    connector.statement.executeUpdate(addValuesQuery);
                    new SignupSecond(this.formId);
                    setVisible(false);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        try {
            new SignupFirst("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
