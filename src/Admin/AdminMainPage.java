package Admin;

import DataFile.AdminData;
import DataFile.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainPage extends JFrame implements ActionListener {
    AdminMainPage(String pictureName){
        AdminData data = new AdminData("Adib",3);

        JPanel welcomePanel = new JPanel();
        JPanel btnPanel = new JPanel(new GridLayout(3,0));
        JSplitPane finalPanel = new JSplitPane();

        // welcomePanel
        ImageIcon img = new ImageIcon("src/Pictures/" + pictureName + ".jpg");
        Image scaledImg = img.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        Icon finalImg = new ImageIcon(scaledImg);
        JLabel pictureLabel = new JLabel();
        pictureLabel.setIcon(finalImg);
        pictureLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel welcomeLabel = new JLabel("Welcome " + data.getName());
        welcomeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel notifLabel = new JLabel();
        if (data.getUserRequestNotification()==0)
            notifLabel.setText("You don't have any notification");
        else
            notifLabel.setText("You have " + data.getUserRequestNotification()
            + " Notification");
        notifLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JButton requestBtn = new JButton("User Request");
        JButton displayTenantBtn = new JButton("Display Tenant");
        JButton manageAdminBtn = new JButton("Manage Admin");


        welcomePanel.setLayout(new BoxLayout(welcomePanel,BoxLayout.Y_AXIS));
        welcomePanel.setBackground(new Color(0xD9533A));
        welcomePanel.add(pictureLabel);
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 15)));
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(notifLabel);

        btnPanel.setBackground(new Color(0x3957B7));
        btnPanel.add(requestBtn);
        btnPanel.add(displayTenantBtn);
        btnPanel.add(manageAdminBtn);

        finalPanel.setDividerLocation(350);
        finalPanel.setDividerSize(0);
        finalPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        finalPanel.setLeftComponent(welcomePanel);
        finalPanel.setRightComponent(btnPanel);




        this.add(finalPanel);
        this.setTitle("Admin page");
        this.setSize(500, 250);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new AdminMainPage("Myvi");

    }
}
