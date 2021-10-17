
import FileSystem.FileConverter;
import Tenant.*;
import Tenant.LoginForm;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class mainDisplay implements ActionListener {
    JFrame frame;

    JPanel topPanel = new JPanel();
    JLabel titleLabel = new JLabel("myProperty House Rental");
    JButton panelBtn = new JButton("Login/Register");


     mainDisplay() {
        createWindow();
        setSize();
        addComponent();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Main frame");
        frame.setBounds(40,40,780,680);
        topPanel.setBackground(Color.darkGray);
        topPanel.setLayout(new BorderLayout());
        topPanel.setBorder(new LineBorder(Color.darkGray,3));
        frame.getContentPane().setBackground(Color.cyan);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setSize(){
        topPanel.setBounds(0,0,780,60);



    }
    public void addComponent(){
        frame.add(topPanel);
        topPanel.add(titleLabel);
        topPanel.add(panelBtn, BorderLayout.LINE_END);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Papyrus", Font.BOLD,20));


    }
    public void actionEvent(){
        panelBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == panelBtn){
            new LoginForm();
        }
    }
}

class Main {
    public static void main(String[] args) {
        new mainDisplay();
    }
}

