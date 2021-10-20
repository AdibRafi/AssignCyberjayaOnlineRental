package Agent;

import FileSystem.FileConverter;

import java.io.*;
import javax.swing.*;
import java.awt.*;

public class learnMore extends JFrame  {
    static JPanel mainContainer;
    static CardLayout cl;
    private static int row;

    JPanel homePanel;
    JPanel learnMorePanel;
    JFrame mFrame;
    JButton back;
    JButton one;
    JButton two;
    JButton three;
    JButton[] buttonArray;
    JLabel[] dataDetail;
    JLabel[] dataLocation;
    String[][] arrayLocation;


    public learnMore(String image, String account, String propertyID) {

        // put data in array
        try {
            arrayLocation = FileConverter.readAllLines("location.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < arrayLocation.length; i++){
            if(arrayLocation[i][1].equals(propertyID)){
                row = i;
            }
        }


        //////////////////////////////////////////////////////////////////////////////////////////////////////
        // different button for each account

        if (account.contains("TN") || account.contains("AG")) { // if account user
            //todo : assign function dekat button (agent)
            if(account.equals(arrayLocation[row][0])){// if account agent (tekan dia punya property)
                one = new JButton("Manage Property");
                one.addActionListener(event -> JOptionPane.showMessageDialog(null, "Manage Property button was pushed!"));

                two = new JButton("Delete");
                two.addActionListener(event -> JOptionPane.showMessageDialog(null, "Delete button was pushed!"));

            }else {//todo : assign function dekat button (user)
                one = new JButton("Apply");
                one.addActionListener(event -> JOptionPane.showMessageDialog(null, "Apply button was pushed!"));

                two = new JButton("Contact");
                two.addActionListener(event -> JOptionPane.showMessageDialog(null, "Contact button was pushed!"));
            }
        }

        //todo : assign function dekat button (admin)
        if (account.contains("AD")) { // if account admin
            one = new JButton("Leave Comment");
            one.addActionListener(event -> JOptionPane.showMessageDialog(null, "Leave Comment button was pushed!"));

            two = new JButton("Manage Property");
            two.addActionListener(event -> JOptionPane.showMessageDialog(null, "Manage Property button was pushed!"));

            three = new JButton("Delete");
            three.addActionListener(event -> JOptionPane.showMessageDialog(null, "Delete button was pushed!"));

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        cl = new CardLayout(10, 10); // create cardlayout
        homePanel = new JPanel(); // panel for main menu
        buttonArray = new JButton[arrayLocation.length]; // create button in array

        //todo: back button function
        back = new JButton("Back"); // create back button (return to menu)
        back.addActionListener(event -> {
            cl.show(mainContainer, "Back");
        });

        mFrame = new JFrame("learn more test");

        mainContainer = new JPanel(cl);
        learnMorePanel = new JPanel();
        learnMorePanel.setLayout(null);

        /*// test back button (follow button yang ditekan)
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
        */
        JLabel price = new JLabel("Price");
        JLabel houseDetail = new JLabel("House Detail");
        JLabel location = new JLabel("Location");
        String[] arr1 ={ "Status                 ", "Furnished          ", "Size (sq.ft.)        ", "Bedroom            "
                , "Bathroom           ", "Parking               ", "Wifi                      ", "Swimming Pool  ", "Air Cond              "};
        String[] arr2 ={"Street                 ", "City                     ", "Postcode           ", "State                   "};

        //set boundary for text "House Detail" & add to panel
        houseDetail.setFont(new Font("Serif", Font.PLAIN, 40));
        houseDetail.setBounds(250,5,400,40);
        learnMorePanel.add(houseDetail); // text "Location"

        //set boundary for text "Price" & add to panel
        price.setFont(new Font("Serif", Font.PLAIN, 25));
        price.setBounds(455,230,200,30);
        learnMorePanel.add(price); // text "Price"

        int gap = 25;
        for (int k = 0; k < 10; k++) {
            dataDetail = new JLabel[10];
            if (k == 0) {
                dataDetail[k] = new JLabel("RM " + arrayLocation[row][k + 2]);
                dataDetail[k].setFont(new Font("Serif", Font.PLAIN, 25));
                dataDetail[k].setBounds(455,260,200,30);
                learnMorePanel.add(dataDetail[k]);
            } if(k > 0 ) {
                dataDetail[k] = new JLabel(arr1[k-1] +" : " + arrayLocation[row][k + 2]);
                dataDetail[k].setBounds(250,gap,200,30);
                learnMorePanel.add(dataDetail[k]);
            }gap +=30 ;
        }
        gap +=70;

        //set boundary for text "Location" & add to panel
        location.setFont(new Font("Serif", Font.PLAIN, 40));
        location.setVerticalAlignment(JLabel.CENTER);
        location.setBounds(250,340,400,40);
        learnMorePanel.add(location); // text "Facilities"

        for (int k = 0; k < 4; k++) {
            dataLocation = new JLabel[4];
                dataLocation[k] = new JLabel(arr2[k] + " : " + arrayLocation[row][k + 12]);
                dataLocation[k].setBounds(250, gap, 400, 30);
                learnMorePanel.add(dataLocation[k]);
            gap +=30;
            }
        ///////////////////////////////////////////////////////////////////////////////////////////////
        if(account.contains("AD")) {
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
        String admin = "AD0001";
        String agent = "AG0001";
        String agent2 = "AG2345";
        String user = "TN0001";

        String property = "AP008";
        String property2 ="AP0001";

        new learnMore("Myvi",agent2, property); //row ikut property ID yang tekan
    }
}