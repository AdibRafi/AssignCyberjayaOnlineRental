package Tenant;

import FileSystem.FileConverter;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterTenant implements ActionListener {

    JFrame frame;

    String[] gender = {"Male", "Female"};
    String[] accID = {"Agent","Tenant"};
    JPanel titlePanel = new JPanel();
    JLabel titleLabel = new JLabel("myProperty House Rental");
    JLabel title2Label = new JLabel("Register");

    JLabel accountIDLabel = new JLabel("Acc ID number");
    JLabel nameLabel = new JLabel("Name");
    JLabel genderLabel = new JLabel("Gender");
    JLabel passwordLabel = new JLabel("Password");
    JLabel confirmPasswordLabel = new JLabel("Confirm Password");
    JLabel contactLabel = new JLabel("Contact");



    JTextField accountIDTextField = new JTextField();
    JComboBox accComboBox = new JComboBox(accID);
    JTextField nameTextField = new JTextField();
    JComboBox genderComboBox = new JComboBox(gender);
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JTextField contactTextField = new JTextField();


    JButton registerBtn = new JButton("Register");
    JButton cancelBtn = new JButton("Cancel");

    JCheckBox showPassword = new JCheckBox("Show Password");
    JCheckBox showConfirmPassword = new JCheckBox("Show Password");

    //constructor
    RegisterTenant(){
        createWindow();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }

    public void createWindow(){
        frame = new JFrame();
        frame.setTitle("Register Form");
        frame.setLayout(new BorderLayout());
        titlePanel.setBackground(Color.darkGray);
        frame.setBounds(40,40,400,600);
        frame.getContentPane().setBackground(Color.cyan);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize() {
        //lPane.setBounds(0,0,380,80);
        titlePanel.setBounds(0,0,400,60);
        /*titleLabel.setBounds(80,0,200,60);
        title2Label.setBounds(80,50,200,60);*/

        accountIDLabel.setBounds(20,50,100,70);
        nameLabel.setBounds(20,100,40,70);//50
        genderLabel.setBounds(20,150,80,70);//100
        passwordLabel.setBounds(20,200,100,70);//150
        confirmPasswordLabel.setBounds(20,250,140,70);//200
        contactLabel.setBounds(20,320,100,70);//250

        accountIDTextField.setBounds(180,73,165,23);//43
        accComboBox.setBounds(180,93,165,23);//63
        nameTextField.setBounds(180,123,165,23);//73
        genderComboBox.setBounds(180,173,165,23);//123
        passwordField.setBounds(180,223,165,23);//173
        showPassword.setBounds(180,243,165,23);//193
        confirmPasswordField.setBounds(180,273,165,23);//223
        showConfirmPassword.setBounds(180,293,165,23);//243
        contactTextField.setBounds(180,343,165,23);//273


        registerBtn.setBounds(60,450,100,35);
        cancelBtn.setBounds(210,450,100,35);
    }
    public void addComponentToFrame(){
        frame.add(titlePanel);
        //titlePanel.add(lPane, BorderLayout.CENTER);
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Papyrus", Font.BOLD,20));
        titlePanel.add(title2Label, BorderLayout.LINE_END);
        title2Label.setForeground(Color.white);
        /*frame.add(titleLabel,BorderLayout.NORTH);
        frame.add(title2Label,BorderLayout.CENTER);*/

        frame.add(accountIDLabel);
        frame.add(nameLabel);
        frame.add(genderLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(contactLabel);

        // String[] = {accountID, name, password, phoneNumber, gender}
        frame.add(accountIDTextField);
        frame.add(accComboBox);
        frame.add(nameTextField);
        frame.add(genderComboBox);
        frame.add(passwordField);
        frame.add(showPassword);
        frame.add(confirmPasswordField);
        frame.add(showConfirmPassword);
        frame.add(contactTextField);


        frame.add(registerBtn);
        frame.add(cancelBtn);
    }
    public void actionEvent(){
        registerBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        showPassword.addActionListener(this);
        showConfirmPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String accountIDNum = accountIDTextField.getText();
        String nameResult = nameTextField.getText();
        String passwordResult = passwordField.getText();
        String contactResult = contactTextField.getText();
        String genderResult = (String) genderComboBox.getSelectedItem();
        String confirmPasswordResult = showConfirmPassword.getText();
        String getUserType = (String) accComboBox.getSelectedItem();

        if(e.getSource() == showPassword){
            if(showPassword.isSelected()){
                passwordField.setEchoChar((char)0);
            }else{
                passwordField.setEchoChar('*');
            }
        }
        if(e.getSource() == showConfirmPassword){
            if(showConfirmPassword.isSelected()){
                confirmPasswordField.setEchoChar((char)0);
            }else{
                confirmPasswordField.setEchoChar('*');
            }
        }
        if(e.getSource() == registerBtn){//todo: save into txt file then goes back to login page//
            String accountID = "";
            if(getUserType.equals("Agent"))
                accountID += "AG";
            if(getUserType.equals("Tenant"))
                accountID += "TN";
            accountID += accountIDNum;
            String[] result = {accountID,nameResult,passwordResult,contactResult,genderResult};
            String[][] check;
            try{
                check = FileConverter.readAllLines("account.txt");
                if(passwordResult.equals(confirmPasswordResult)){
                    int checkNum = 0;
                    for (String[] strings : check) {
                        if (strings[0].equals(accountID))
                            checkNum++;
                    }
                    if(checkNum > 0)
                        JOptionPane.showMessageDialog(frame,"Account is already exist");
                    else{
                        JOptionPane.showMessageDialog(frame,"Register Succesfully, wait for admin to approve");
                        // TODO: 10/10/2021 need to buat file baru UTK APPROVE -adib
                        FileConverter.appendFile("account.txt",result);
                        frame.dispose();

                    }
                }else JOptionPane.showMessageDialog(frame,"Password Confirmation Does Not Match");
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        if(e.getSource() == cancelBtn){//todo: goes back to main page(display properties page)//

        }

    }
}
class Register {
    public static void main(String[] args) {
        new RegisterTenant();
    }
}