package Agent;

import FileSystem.FileConverter;

import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class learnMore extends JFrame  {
    static JPanel mainContainer;
    static CardLayout cl;

    JPanel homePanel;
    JPanel learnMorePanel;
    JFrame mFrame;
    JButton back;
    JButton one;
    JButton two;
    JButton three;
    JButton[] buttonArray;
    JLabel[] dataLocation;
    JLabel[] dataFacilities;
    String[][] arrayLocation;
    String[][] arrayFacilities;


    public learnMore(String image, int account, int row) {
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        // different button for each account
        //todo : assign function dekat button (user)
        if (account == 1) { // if account user
            one = new JButton("Apply");
            one.addActionListener(event -> JOptionPane.showMessageDialog(null, "Apply button was pushed!"));

            two = new JButton("Contact");
            two.addActionListener(event -> JOptionPane.showMessageDialog(null, "Contact button was pushed!"));
        }

        //todo : assign function dekat button (agent)
        if (account == 2) { // if account agent
            one = new JButton("Manage Property");
            one.addActionListener(event -> JOptionPane.showMessageDialog(null, "Manage Property button was pushed!"));

            two = new JButton("Delete");
            two.addActionListener(event -> JOptionPane.showMessageDialog(null, "Delete button was pushed!"));
        }

        //todo : assign function dekat button (admin)
        if (account == 3) { // if account admin
            one = new JButton("Leave Comment");
            one.addActionListener(event -> JOptionPane.showMessageDialog(null, "Leave Comment button was pushed!"));

            two = new JButton("Manage Property");
            two.addActionListener(event -> JOptionPane.showMessageDialog(null, "Manage Property button was pushed!"));

            three = new JButton("Delete");
            three.addActionListener(event -> JOptionPane.showMessageDialog(null, "Delete button was pushed!"));

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        // put data in array
        try {
            arrayLocation = FileConverter.readAllLines("location.txt");
            arrayFacilities = FileConverter.readAllLines("locationFacilities.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        cl = new CardLayout(10, 10); // create cardlayout
        homePanel = new JPanel(); // panel for main menu
        buttonArray = new JButton[arrayLocation.length]; // create button in array

        back = new JButton("Back"); // create back button (return to menu)
        back.addActionListener(event -> {
            cl.show(mainContainer, "Back");
        });

        mFrame = new JFrame("learn more test");

        mainContainer = new JPanel(cl);
        learnMorePanel = new JPanel();
        learnMorePanel.setLayout(null);

        // test back button (follow button yang ditekan)
        for (int j = 0; j < arrayLocation.length; j++) {
            buttonArray[j] = new JButton("Learn More");
            buttonArray[j].addActionListener(event -> {
                int indicator = 0 ;
                for (int n = 0; n < arrayLocation.length; n++) {
                    if (event.getSource() == buttonArray[n])
                        indicator = n;
                        mFrame.dispose();
                }
                new learnMore(image, account,indicator);
                cl.show(mainContainer, "Learn More");
            });
            homePanel.add(buttonArray[j]);
        }
        JLabel price = new JLabel("Price");
        JLabel location = new JLabel("Location");
        JLabel facilities = new JLabel("Facilities");
        String[] arr1 ={"Size                     ", "Bathroom           ", "Bedroom            ", "Parking               ", "Furnished           ", "Wifi                      ", "Swimming Pool  ", "Air Cond              "};
        String[] arr2 ={"House Number ", "Street                 ", "City                     ", "Postcode           ", "State                   ", "Status                 "};

        //set boundary for text "Location" & add to panel
        location.setFont(new Font("Serif", Font.PLAIN, 40));
        location.setBounds(250,5,400,40);
        learnMorePanel.add(location); // text "Location"

        //set boundary for text "Price" & add to panel
        price.setFont(new Font("Serif", Font.PLAIN, 25));
        price.setBounds(455,230,200,30);
        learnMorePanel.add(price); // text "Price"

        int gap = 25;
        for (int k = 0; k < 7; k++) {
            dataLocation = new JLabel[7];
            if (k == 0) {
                dataLocation[k] = new JLabel("RM " + arrayLocation[row][k + 2]);
                dataLocation[k].setFont(new Font("Serif", Font.PLAIN, 25));
                dataLocation[k].setBounds(455,260,200,30);
                learnMorePanel.add(dataLocation[k]);
            } if(k > 0 ) {
                dataLocation[k] = new JLabel(arr2[k-1] +" : " + arrayLocation[row][k + 2]);
                dataLocation[k].setBounds(250,gap,200,30);
                learnMorePanel.add(dataLocation[k]);
            }gap +=30 ;
        }
        gap +=70;

        //set boundary for text "Facilities" & add to panel
        facilities.setFont(new Font("Serif", Font.PLAIN, 40));
        facilities.setVerticalAlignment(JLabel.CENTER);
        facilities.setBounds(250,250,400,40);
        learnMorePanel.add(facilities); // text "Facilities"

        for (int k = 0; k < 8; k++) {
            dataFacilities = new JLabel[8];
            if (k == 0) {
                dataFacilities[k] = new JLabel(arr1[k] + " : " + arrayFacilities[row][k+1] + " sq. ft");
                dataFacilities[k].setBounds(250,gap,200,30);
                learnMorePanel.add(dataFacilities[k]);
            }if (k > 0){
                dataFacilities[k] = new JLabel(arr1[k] + " : " + arrayFacilities[row][k + 1]);
                dataFacilities[k].setBounds(250, gap, 200, 30);
                learnMorePanel.add(dataFacilities[k]);
            }gap += 30;
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////
        if(account == 3) {
            // set boundary for button & add to panel (admin - four button)
            one.setBounds(15, 570, 140, 30);
            two.setBounds(150, 570, 140, 30);
            three.setBounds(285, 570, 140, 30);
            back.setBounds(420, 570, 140, 30);
            learnMorePanel.add(one); // letak button(base on account) at learn more punya panel
            learnMorePanel.add(two); // letak second button(base on account) at learn more punya panel
            learnMorePanel.add(three); // letak third button (delete) at learn more punya panel
            learnMorePanel.add(back); // letak back button at learn more punya panel

        }else {
            // set boundary for button & add to panel (user/agent - three button)
            one.setBounds(95, 570, 140, 30);
            two.setBounds(230, 570, 140, 30);
            back.setBounds(365, 570, 140, 30);
            learnMorePanel.add(one); // letak button(base on account) at learn more punya panel
            learnMorePanel.add(two); // letak second button(base on account) at learn more punya panel
            learnMorePanel.add(back); // letak back button at learn more punya panel
        }
        ImageIcon img = new ImageIcon("src/Pictures/" + image + ".jpg");
        Image scaledImg = img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        Icon finalImg = new ImageIcon(scaledImg);
        JLabel pictureLabel = new JLabel();
        pictureLabel.setIcon(finalImg);
        pictureLabel.setBounds(25,70,200,200);
        //pictureLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        learnMorePanel.add(pictureLabel);
        mainContainer.add(learnMorePanel, "Other Panel");
        mainContainer.add(homePanel, "Back");

        mFrame.add(mainContainer);
        cl.show(mainContainer, "Home");
        mFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mFrame.pack();
        mFrame.setVisible(true);
        mFrame.setSize(610, 670);
    }

    public static void main(String[] args) {
        new learnMore("Myvi",3, 0); //row ikut button yang tekan
    }
}