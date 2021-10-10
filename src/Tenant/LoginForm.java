package Tenant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {

    JFrame frame;

    Container container = getContentPane();
    JPanel titlePanel = new JPanel();
    JLabel titleLabel = new JLabel("myProperty House Rental", JLabel.CENTER);
    JLabel title2Label = new JLabel("Log in", JLabel.CENTER);

    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginBtn = new JButton("Login");
    JButton resetBtn = new JButton("Reset");
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
        frame.setBounds(10,10,370,450);
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
        userLabel.setBounds(50,100,100,30); //150
        passwordLabel.setBounds(50,170,100,30); //220
        userTextField.setBounds(150,100,150,30); //150
        passwordField.setBounds(150,170,150,30); // 220
        showPassword.setBounds(150,200,150,30); //250
        loginBtn.setBounds(50,270,100,30); //300
        resetBtn.setBounds(200,270,100,30); //300
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
        new LoginForm();
    }
}
