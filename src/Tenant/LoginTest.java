package Tenant;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginTest extends JFrame implements ActionListener {
    JPanel panel;
    JLabel userLabel, passwordLabel, message;
    JTextField usernameText;
    JPasswordField passwordText;
    JButton enter;

    LoginTest(){
        //UserLabel
        userLabel = new JLabel();
        userLabel.setText("Enter your Username: ");
        usernameText = new JTextField();

        //PasswordLabel
        passwordLabel = new JLabel();
        passwordLabel.setText("Password: ");
        passwordText = new JPasswordField();



        //Enter Button
        enter = new JButton("Log in");
        panel = new JPanel(new GridLayout(3,1));
        panel.add(userLabel);
        panel.add(usernameText);
        panel.add(passwordLabel);
        panel.add(passwordText);

        message = new JLabel();
        panel.add(message);
        panel.add(enter);


        enter.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Login page");
        setSize(500,450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new LoginTest();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = usernameText.getText();
        String password = passwordText.getText();

        if(userName.trim().equals("Adib") && password.trim().equals("tenant123")){
            message.setText("Welcome "+ userName + "");
        }else{
            message.setText("Invalid user");
        }
    }
}
