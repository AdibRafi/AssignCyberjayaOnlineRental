package Tenant;

import FileSystem.FileConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class LoginForm extends JFrame implements ActionListener {

    JFrame frame;

    Container container = getContentPane();
    JPanel titlePanel = new JPanel();
    JLabel titleLabel = new JLabel("myProperty House Rental", JLabel.CENTER);
    JLabel title2Label = new JLabel("Log in", JLabel.CENTER);

    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JLabel question1 = new JLabel("Do you have an account yet?");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginBtn = new JButton("Login");
    JButton resetBtn = new JButton("Reset");
    JButton registerBtn = new JButton("Register");
    JCheckBox showPassword = new JCheckBox("Show Password");

    //Constructor
    LoginForm(){
        createWindow();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    public void createWindow(){
        frame = new JFrame();
        frame.setTitle("Login Form");
        frame.setLayout(new BorderLayout());
        titlePanel.setBackground(Color.darkGray);
        frame.setBounds(10,10,370,500);
        frame.getContentPane().setBackground(Color.cyan);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize(){
        //setting location and Size of each components
        titlePanel.setBounds(0,0,370,60);
        titleLabel.setBounds(80,0,200,60);
        title2Label.setBounds(80,30,200,60);
        userLabel.setBounds(50,100,100,30);
        passwordLabel.setBounds(50,170,100,30);
        userTextField.setBounds(150,100,150,30);
        passwordField.setBounds(150,170,150,30);
        showPassword.setBounds(150,200,150,30);

        loginBtn.setBounds(50,270,100,30);
        resetBtn.setBounds(200,270,100,30);
        question1.setBounds(90,340,180,30);
        registerBtn.setBounds(120,370,100,30);
    }
    public void addComponentsToContainer(){
        frame.add(titlePanel);
        /*frame.add(titleLabel,BorderLayout.NORTH);
        frame.add(title2Label,BorderLayout.CENTER);*/
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Papyrus", Font.BOLD,20));
        titlePanel.add(title2Label, BorderLayout.LINE_END);
        title2Label.setForeground(Color.white);

        frame.add(userLabel);
        frame.add(passwordLabel);
        frame.add(userTextField);
        frame.add(passwordField);
        frame.add(showPassword);
        frame.add(loginBtn);
        frame.add(resetBtn);
        frame.add(question1);
        frame.add(registerBtn);
    }
    public void addActionEvent() {
        //adding Action listener to components
        loginBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        showPassword.addActionListener(this);
        registerBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        //Login button action
        if(e.getSource() == loginBtn){
            String userText;
            String pswrdText;
            userText = userTextField.getText();
            pswrdText = passwordField.getText();
            // help: to read the username and password from the txt file
            //      then grant access them to login and back to main screen
            try {
                String[] oldInfo = FileConverter.getSingleLineInfo("account.txt","AG2345");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
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
        if(e.getSource() == registerBtn){
            new RegisterTenant();

        }
    }


}
class Login{
    public static void main(String[] args) {
        new LoginForm();
    }
}
