package Agent;

import DataSystem.AdminData;
import FileSystem.FileConverter;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static FileSystem.FileConverter.getSingleLineInfo;

public class learnMore extends JFrame  {
    static JPanel mainContainer;
    static CardLayout cl;

    JPanel homePanel;
    JPanel learnMorePanel;
    JFrame mFrame;
    JButton back;
    JButton one;
    JButton two;
    JButton[] buttonArray;
    JLabel[] dataLocation;
    JLabel[] dataFacilities;
    String[][] arrayLocation;
    String[][] arrayFacilities;


    public learnMore(String image, int account, int row) {
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        // different button for each account
        if (account == 1) { // if account user
            one = new JButton("Apply");
            one.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    JOptionPane.showMessageDialog(null, "Apply button was pushed!");
                }
            });

            two = new JButton("Contact");
            two.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    JOptionPane.showMessageDialog(null, "Contact button was pushed!");
                }
            });
        }
        if (account == 2) { // if account tenant
            one = new JButton("Edit");
            one.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    JOptionPane.showMessageDialog(null, "Edit button was pushed!");
                }
            });

            two = new JButton("Delete");
            two.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    JOptionPane.showMessageDialog(null, "Delete button was pushed!");
                }
            });
        }

        if (account == 3) { // if account admin
            one = new JButton("Leave Comment");
            one.addActionListener(event -> JOptionPane.showMessageDialog(null, "Leave Comment button was pushed!"));

            two = new JButton("Delete");
            two.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    JOptionPane.showMessageDialog(null, "Delete button was pushed!");
                }
            });

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        // put data in array
        try {
            arrayLocation = FileConverter.readAllLines("location.txt");
//            arrayFacilities = FileConverter.readAllLines("locationFacilities.txt");
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
        String[] arr1 ={"Bathroom           ", "Bedroom            ", "Parking               ", "Wifi                      ", "Swimming Pool  ", "Air Cond              "};
        String[] arr2 ={"House Number ", "Street                 ", "City                     ", "Postcode           ", "State                   "};

        //set boundary for text "Location" & add to panel
        location.setFont(new Font("Serif", Font.PLAIN, 40));
        location.setBounds(250,5,400,40);
        learnMorePanel.add(location); // text "Location"

        //set boundary for text "Price" & add to panel
        price.setFont(new Font("Serif", Font.PLAIN, 25));
        price.setBounds(430,200,200,30);
        learnMorePanel.add(price); // text "Price"

        int gap = 25;
        for (int k = 0; k < 6; k++) {
            dataLocation = new JLabel[6];
            if (k == 0) {
                dataLocation[k] = new JLabel("RM " + arrayLocation[row][k + 2]);
                dataLocation[k].setFont(new Font("Serif", Font.PLAIN, 25));
                dataLocation[k].setBounds(420,230,200,30);
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
        facilities.setBounds(250,225,400,40);
        learnMorePanel.add(facilities); // text "Facilities"

//        for (int k = 0; k < 6; k++) {
//            dataFacilities = new JLabel[6];
//            dataFacilities[k] = new JLabel(arr1[k] +" : " + arrayFacilities[row][k+1]);
//            dataFacilities[k].setBounds(250,gap,200,30);
//            learnMorePanel.add(dataFacilities[k]);
//            gap +=30;
//        }
        ///////////////////////////////////////////////////////////////////////////////////////////////
        // set boundary for button & add to panel
        one.setBounds(75,480,100,30);
        two.setBounds(200,480,100,30);
        back.setBounds(325,480,100,30);

        ImageIcon img = new ImageIcon("src/Pictures/" + image + ".jpg");
        Image scaledImg = img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        Icon finalImg = new ImageIcon(scaledImg);
        JLabel pictureLabel = new JLabel();
        pictureLabel.setIcon(finalImg);
        pictureLabel.setBounds(25,120,200,200);
        //pictureLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        learnMorePanel.add(pictureLabel);
        learnMorePanel.add(one); // letak button(base on account) at learn more punya panel
        learnMorePanel.add(two); // letak second button(base on account) at learn more punya panel
        learnMorePanel.add(back); // letak back button at learn more punya panel
        mainContainer.add(learnMorePanel, "Other Panel");
        mainContainer.add(homePanel, "Back");

        mFrame.add(mainContainer);
        cl.show(mainContainer, "Home");
        mFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mFrame.pack();
        mFrame.setVisible(true);
        mFrame.setSize(560, 600);
    }

    public static void main(String[] args) {
        new learnMore("Myvi",2, 0); //row ikut button yang tekan
    }
}