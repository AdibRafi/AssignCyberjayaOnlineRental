package Tenant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel titleLabel = new JLabel("Cyberjaya Online House Rental", JLabel.CENTER);
    JLabel title2Label = new JLabel("Log in", JLabel.CENTER);
    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginBtn = new JButton("Login");
    JButton resetBtn = new JButton("Reset");
    JCheckBox showPassword = new JCheckBox("Show Password");

    LoginForm(){
        setLayout();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }
    public void setLayout() {
        container.setLayout(null);
    }
    public void setLocationAndSize(){
        //setting location and Size of each components
        titleLabel.setBounds(80,0,200,60);
        title2Label.setBounds(80,30,200,60);
        userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginBtn.setBounds(50,300,100,30);
        resetBtn.setBounds(200,300,100,30);
    }
    public void addComponentsToContainer(){
        //adding each components to the Container
        container.add(titleLabel,BorderLayout.NORTH);
        container.add(title2Label,BorderLayout.CENTER);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginBtn);
        container.add(resetBtn);
    }
    public void addActionEvent() {
        //adding Action listener to components
        loginBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        showPassword.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        //Login button action
        if(e.getSource() == loginBtn){
            String userText;
            String pswrdText;
            userText = userTextField.getText();
            pswrdText = passwordField.getText();
            if(userText.equalsIgnoreCase("Darwisy")&& pswrdText.equalsIgnoreCase("tenant123")){
                JOptionPane.showMessageDialog(this,"Login Successful");
            }else{
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }
        //Reset button
        if(e.getSource() == resetBtn){
            userTextField.setText("");
            passwordField.setText("");
        }
        //showPassword JCheckBox
        if(e.getSource() == showPassword){
            if(showPassword.isSelected()){
                passwordField.setEchoChar((char)0);
            }else{
                passwordField.setEchoChar('*');
            }
        }
    }


}
class Login{
    public static void main(String[] args) {
        LoginForm frame = new LoginForm();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10,10,370,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
