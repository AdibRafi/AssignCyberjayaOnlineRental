package Adib;

import Ariez.AddOrUpdateProperty;
import Ariez.MainDisplay;
import DataSystem.Data;
import FileSystem.FileConverter;
import Darwisy.EditProfile;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Represent Profile Page for users
 * @author Adib
 */
public class ProfileMainPage extends JFrame {
    /**
     * Start GUI for ProfileMainPage
     * @param pictureName Name of the picture in Picture package
     * @param profileAccountID AccountID that already log in
     * @throws IOException Occurred when I/O operation is interrupted or failed
     * @author Adib, Darwisy
     */
    public ProfileMainPage(String pictureName, String profileAccountID) throws IOException {

        Data data = new Data();
        data.setMainInfo(FileConverter.getSingleLineInfo("account.txt", profileAccountID));
        int userType = Data.checkTypeUser(profileAccountID);
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
                new EditProfile(profileAccountID);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        firstBtn.addActionListener(e ->{
            if (userType == 1) {
                this.dispose();
                try {
                    new ManageProperty(data.getAccountID());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (userType == 2) {
                try {
                    this.dispose();
                    new ManageUser(profileAccountID);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        secondBtn.addActionListener(e -> {
            if (userType == 1) {
                this.dispose();
                try {
                    new AddOrUpdateProperty(data.getAccountID(),true
                            , "",true,data.getAccountID(), MainDisplay.resetAllInfo(),true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (userType == 2) {
                this.dispose();
                try {
                    new ManageProperty(data.getAccountID());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        backToMainBtn.addActionListener(e -> {
            this.dispose();
            try {
                new MainDisplay(true, MainDisplay.resetAllInfo(),profileAccountID);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.setBackground(new Color(51,153,255));
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
        this.setTitle("Profile page");
        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

//    public static void main(String[] args) throws IOException {
//        new ProfileMainPage("Myvi", "AD1234");
//    }
}
