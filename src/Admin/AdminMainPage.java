package Admin;

import Agent.agentAddPropety;
import Agent.mainDisplay;
import DataSystem.Data;
import FileSystem.FileConverter;
import Tenant.TenantManageProfile;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class AdminMainPage extends JFrame {
    public AdminMainPage(String pictureName, String accountID) throws IOException {

        Data data = new Data();
        data.setMainInfo(FileConverter.getSingleLineInfo("account.txt", accountID));
        int userType = Data.checkTypeUser(accountID);
        JPanel welcomePanel = new JPanel();
        JPanel btnPanel = new JPanel(new GridLayout(4, 0));
        JSplitPane finalPanel = new JSplitPane();

        // welcomePanel
        ImageIcon img = new ImageIcon("src/Pictures/" + pictureName + ".png");
        Image scaledImg = img.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        Icon finalImg = new ImageIcon(scaledImg);
        JLabel pictureLabel = new JLabel();
        pictureLabel.setIcon(finalImg);
        pictureLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel welcomeLabel = new JLabel("Welcome " + data.getName() + "!");
        welcomeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel accountIDLabel = new JLabel("Account ID: " + data.getAccountID());
        accountIDLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel phoneNumberLabel = new JLabel("Phone Number: " + data.getPhoneNumber());
        phoneNumberLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel genderLabel = new JLabel("Gender: " + data.getGender());
        genderLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);


        //Button panel
        JButton profileBtn = new JButton("Manage Profile");
        String firstBtnName = "";
        String secondBtnName = "";
        if (userType == 1) {
            firstBtnName = "Manage Property";
            secondBtnName = "Add Property";
        } else if (userType == 2) {
            firstBtnName = "Manage User";
            secondBtnName = "Manage Property";
        }

        JButton firstBtn = new JButton(firstBtnName);
        JButton secondBtn = new JButton(secondBtnName);
        JButton backToMainBtn = new JButton("Back to Main");

        // tenant = 0, agent = 1, admin = 2
        profileBtn.addActionListener(e -> {
            this.dispose();
            try {
                new TenantManageProfile(accountID);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        firstBtn.addActionListener(e ->{
            if (userType == 1) {
                this.dispose();
                try {
                    new AdminManageProperty(data.getAccountID());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (userType == 2) {
                try {
                    this.dispose();
                    new AdminManageUser();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        secondBtn.addActionListener(e -> {
            if (userType == 1) {
                this.dispose();
                new agentAddPropety(data.getAccountID(),true);
            }
            if (userType == 2) {
                this.dispose();
                try {
                    new AdminManageProperty(data.getAccountID());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        backToMainBtn.addActionListener(e -> {
            this.dispose();
            try {
                new mainDisplay(true, mainDisplay.resetAllInfo(),accountID);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.setBackground(new Color(0xD9533A));
        welcomePanel.add(pictureLabel);
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 15)));
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 40)));
        welcomePanel.add(accountIDLabel);
        welcomePanel.add(phoneNumberLabel);
        welcomePanel.add(genderLabel);

        btnPanel.setBackground(new Color(0x3957B7));
        btnPanel.add(profileBtn);
        btnPanel.add(firstBtn);
        btnPanel.add(secondBtn);
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

    public static void main(String[] args) throws IOException {
        new AdminMainPage("Myvi", "TN3254");

    }
}
