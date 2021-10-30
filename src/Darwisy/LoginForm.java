package Darwisy;

import Ariez.MainDisplay;
import DataSystem.Data;
import FileSystem.FileConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

/**
 * Represent Login form for users
 * @author Darwisy
 */
public class LoginForm extends JFrame implements ActionListener {
    JFrame frame;

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
    JButton backBtn = new JButton("Back");
    Data accountData;

    //Constructor
    /**
     * Start GUI for Login form
     * @throws IOException Occurred when I/O operation is interrupted or failed
     * @author Darwisy
     */
    public LoginForm() throws IOException {
        createWindow();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    /**
     * Create a window for GUI
     * @author Darwisy
     */
    public void createWindow(){
        frame = new JFrame();
        frame.setTitle("Login Form");
        frame.setLayout(new BorderLayout());
        titlePanel.setBackground(Color.darkGray);
        frame.setBounds(10,10,370,500);
        frame.getContentPane().setBackground(new Color(51,153,255));
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
    }

    /**
     * Set location for each component into GUI
     * @author Darwisy
     */
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
        backBtn.setBounds(120,310,100,30);
        question1.setBounds(90,360,180,30);
        registerBtn.setBounds(120,390,100,30);

    }

    /**
     * Adding component into GUI
     * @author Darwisy
     */
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
        frame.add(backBtn);
        frame.add(question1);
        frame.add(registerBtn);
    }

    /**
     * Initiate ActionListener into component
     * @author Darwisy
     */
    public void addActionEvent() {
        //adding Action listener to components
        loginBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        showPassword.addActionListener(this);
        registerBtn.addActionListener(this);
        backBtn.addActionListener(this);

    }

    /**
     * Perform action when ActionEvent occurred
     * @param e source from LoginForm()
     * @author Darwisy, Adib
     */
    @Override
    public void actionPerformed(ActionEvent e){
        //Login button action
        if(e.getSource() == loginBtn){
            String userText;
            String pswrdText;
            userText = userTextField.getText();
            pswrdText = passwordField.getText();
            boolean findAcc = false;
            try {
                String[][] data = FileConverter.readAllLines("account.txt");
                for (int i = 0; i < data.length; i++) {
                    for (int j = 0; j < data[i].length; j++) {
                        if (data[i][j].equals(userText)) {
                            if (data[i][j+1].equals(pswrdText)){
                                findAcc = true;
                                accountData = new Data();
                                accountData.setMainInfo(data[i]);
                            }
                        }
                    }
                }
                if (findAcc){
                    JOptionPane.showMessageDialog(this,"Login Successful");
                    frame.dispose();
                    new MainDisplay(true, MainDisplay.resetAllInfo(), accountData.getAccountID());

                }
                else JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            } catch (IOException ex) {
                ex.printStackTrace();
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
            new RegisterForm();
            frame.dispose();
        }
        if (e.getSource() == backBtn) {
            try {
                frame.dispose();
                new MainDisplay(false, MainDisplay.resetAllInfo(), "AD1234");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) throws IOException {
//        new LoginForm();
//    }


}
