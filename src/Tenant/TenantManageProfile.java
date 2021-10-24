package Tenant;

import Admin.AdminMainPage;
import DataSystem.Data;
import FileSystem.FileConverter;

import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TenantManageProfile extends JFrame implements ActionListener {
    JFrame frame;

    String[] gender = {"male", "female"};
    JLabel nameLabel = new JLabel("New UserName");
    JLabel genderLabel = new JLabel("Gender");
    JLabel newPasswordLabel = new JLabel("New Password");
    JLabel confirmNewPasswordLabel = new JLabel("Confirm New Password");
    JLabel contactLabel = new JLabel("New Contact");

    JTextField nameTextField = new JTextField();
    JComboBox genderComboBox = new JComboBox(gender);
    JPasswordField newPasswordField = new JPasswordField();
    JPasswordField confirmNewPasswordField = new JPasswordField();
    JTextField contactTextField = new JTextField();

    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton cancelBtn = new JButton("Cancel");

    JCheckBox showNewPassword = new JCheckBox("Show Password");
    JCheckBox showConfirmPassword = new JCheckBox("Show Password");

    Data accountData = new Data();

    //Constructor
    public TenantManageProfile(String profileAccountID) throws IOException {
        accountData.setMainInfo(FileConverter.getSingleLineInfo("account.txt",profileAccountID));
        createWindow();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Tenant Profile Manager");
        frame.setBounds(40,40,400,600);
        frame.getContentPane().setBackground(new Color(51,153,255));
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    private void setLocationAndSize() {
        nameLabel.setBounds(20,20,100,70);
        genderLabel.setBounds(20,70,80,70);
        newPasswordLabel.setBounds(20,120,100,70);
        confirmNewPasswordLabel.setBounds(20,170,140,70);
        contactLabel.setBounds(20,220,100,70);


        nameTextField.setBounds(180,43,165,23);
        genderComboBox.setBounds(180,93,165,23);
        newPasswordField.setBounds(180,143,165,23);
        showNewPassword.setBounds(180,163,165,23);
        confirmNewPasswordField.setBounds(180,193,165,23);
        showConfirmPassword.setBounds(180,213,165,23);
        contactTextField.setBounds(180,243,165,23);

        saveBtn.setBounds(70,400,100,35);
        resetBtn.setBounds(220,400,100,35);
        cancelBtn.setBounds(145,450,100,35);

    }
    public void addComponentToFrame() {
        frame.add(nameLabel);
        frame.add(genderLabel);
        frame.add(newPasswordLabel);
        frame.add(confirmNewPasswordLabel);
        frame.add(contactLabel);

        frame.add(nameTextField);
        frame.add(genderComboBox);
        frame.add(newPasswordField);
        frame.add(showNewPassword);
        frame.add(confirmNewPasswordField);
        frame.add(showConfirmPassword);
        frame.add(contactTextField);

        frame.add(saveBtn);
        frame.add(resetBtn);
        frame.add(cancelBtn);
    }
    public void actionEvent() {
        saveBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        showNewPassword.addActionListener(this);
        showConfirmPassword.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == showNewPassword){
            if(showNewPassword.isSelected()){
                newPasswordField.setEchoChar((char)0);
            }else{
                newPasswordField.setEchoChar('*');
            }
        }
        if(ae.getSource() == showConfirmPassword){
            if(showConfirmPassword.isSelected()){
                confirmNewPasswordField.setEchoChar((char)0);
            }else{
                confirmNewPasswordField.setEchoChar('*');
            }
        }
        if(ae.getSource() == saveBtn){
            try {
                String[] oldInfoFromData = accountData.getMainInfo();
                String[] newInfo = {accountData.getAccountID(),nameTextField.getText(),newPasswordField.getText(),
                        contactTextField.getText(), (String) genderComboBox.getSelectedItem()};
                accountData.setMainInfo(newInfo);
                FileConverter.updateFile("account.txt",oldInfoFromData, accountData.getMainInfo());
                JOptionPane.showMessageDialog(frame,"New info has been saved");
                frame.dispose();
                new AdminMainPage("Myvi", accountData.getAccountID());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(ae.getSource() == resetBtn){
                //Clearing Fields
                nameTextField.setText("");
                genderComboBox.setSelectedItem("Male");
                newPasswordField.setText("");
                confirmNewPasswordField.setText("");
                contactTextField.setText("");
        }
        if(ae.getSource() == cancelBtn){
            try {
                frame.dispose();
                new AdminMainPage("Myvi", accountData.getAccountID());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new TenantManageProfile("AG2345");
    }
}
