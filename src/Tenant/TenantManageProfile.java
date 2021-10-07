package Tenant;

import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TenantManageProfile extends JFrame implements ActionListener {
    JFrame frame;

    String[] gender = {"Male", "Female"};
    JLabel nameLabel = new JLabel("Name");
    JLabel genderLabel = new JLabel("Gender");
    JLabel newPasswordLabel = new JLabel("New Password");
    JLabel confirmNewPasswordLabel = new JLabel("Confirm New Password");
    JLabel cityLabel = new JLabel("City");
    JLabel contactLabel = new JLabel("Contact");
    JLabel emailLabel = new JLabel("Email");

    JTextField nameTextField = new JTextField();
    JComboBox genderComboBox = new JComboBox(gender);
    JPasswordField newPasswordField = new JPasswordField();
    JPasswordField confirmNewPasswordField = new JPasswordField();
    JTextField cityTextField = new JTextField();
    JTextField contactTextField = new JTextField();
    JTextField emailTextField = new JTextField();

    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton cancelBtn = new JButton("Cancel");
    JButton deleteBtn = new JButton("Delete");

    JCheckBox showNewPassword = new JCheckBox("Show Password");
    JCheckBox showConfirmPassword = new JCheckBox("Show Password");


    TenantManageProfile(){
        createWindow();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Tenant Profile Manager");
        frame.setBounds(40,40,400,600);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    private void setLocationAndSize() {
        nameLabel.setBounds(20,20,40,70);
        genderLabel.setBounds(20,70,80,70);
        newPasswordLabel.setBounds(20,120,100,70);
        confirmNewPasswordLabel.setBounds(20,170,140,70);
        cityLabel.setBounds(20,220,100,70);
        contactLabel.setBounds(20,270,100,70);
        emailLabel.setBounds(20,320,100,70);

        nameTextField.setBounds(180,43,165,23);
        genderComboBox.setBounds(180,93,165,23);
        newPasswordField.setBounds(180,143,165,23);
        showNewPassword.setBounds(180,163,165,23);
        confirmNewPasswordField.setBounds(180,193,165,23);
        showConfirmPassword.setBounds(180,213,165,23);
        cityTextField.setBounds(180,243,165,23);
        contactTextField.setBounds(180,293,165,23);
        emailTextField.setBounds(180,343,165,23);

        saveBtn.setBounds(70,400,100,35);
        resetBtn.setBounds(220,400,100,35);
        cancelBtn.setBounds(70,450,100,35);
        deleteBtn.setBounds(220,450,100,35);

    }
    public void addComponentToFrame() {
        frame.add(nameLabel);
        frame.add(genderLabel);
        frame.add(newPasswordLabel);
        frame.add(confirmNewPasswordLabel);
        frame.add(cityLabel);
        frame.add(contactLabel);
        frame.add(emailLabel);

        frame.add(nameTextField);
        frame.add(genderComboBox);
        frame.add(newPasswordField);
        frame.add(showNewPassword);
        frame.add(confirmNewPasswordField);
        frame.add(showConfirmPassword);
        frame.add(cityTextField);
        frame.add(contactTextField);
        frame.add(emailTextField);

        frame.add(saveBtn);
        frame.add(resetBtn);
        frame.add(cancelBtn);
        frame.add(deleteBtn);
    }
    public void actionEvent() {
        saveBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
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
        if(ae.getSource() == saveBtn){//todo: make save button//
             }
        if(ae.getSource() == resetBtn){
                //Clearing Fields
                nameTextField.setText("");
                genderComboBox.setSelectedItem("Male");
                newPasswordField.setText("");
                confirmNewPasswordField.setText("");
                cityTextField.setText("");
                contactTextField.setText("");
                emailTextField.setText("");
        }
        if(ae.getSource() == cancelBtn){//todo: press cancel button and will bring back to tenant profile//
             }
        if(ae.getSource() == deleteBtn){//todo: to delete account//
             }

    }

}

class Tenant{
    public static void main(String[] args) {
        new TenantManageProfile();
    }
}
