package bank.management.system;

import bank.management.system.constants.Background;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupSecond extends JFrame implements ActionListener {
    JLabel bankIconLabel, headingLabel, pageNumberLabel, citizenIdentificationLabel, religionLabel, dateOfIssueLabel, placeOfIssueLabel, educationLabel, backgroundImageLabel;
    JTextField citizenIdentificationTextField, placeOfIssueTextField;
    JDateChooser dateOfIssueChooser;
    JComboBox<String> religionComboBox, educationComboBox;

    JButton nextButton, backButton;

    int lineHeight = 40;
    int formStartY = 160;
    int formStartX = 45;
    int formLabelWidth = 300;
    int formTextFieldWidth = 300;
    int formTextFieldStartX = formStartX + formLabelWidth;

    String formId;

    public int getPositionY(int level) {
        return Background.getPositionY(formStartY, level);
    }

    SignupSecond(String formId) {
        super("Application Form");
        this.formId = formId;

        setLayout(null);
        setSize(Background.BACKGROUND_WIDTH, Background.BACKGROUND_HEIGHT);
        setLocation(30, 30);

        ImageIcon bankIconRaw = new ImageIcon(ClassLoader.getSystemResource("images/icons/bank.png"));
        Image bankIconResizedImage = bankIconRaw.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankIcon = new ImageIcon(bankIconResizedImage);

        bankIconLabel = new JLabel(bankIcon);
        bankIconLabel.setBounds(25, 10, 100, 100);
        add(bankIconLabel);

        headingLabel = new JLabel("Đơn đăng ký Số." + this.formId);
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headingLabel.setBounds(150, 30, 600, 40);
        add(headingLabel);

        pageNumberLabel = new JLabel("Thông tin cá nhân - Trang 2");
        pageNumberLabel.setForeground(Color.BLACK);
        pageNumberLabel.setFont(new Font("Arial", Font.BOLD, 22));
        pageNumberLabel.setBounds(150, 70, 600, 40);
        add(pageNumberLabel);

        // Citizen Identification field
        citizenIdentificationLabel = new JLabel("Số CCCD");
        citizenIdentificationLabel.setForeground(Color.BLACK);
        citizenIdentificationLabel.setFont(new Font("Arial", Font.BOLD, 22));
        citizenIdentificationLabel.setBounds(this.formStartX, this.formStartY, this.formLabelWidth, this.lineHeight);
        add(citizenIdentificationLabel);

        citizenIdentificationTextField = new JTextField();
        citizenIdentificationTextField.setFont(new Font("Arial", Font.BOLD, 16));
        citizenIdentificationTextField.setForeground(Color.BLACK);
        citizenIdentificationTextField.setBounds(this.formTextFieldStartX, this.formStartY, this.formTextFieldWidth, this.lineHeight);
        add(citizenIdentificationTextField);

        // Religion field
        religionLabel = new JLabel("Tôn giáo");
        religionLabel.setForeground(Color.BLACK);
        religionLabel.setFont(new Font("Arial", Font.BOLD, 22));
        religionLabel.setBounds(this.formStartX, this.getPositionY(1), this.formLabelWidth, this.lineHeight);
        add(religionLabel);

        String religion[] = {"Không", "Cơ đốc giáo", "Hồi giáo", "Hindu", "Khác"};
        religionComboBox = new JComboBox(religion);
        religionComboBox.setBackground(Color.WHITE);
        religionComboBox.setFont(new Font("Arial", Font.BOLD, 22));
        religionComboBox.setBounds(this.formTextFieldStartX, this.getPositionY(1), this.formTextFieldWidth, this.lineHeight);
        add(religionComboBox);

        // Date of issue field
        dateOfIssueLabel = new JLabel("Ngày cấp");
        dateOfIssueLabel.setForeground(Color.BLACK);
        dateOfIssueLabel.setFont(new Font("Arial", Font.BOLD, 22));
        dateOfIssueLabel.setBounds(this.formStartX, this.getPositionY(2), this.formLabelWidth, this.lineHeight);
        add(dateOfIssueLabel);

        dateOfIssueChooser = new JDateChooser();
        dateOfIssueChooser.setForeground(new Color(105, 105, 105));
        dateOfIssueChooser.setBounds(this.formTextFieldStartX, this.getPositionY(2), this.formTextFieldWidth, this.lineHeight);
        add(dateOfIssueChooser);

        // Place of issue field
        placeOfIssueLabel = new JLabel("Nơi cấp");
        placeOfIssueLabel.setForeground(Color.BLACK);
        placeOfIssueLabel.setFont(new Font("Arial", Font.BOLD, 22));
        placeOfIssueLabel.setBounds(this.formStartX, this.getPositionY(3), this.formLabelWidth, this.lineHeight);
        add(placeOfIssueLabel);

        placeOfIssueTextField = new JTextField();
        placeOfIssueTextField.setFont(new Font("Arial", Font.BOLD, 16));
        placeOfIssueTextField.setForeground(Color.BLACK);
        placeOfIssueTextField.setBounds(this.formTextFieldStartX, this.getPositionY(3), this.formTextFieldWidth, this.lineHeight);
        add(placeOfIssueTextField);

        // Education field
        educationLabel = new JLabel("Học vấn");
        educationLabel.setForeground(Color.BLACK);
        educationLabel.setFont(new Font("Arial", Font.BOLD, 22));
        educationLabel.setBounds(this.formStartX, this.getPositionY(4), this.formLabelWidth, this.lineHeight);
        add(educationLabel);

        String education[] = {"Sinh viên", "Dưới Đại học", "Cử Nhân", "Sau đại học", "Tiến sỹ", "Khác"};
        educationComboBox = new JComboBox(education);
        educationComboBox.setBackground(Color.WHITE);
        educationComboBox.setFont(new Font("Arial", Font.BOLD, 22));
        educationComboBox.setBounds(this.formTextFieldStartX, this.getPositionY(4), this.formTextFieldWidth, this.lineHeight);
        add(educationComboBox);

        backButton = new JButton("Quay lại");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(Background.BUTTON_WARNING);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(320, this.getPositionY(6), 150, 50);
        backButton.addActionListener(this);
        add(backButton);

        nextButton = new JButton("Tiếp theo");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setBackground(Background.BUTTON_PRIMARY);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(500, this.getPositionY(6), 150, 50);
        nextButton.addActionListener(this);
        add(nextButton);

        ImageIcon backgroundRaw = new ImageIcon(ClassLoader.getSystemResource("images/backgrounds/signup.png"));
        Image backgroundResizedImage = backgroundRaw.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon backgroundImage = new ImageIcon(backgroundResizedImage);
        backgroundImageLabel = new JLabel(backgroundImage);
        backgroundImageLabel.setBounds(0, 0, 800, 800);
        add(backgroundImageLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            setVisible(false);
            new SignupFirst(this.formId);
        } else {
            new SignupThird(formId);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        try {
            new SignupSecond("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
