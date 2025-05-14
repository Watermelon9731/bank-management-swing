package bank.management.system;

import bank.management.system.constants.Background;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupSecond extends JFrame implements ActionListener {
    JLabel bankIconLabel, headingLabel, pageNumberLabel, titleLabel, citizenIdentificationLabel, religionLabel, dateOfIssueLabel, placeOfIssueLabel, educationLabel;
    JTextField citizenIdentificationTextField, placeOfIssueTextField;
    JDateChooser dateOfIssueChooser;
    JComboBox<String> religionComboBox, educationComboBox;

    JButton nextButton;

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

    SignupSecond() {
        super("Application Form");

        ImageIcon bankIconRaw = new ImageIcon(ClassLoader.getSystemResource("images/icons/bank.png"));
        Image bankIconResizedImage = bankIconRaw.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankIcon = new ImageIcon(bankIconResizedImage);

        bankIconLabel = new JLabel(bankIcon);
        bankIconLabel.setBounds(25, 10, 100, 100);
        add(bankIconLabel);

        headingLabel = new JLabel("Application Form No." + "");
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headingLabel.setBounds(150, 30, 600, 40);
        add(headingLabel);

        pageNumberLabel = new JLabel("Page 2");
        pageNumberLabel.setForeground(Color.BLACK);
        pageNumberLabel.setFont(new Font("Arial", Font.BOLD, 22));
        pageNumberLabel.setBounds(150, 70, 600, 40);
        add(pageNumberLabel);

        titleLabel = new JLabel("Personal Information");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(25, 120, 600, 40);
        add(titleLabel);

        // Citizen Identification field
        citizenIdentificationLabel = new JLabel("Identity Card Number");
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
        religionLabel = new JLabel("Place Of Issue");
        religionLabel.setForeground(Color.BLACK);
        religionLabel.setFont(new Font("Arial", Font.BOLD, 22));
        religionLabel.setBounds(this.formStartX, this.getPositionY(1), this.formLabelWidth, this.lineHeight);
        add(religionLabel);

        String religion[] = {"None","Christian","Muslim", "Hindu", "Other"};
        religionComboBox = new JComboBox(religion);
        religionComboBox.setBackground(Color.WHITE);
        religionComboBox.setFont(new Font("Arial",Font.BOLD,22));
        religionComboBox.setBounds(this.formTextFieldStartX, this.getPositionY(1), this.formTextFieldWidth, this.lineHeight);
        add(religionComboBox);

        // Date of issue field
        dateOfIssueLabel = new JLabel("Date of Issue");
        dateOfIssueLabel.setForeground(Color.BLACK);
        dateOfIssueLabel.setFont(new Font("Arial", Font.BOLD, 22));
        dateOfIssueLabel.setBounds(this.formStartX, this.getPositionY(2), this.formLabelWidth, this.lineHeight);
        add(dateOfIssueLabel);

        dateOfIssueChooser = new JDateChooser();
        dateOfIssueChooser.setForeground(new Color(105, 105, 105));
        dateOfIssueChooser.setBounds(this.formTextFieldStartX, this.getPositionY(2), this.formTextFieldWidth, this.lineHeight);
        add(dateOfIssueChooser);

        // Place of issue field
        placeOfIssueLabel = new JLabel("Place Of Issue");
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
        educationLabel = new JLabel("Education");
        educationLabel.setForeground(Color.BLACK);
        educationLabel.setFont(new Font("Arial", Font.BOLD, 22));
        educationLabel.setBounds(this.formStartX, this.getPositionY(4), this.formLabelWidth, this.lineHeight);
        add(educationLabel);

        String education[] = {"Undergraduate","Non-Graduate","Graduate","Post-Graduate", "Doctorate", "Others"};
        educationComboBox = new JComboBox(education);
        educationComboBox.setBackground(Color.WHITE);
        educationComboBox.setFont(new Font("Arial",Font.BOLD,22));
        educationComboBox.setBounds(this.formTextFieldStartX, this.getPositionY(4), this.formTextFieldWidth, this.lineHeight);
        add(educationComboBox);

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(560, this.getPositionY(6), 80, 50);
        nextButton.addActionListener(this);
        add(nextButton);

        getContentPane().setBackground(Background.BACKGROUND_COLOR);
        setLayout(null);
        setSize(800, 550);
        setLocation(360, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new SignupThird();
        setVisible(false);
    }

    public static void main(String[] args) {
        new SignupSecond();
    }
}
