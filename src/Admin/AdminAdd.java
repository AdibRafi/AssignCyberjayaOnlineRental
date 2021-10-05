package Admin;

import DataSystem.AdminData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAdd extends JFrame implements ActionListener {
    AdminData data = new AdminData("mu123");

    JButton addBtn = new JButton("Add");
    JButton BackBtn = new JButton("Back to Main Menu");
    JLabel userLabel = new JLabel("Username");
    JLabel userPassLabel = new JLabel("Password");
    JLabel adminPassLabel = new JLabel("Admin Password");
    JTextField userTextField = new JTextField();
    JTextField userPasswordField = new JTextField();
    JPasswordField adminPasswordField = new JPasswordField();

    AdminAdd(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        addBtn.addActionListener(this);
        BackBtn.addActionListener(this);

        userLabel.setBounds(25,30,100,30);
        userPassLabel.setBounds(25,60,100,30);
        adminPassLabel.setBounds(25,90,150,30);
        userTextField.setBounds(135,30,150,30);
        userPasswordField.setBounds(135,60,150,30);
        adminPasswordField.setBounds(135,90,150,30);
        addBtn.setBounds(20,135,100,40);
        BackBtn.setBounds(150,135,150,40);

        panel.add(userLabel);
        panel.add(userPassLabel);
        panel.add(adminPassLabel);
        panel.add(adminPasswordField);
        panel.add(userTextField);
        panel.add(userPasswordField);
        panel.add(addBtn);
        panel.add(BackBtn);

        this.add(panel);
        this.setTitle("Manage Admin");
        this.setSize(350, 250);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new AdminAdd();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn){
            //todo: need to append newly Admin info
            String addUser = userTextField.getText();
            String addPass = userPasswordField.getText();
            String adminPass = adminPasswordField.getText();
            if (adminPass.equals(data.getAdminPassword())){
                JOptionPane.showMessageDialog(this, "Added Successful");
                this.dispose();
                new AdminMainPage("Myvi");
            }
            else{
                JOptionPane.showMessageDialog(this,"Incorrect Password");
            }
        }
    }
}
