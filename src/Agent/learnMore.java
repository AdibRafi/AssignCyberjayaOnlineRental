package Agent;

import DataSystem.Data;
import DataSystem.Property;
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
    JLabel[] agentInfo;
    JLabel[] houseInfo;

    public learnMore(String image, String account, String propertyID) throws IOException {

        Property houseData = new Property();
        Data agentData = new Property();


        // put data in array
        try {
            // get single line of house detail
            houseData.setPropertyInfo(FileConverter.getSingleLineInfo("location.txt",account, propertyID));

            // get single line of house detail
            agentData.setMainInfo(FileConverter.getSingleLineInfo("account.txt",houseData.getAccountID()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(houseData.getAccountID());
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        // different button for each account
        //todo : assign function dekat button (agent)
        if(account.equals(houseData.getAccountID())){// if account agent (tekan dia punya property)
            one = new JButton("Edit Property");
            one.addActionListener(event ->
            {
            });

            two = new JButton("Delete");
            two.addActionListener(event -> JOptionPane.showMessageDialog(null, "Delete button was pushed!"));

        }
        //todo : assign function dekat button (admin)
        if (account.contains("AD")) { // if account admin
            one = new JButton("Edit Property");
            one.addActionListener(event -> {
                new agentAddPropety(account, false,houseData.getPropertyID());
            });
            two = new JButton("Delete");
            two.addActionListener(event -> {
                try {
                    FileConverter.removeSingleLine("location.txt",account,houseData.getPropertyID());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Delete button was pushed!");
            });

        }

        // for all account
        //todo : assign function dekat back button
        back = new JButton("Back");
        back.addActionListener(event -> {
            JOptionPane.showMessageDialog(null, "Back button was pushed!");
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        back = new JButton("Back");
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

        //display "Location" label
        JLabel location = new JLabel("Location");
        //set boundary for text "Location" & add to panel
        location.setFont(new Font("Serif", Font.PLAIN, 40));
        location.setBounds(250,365,400,40);
        learnMorePanel.add(location); // text "Location"

        houseInfo = new JLabel[15];

        // display price
        JLabel price = new JLabel("Price");
        //set boundary for text "Price"
        price.setFont(new Font("Serif", Font.PLAIN, 30));
        price.setBounds(485,230,200,30);
        houseInfo[0] = new JLabel("RM " + houseData.getPrice());
        houseInfo[0].setFont(new Font("Serif", Font.PLAIN, 30));
        houseInfo[0].setBounds(485,260,200,30);
        learnMorePanel.add(price); // text "Price"

        //display status
        houseInfo[1] = new JLabel(arr1[0] +" : " + houseData.getActiveProperty());
        houseInfo[1].setBounds(250,50,200,30);

        //display furnish
        houseInfo[2] = new JLabel(arr1[1] +" : " + houseData.getFurnishedStatus());
        houseInfo[2].setBounds(250,80,200,30);

        //display size
        houseInfo[3] = new JLabel(arr1[2] +" : " + houseData.getSquareFeet());
        houseInfo[3].setBounds(250,110,200,30);

        //display rental rate
        houseInfo[4] = new JLabel(arr1[3] +" : RM " + houseData.getRentalRate());
        houseInfo[4].setBounds(250,140,200,30);

        //display num of bedroom
        houseInfo[5] = new JLabel(arr1[4] +" : " + houseData.getNumOfBed());
        houseInfo[5].setBounds(250,170,200,30);

        //display num of bathroom
        houseInfo[6] = new JLabel(arr1[5] +" : " + houseData.getNumOfBath());
        houseInfo[6].setBounds(250,200,200,30);

        //display num of parking
        houseInfo[7] = new JLabel(arr1[6] +" : " + houseData.getNumOfParking());
        houseInfo[7].setBounds(250,230,200,30);

        //display wifi available(true/false)
        houseInfo[8] = new JLabel(arr1[7] +" : " + houseData.getHaveWifi());
        houseInfo[8].setBounds(250,260,200,30);

        //display swimming pool available(true/false)
        houseInfo[9] = new JLabel(arr1[8] +" : " + houseData.getHaveSwimmingPool());
        houseInfo[9].setBounds(250,290,200,30);

        //display aircond available(true/false)
        houseInfo[10] = new JLabel(arr1[9] +" : " + houseData.getHaveAirCond());
        houseInfo[10].setBounds(250,320,200,30);

        //display street
        houseInfo[11] = new JLabel(arr2[0] +" : " + houseData.getAddress1() + ", " + houseData.getAddress2());
        houseInfo[11].setBounds(250,415,500,30);

        //display city
        houseInfo[12] = new JLabel(arr2[1] +" : " + houseData.getCityName());
        houseInfo[12].setBounds(250,445,200,30);

        //display postcode
        houseInfo[13] = new JLabel(arr2[2] +" : " + houseData.getPostcode());
        houseInfo[13].setBounds(250,475,200,30);

        //display state
        houseInfo[14] = new JLabel(arr2[3] +" : " + houseData.getState());
        houseInfo[14].setBounds(250,505,200,30);

        for(int i = 0; i < houseInfo.length; i++){learnMorePanel.add(houseInfo[i]);}

        // for agent information
        agentInfo = new JLabel[3];
        //display agent name
        agentInfo[0] = new JLabel("       Contact Information");
        agentInfo[0].setFont(new Font("Serif", Font.BOLD, 16));
        agentInfo[0].setBounds(10,445,200,30);
        //display agent name
        agentInfo[1] = new JLabel("Name                     : " + agentData.getName());
        agentInfo[1].setBounds(25,475,200,30);
        //display agent contact num
        agentInfo[2] = new JLabel("Contact Number  : " + agentData.getPhoneNumber());
        agentInfo[2].setBounds(25,505,200,30);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        agentInfo[0].setBorder(blackline);
        for(int i = 0; i < agentInfo.length; i++){
            learnMorePanel.add(agentInfo[i]);
        }
        /*----------------------------------------------------------------------------------------------------------------------------------------*/

        if(account.equals(houseData.getAccountID()) || account.contains("AD")){// if account agent (tekan dia punya property)
            // set boundary for button & add to panel (three button)
            one.setBounds(95, 570, 140, 30);
            two.setBounds(230, 570, 140, 30);
            back.setBounds(365, 570, 140, 30);
            learnMorePanel.add(one); // letak button(base on account) at learn more punya panel
            learnMorePanel.add(two); // letak second button(base on account) at learn more punya panel
            learnMorePanel.add(back); // letak back button at learn more punya panel
        }else{
            back.setBounds(250, 570, 140, 30);
            learnMorePanel.add(back); // letak back button at learn more punya panel
        }

        ImageIcon img = new ImageIcon("src/Pictures/" + image + ".png");
        Image scaledImg = img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        Icon finalImg = new ImageIcon(scaledImg);
        JLabel pictureLabel = new JLabel();
        pictureLabel.setIcon(finalImg);
        pictureLabel.setBounds(25,100,200,200);

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
        mFrame.setSize(650, 670);
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