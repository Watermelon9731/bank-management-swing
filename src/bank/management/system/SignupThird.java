package bank.management.system;

import bank.management.system.constants.Background;
import com.toedter.calendar.JDateChooser;
import bank.management.system.constants.Background;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupThird extends JFrame implements ActionListener {
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

    SignupThird() {
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

        pageNumberLabel = new JLabel("Account Information - Page 3");
        pageNumberLabel.setForeground(Color.BLACK);
        pageNumberLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pageNumberLabel.setBounds(150, 70, 600, 40);
        add(pageNumberLabel);

        getContentPane().setBackground(Background.BACKGROUND_COLOR);
        setLayout(null);
        setSize(800, 550);
        setLocation(360, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    public static void main(String[] args) {
        new SignupThird();
    }
}
