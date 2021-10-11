package Admin;

import DataSystem.AdminData;
import DataSystem.Data;
import DataSystem.TenantData;
import FileSystem.FileConverter;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;


public class AdminMainPage extends JFrame {
    AdminMainPage(String pictureName,String accountID) throws FileNotFoundException {
        // TODO: 08/10/2021 make is reusable for 3 users

        AdminData data = new AdminData("Adib",3);

        JPanel welcomePanel = new JPanel();
        JPanel btnPanel = new JPanel(new GridLayout(4,0));
        JSplitPane finalPanel = new JSplitPane();

        // welcomePanel
        ImageIcon img = new ImageIcon("src/Pictures/" + pictureName + ".jpg");
        Image scaledImg = img.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        Icon finalImg = new ImageIcon(scaledImg);
        JLabel pictureLabel = new JLabel();
        pictureLabel.setIcon(finalImg);
        pictureLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel welcomeLabel = new JLabel("Welcome " + data.getName() + "!");
        welcomeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel notifLabel = new JLabel();
        if (data.getUserRequestNotification()==0)
            notifLabel.setText("You don't have any notification");
        else
            notifLabel.setText("You have " + data.getUserRequestNotification()
            + " Notification");
        notifLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        //todo: profile button function
        JButton profileBtn = new JButton("Profile");
        profileBtn.setAlignmentX(JLabel.CENTER_ALIGNMENT);


        //Button panel
        //todo: letak each button functionality
        JButton systemReportBtn = new JButton("Manage Property");
        JButton manageUserBtn = new JButton("Manage User");
        JButton backToMainBtn = new JButton("Back to Main");


        welcomePanel.setLayout(new BoxLayout(welcomePanel,BoxLayout.Y_AXIS));
        welcomePanel.setBackground(new Color(0xD9533A));
        welcomePanel.add(pictureLabel);
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 15)));
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(notifLabel);
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 40)));
        welcomePanel.add(profileBtn);

        btnPanel.setBackground(new Color(0x3957B7));
        btnPanel.add(systemReportBtn);
        btnPanel.add(manageUserBtn);
        btnPanel.add(backToMainBtn);

        finalPanel.setDividerLocation(350);
        finalPanel.setDividerSize(0);
        finalPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        finalPanel.setLeftComponent(welcomePanel);
        finalPanel.setRightComponent(btnPanel);




        this.add(finalPanel);
        this.setTitle("Admin page");
        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) throws FileNotFoundException {
        new AdminMainPage("Myvi","AD1234");

    }
}
