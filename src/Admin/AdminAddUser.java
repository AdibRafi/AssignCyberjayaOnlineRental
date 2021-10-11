package Admin;

import DataSystem.AdminData;
import DataSystem.Data;
import FileSystem.FileConverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class AdminAddUser extends JFrame implements ActionListener {
    Data data = new Data();

    String[] userType = {"Select", "Admin", "Agent", "Tenant"};
    JComboBox<String> userTypeCB = new JComboBox<>(userType);
    JLabel userTypeLabel = new JLabel("User Type");

    JButton addBtn = new JButton("Add");
    JButton BackBtn = new JButton("Back to Main Menu");

    JLabel accountIDLabel = new JLabel("ID Number");
    JLabel userLabel = new JLabel("Username");
    JLabel userPassLabel = new JLabel("Password");
    JLabel phoneNumLabel = new JLabel("Phone Number");
    JLabel adminPassLabel = new JLabel("Admin Password");

    JTextField accountIDField = new JTextField();
    JTextField userTextField = new JTextField();
    JTextField userPasswordField = new JTextField();
    JTextField phoneNumField = new JTextField();
    JPasswordField adminPasswordField = new JPasswordField();

    String[] genderType = {"Male", "Female"};
    JComboBox<String> genderTypeCB = new JComboBox<>(genderType);
    JLabel genderLabel = new JLabel("Gender");




    AdminAddUser() throws FileNotFoundException {

        JPanel panel = new JPanel();
        panel.setLayout(null);

        addBtn.addActionListener(this);
        BackBtn.addActionListener(this);

        //main info
        userTypeLabel.setBounds(25,30,100,30);
        accountIDLabel.setBounds(25,60,100,30);
        userLabel.setBounds(25,90,100,30);
        userPassLabel.setBounds(25,120,100,30);
        phoneNumLabel.setBounds(25, 150, 100, 30);
        genderLabel.setBounds(25, 180, 100, 30);
        adminPassLabel.setBounds(25,210,150,30);


        userTypeCB.setBounds(135,30,150,30);
        accountIDField.setBounds(135, 60, 150, 30);
        userTextField.setBounds(135,90,150,30);
        userPasswordField.setBounds(135,120,150,30);
        phoneNumField.setBounds(135, 150, 150, 30);
        genderTypeCB.setBounds(135,180,150,30);
        adminPasswordField.setBounds(135,210,150,30);


        addBtn.setBounds(20,300,100,40);
        BackBtn.setBounds(150,300,150,40);

        //additional info

        panel.add(userTypeLabel);
        panel.add(accountIDLabel);
        panel.add(userLabel);
        panel.add(userPassLabel);
        panel.add(phoneNumLabel);
        panel.add(genderLabel);
        panel.add(adminPassLabel);

        panel.add(accountIDField);
        panel.add(userTypeCB);
        panel.add(userTextField);
        panel.add(userPasswordField);
        panel.add(phoneNumField);
        panel.add(genderTypeCB);
        panel.add(adminPasswordField);
        panel.add(addBtn);
        panel.add(BackBtn);

        this.add(panel);
        this.setTitle("Manage Admin");
        this.setSize(350, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AdminAddUser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn){
            String addAccount = accountIDField.getText();
            String addUser = userTextField.getText();
            String addPass = userPasswordField.getText();
            String addPhone = phoneNumField.getText();
            String genderType = (String) genderTypeCB.getSelectedItem();
            String adminPass = adminPasswordField.getText();
            String userType = (String) userTypeCB.getSelectedItem();
            if (userType.equals("Select")) {
                JOptionPane.showMessageDialog(this,"Please Select User Type");
            } else if (addAccount == null || addUser == null || addPass == null || addPhone == null || genderType == null) {
                JOptionPane.showMessageDialog(this,"Please fill in the form");
            } else {
                String accountID = "";
                if (userType.equals("Admin"))
                    accountID += "AD";
                if (userType.equals("Agent"))
                    accountID += "AG";
                if (userType.equals("Tenant"))
                    accountID += "TN";
                accountID += addAccount;
                String[] result = {accountID,addUser,addPass,addPhone,genderType};
                String[][] check;
                try {
                    data.setMainInfo(FileConverter.getSingleLineInfo("account.txt", "AD1234"));
                    check = FileConverter.readAllLines("account.txt");
                    if (adminPass.equals(data.getPassword())) {
                        int checkNum = 0;
                        for (String[] strings : check) {
                            if (Objects.equals(strings[0], accountID)) {
                                checkNum++;
                            }
                        }
                        if (checkNum > 0) {
                            JOptionPane.showMessageDialog(this, "Account Already Exist");
                        } else {
                            // TODO: 10/10/2021 ADD ADMIN PASSWORD FOR ADMIN
                            JOptionPane.showMessageDialog(this, "Added Successful");
                            FileConverter.appendFile("account.txt", result);
                            this.dispose();
                            new AdminMainPage("Myvi","AD1234");
                        }
                    }else {
                        JOptionPane.showMessageDialog(this, "Incorrect Password");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}