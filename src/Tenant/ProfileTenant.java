package Tenant;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileTenant implements ActionListener {
    JFrame frame;

    //String[];
    JLabel usernameLabel = new JLabel("Username");
    JLabel genderLabel = new JLabel("Gender");
    JLabel PasswordLabel = new JLabel("Password");
    JLabel contactLabel = new JLabel("Contact");
    JLabel emailLabel = new JLabel("Email");

    JTextField usernameTextField = new JTextField("Darwisy");
    JTextField genderTextField = new JTextField("Male");
    JPasswordField passwordField = new JPasswordField("apple");
    JTextField contactTextField = new JTextField("01293847564");
    JTextField emailTextField = new JTextField("1191100792@student.mmu.edu.my");


    JButton manageBtn = new JButton("Edit Profile");
    //JCheckBox showPass = new JCheckBox("Show Current Password");

    //Constructor
    ProfileTenant(){
        createWindow();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }
    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Tenant's Profile");
        frame.setBounds(40,40,380,500);
        frame.getContentPane().setBackground(Color.cyan);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize() {
        usernameLabel.setBounds(20,20,100,70);
        genderLabel.setBounds(20,70,80,70);
        PasswordLabel.setBounds(20,120,100,70);
        contactLabel.setBounds(20,170,140,70);
        emailLabel.setBounds(20,220,100,70);

        usernameTextField.setBounds(180,43,165,23);
        genderTextField.setBounds(180,93,165,23);
        passwordField.setBounds(180,143,165,23);
        //showPass.setBounds(180,163,165,23);
        contactTextField.setBounds(180,193,165,23);
        emailTextField.setBounds(180,243,165,23);


        manageBtn.setBounds(60,350,100,35);

    }
    public void addComponentToFrame(){
        frame.add(usernameLabel);
        frame.add(genderLabel);
        frame.add(PasswordLabel);
        frame.add(contactLabel);
        frame.add(emailLabel);

        frame.add(usernameTextField);
        frame.add(genderTextField);
        frame.add(passwordField);
        //frame.add(showPass);
        frame.add(contactTextField);
        frame.add(emailTextField);

        frame.add(manageBtn);
    }
    public void actionEvent(){
        manageBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        /*if(e.getSource() == showPass){
            if(showPass.isSelected()){
                passwordField.setEchoChar((char)0);
            }else{
                passwordField.setEchoChar('*');
            }
        }*/
    }
}
class Profile{
    public static void main(String[] args) {
        new ProfileTenant();
    }
}
