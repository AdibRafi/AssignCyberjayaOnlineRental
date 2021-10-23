package Agent;

import DataSystem.Property;
import FileSystem.FileConverter;

import java.io.*;
import javax.swing.*;
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
    JLabel[] dataDetail;
    JLabel[] dataLocation;
    String[] detail;


    public learnMore(String image, String account, String propertyID) throws IOException {

        // put data in array
        try {
            detail = FileConverter.getSingleLineInfo("location.txt",account, propertyID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Property data = new Property();
        data.setPropertyInfo(detail);

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        // different button for each account
        if (account.contains("TN") || account.contains("AG")) { // if account user
            //todo : assign function dekat button (agent)
            if(account.equals(data.getAccountID())){// if account agent (tekan dia punya property)
                one = new JButton("Edit Property");
                one.addActionListener(event ->
                {
                });

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
            two = new JButton("Edit Property");
            two.addActionListener(event -> {
                new agentAddPropety(account, false,data.getPropertyID());
            });
            three = new JButton("Delete");
            three.addActionListener(event -> {
                try {
                    FileConverter.removeSingleLine("location.txt",account,data.getPropertyID());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Delete button was pushed!");
            });

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        cl = new CardLayout(10, 10); // create cardlayout
        homePanel = new JPanel(); // panel for main menu

        mFrame = new JFrame("learn more test");

        mainContainer = new JPanel(cl);
        learnMorePanel = new JPanel();
        learnMorePanel.setLayout(null);
        /*----------------------------------------------------------------------------------------------------------------------------------------*/
        //display infomation detail about the house
        String[] arr1 ={ "Status                 ", "Furnished          ", "Size (sq.ft.)        ", "Rental Rate       ", "Bedroom            "
                , "Bathroom           ", "Parking               ", "Wifi                      ", "Swimming Pool  ", "Air Cond              "};
        String[] arr2 ={"Street                 ", "City                     ", "Postcode           ", "State                   "};

        //display "House Detail" label
        JLabel houseDetail = new JLabel("House Detail");
        //set boundary for text "House Detail" & add to panel
        houseDetail.setFont(new Font("Serif", Font.PLAIN, 40));
        houseDetail.setBounds(250,5,400,40);
        learnMorePanel.add(houseDetail); // text "House Detail"

        dataDetail = new JLabel[15];

        // display price
        JLabel price = new JLabel("Price");
        //set boundary for text "Price"
        price.setFont(new Font("Serif", Font.PLAIN, 25));
        price.setBounds(455,230,200,30);
        dataDetail[0] = new JLabel("RM " + data.getPrice());
        dataDetail[0].setFont(new Font("Serif", Font.PLAIN, 25));
        dataDetail[0].setBounds(455,260,200,30);
        learnMorePanel.add(price); // text "Price"

        //display status
        dataDetail[1] = new JLabel(arr1[0] +" : " + data.getActiveProperty());
        dataDetail[1].setBounds(250,50,200,30);

        //display furnish
        dataDetail[2] = new JLabel(arr1[1] +" : " + data.getFurnishedStatus());
        dataDetail[2].setBounds(250,80,200,30);

        //display size
        dataDetail[3] = new JLabel(arr1[2] +" : " + data.getSquareFeet());
        dataDetail[3].setBounds(250,110,200,30);

        //display rental rate
        dataDetail[4] = new JLabel(arr1[3] +" : RM " + data.getRentalRate());
        dataDetail[4].setBounds(250,140,200,30);

        //display num of bedroom
        dataDetail[5] = new JLabel(arr1[4] +" : " + data.getNumOfBed());
        dataDetail[5].setBounds(250,170,200,30);

        //display num of bathroom
        dataDetail[6] = new JLabel(arr1[5] +" : " + data.getNumOfBath());
        dataDetail[6].setBounds(250,200,200,30);

        //display num of parking
        dataDetail[7] = new JLabel(arr1[6] +" : " + data.getNumOfParking());
        dataDetail[7].setBounds(250,230,200,30);

        //display wifi available(true/false)
        dataDetail[8] = new JLabel(arr1[7] +" : " + data.getHaveWifi());
        dataDetail[8].setBounds(250,260,200,30);

        //display swimming pool available(true/false)
        dataDetail[9] = new JLabel(arr1[8] +" : " + data.getHaveSwimmingPool());
        dataDetail[9].setBounds(250,290,200,30);

        //display aircond available(true/false)
        dataDetail[10] = new JLabel(arr1[9] +" : " + data.getHaveAirCond());
        dataDetail[10].setBounds(250,320,200,30);

        JLabel location = new JLabel("Location");
        //set boundary for text "Location" & add to panel
        location.setFont(new Font("Serif", Font.PLAIN, 40));
        location.setVerticalAlignment(JLabel.CENTER);
        location.setBounds(250,365,400,40);
        learnMorePanel.add(location); // text "Location"

        //display street
        dataDetail[11] = new JLabel(arr2[0] +" : " + data.getAddress1() + ", " + data.getAddress2());
        dataDetail[11].setBounds(250,415,500,30);

        //display city
        dataDetail[12] = new JLabel(arr2[1] +" : " + data.getCityName());
        dataDetail[12].setBounds(250,445,200,30);

        //display postcode
        dataDetail[13] = new JLabel(arr2[2] +" : " + data.getPostcode());
        dataDetail[13].setBounds(250,475,200,30);

        //display state
        dataDetail[14] = new JLabel(arr2[3] +" : " + data.getState());
        dataDetail[14].setBounds(250,505,200,30);

        for(int i = 0; i < dataDetail.length; i++){learnMorePanel.add(dataDetail[i]);}
        /*----------------------------------------------------------------------------------------------------------------------------------------*/

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
        ImageIcon img = new ImageIcon("src/Pictures/" + image + ".png");
        Image scaledImg = img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        Icon finalImg = new ImageIcon(scaledImg);
        JLabel pictureLabel = new JLabel();
        pictureLabel.setIcon(finalImg);
        pictureLabel.setBounds(25,70,200,200);

        ///////////////////////////////////////////////////////////////////////////////////////////////

        learnMorePanel.add(pictureLabel);
        mainContainer.add(learnMorePanel, "Other Panel");
        mainContainer.add(homePanel, "Back");

        mFrame.add(mainContainer);
        cl.show(mainContainer, "Home");
        mFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        mFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mFrame.pack();
        mFrame.setVisible(true);
        mFrame.setSize(610, 670);
    }

    public static void main(String[] args) throws IOException {
        String admin = "AD1234";
        String agent = "AG0001";
        String agent2 = "AG2345";
        String user = "TN0001";

        String property = "AP0008";
        String property2 ="AP0001";

        new learnMore(property,agent2, property); //row ikut property ID yang tekan
    }
}