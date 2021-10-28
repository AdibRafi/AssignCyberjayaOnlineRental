package Adib;

import DataSystem.Data;
import FileSystem.FileConverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class AddUser extends JFrame implements ActionListener {
    Data accountData = new Data();
    JFrame frame = new JFrame();

    String[] userType = {"Select", "Adib", "Ariez", "Darwisy"};
    JComboBox<String> userTypeCB = new JComboBox<>(userType);
    JLabel userTypeLabel = new JLabel("User Type");

    JButton addBtn = new JButton("Add");
    JButton backBtn = new JButton("Back to Main Menu");

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



    String profileAccountID;
    AddUser(String profileAccountID) throws FileNotFoundException {
        this.profileAccountID = profileAccountID;

        JPanel panel = new JPanel();
        panel.setLayout(null);

        addBtn.addActionListener(this);
        backBtn.addActionListener(this);

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
        backBtn.setBounds(150,300,150,40);

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
        panel.add(backBtn);

        frame.add(panel);
        frame.setTitle("Add User");
        frame.setSize(350, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
                if (userType.equals("Adib"))
                    accountID += "AD";
                if (userType.equals("Ariez"))
                    accountID += "AG";
                if (userType.equals("Darwisy"))
                    accountID += "TN";
                accountID += addAccount;
                String[] result = {accountID,addUser,addPass,addPhone,genderType};
                String[][] check;
                try {
                    accountData.setMainInfo(FileConverter.getSingleLineInfo("account.txt", "AD1234"));
                    check = FileConverter.readAllLines("account.txt");
                    if (adminPass.equals(accountData.getPassword())) {
                        int checkNum = 0;
                        for (String[] strings : check) {
                            if (Objects.equals(strings[0], accountID)) {
                                checkNum++;
                            }
                        }
                        if (checkNum > 0) {
                            JOptionPane.showMessageDialog(frame, "Account Already Exist");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Added Successful");
                            FileConverter.appendFile("account.txt", result);
                            frame.dispose();
                            new ProfileMainPage("Myvi", profileAccountID);
                        }
                    }else {
                        JOptionPane.showMessageDialog(frame, "Incorrect Password");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (e.getSource() == backBtn){
            frame.dispose();
            try {
                new ManageUser(profileAccountID);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
//    public static void main(String[] args) throws FileNotFoundException {
//        new AddUser("AD1234");
//    }
}
