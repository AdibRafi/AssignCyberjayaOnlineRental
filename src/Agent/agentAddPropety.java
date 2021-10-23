package Agent;

import DataSystem.Property;
import FileSystem.FileConverter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class agentAddPropety extends JFrame implements ActionListener {
    private String account;

    JPanel topPanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JLabel titleLabel = new JLabel("myProperty House Rental", SwingConstants.CENTER);

    //dropbox for property type
    String[] propertyType = {"Select", "Double Storey", "Condominium", "Apartment", "Room"};
    JComboBox<String> propertyTypeBox = new JComboBox<>(propertyType);
    JLabel propertyTypeLbl = new JLabel("Property Type");

    //dropbox for property status
    String[] propertyStatus = {"active", "inactive"};
    JComboBox<String> propertyStatusbox = new JComboBox<>(propertyStatus); //
    JLabel statusTypeLbl = new JLabel("Propety Status");

    //dropbox for property state
    String[] state = {"Select", "Johor", "Kedah", "Kelantan", "Kuala Lumpur", "Labuan", "Malacca", "Negeri Sembilan", "Pahang", "Penang", "Perak", "Perlis", "Putrajaya", "Sabah", "Sarawak", "Selangor", "Terengganu"};
    JComboBox<String> statebox = new JComboBox<>(state); //
    JLabel stateLbl = new JLabel("State");

    //house location infomation label box
    JLabel propertyIDLabel = new JLabel("Property ID");
    JLabel priceLabel = new JLabel("Price (RM)");
    JLabel sizeLabel = new JLabel("Size (sq.ft.)");
    JLabel streetLabel = new JLabel("Street");
    JLabel cityLabel = new JLabel("City");
    JLabel postcodeLabel = new JLabel("Postcode");


    //button
    JButton addBtn = new JButton("Add");
    JButton backBtn = new JButton("Back to Main Menu");

    JTextField sizeField = new JTextField();
    JTextField propertyIDField = new JTextField();
    JTextField priceField = new JTextField();
    JTextField streetLabelField = new JTextField();
    JTextField cityField = new JTextField();
    JTextField postcodeField = new JTextField();
    JTextField bathField = new JTextField();
    JTextField bedField = new JTextField();
    JTextField parkingField = new JTextField();

    //facilities information

    //dropbox for wifi
    String[] wifi = {"true", "false"};
    JComboBox<String> wifiBox = new JComboBox<>(wifi);
    JLabel wifiLabel = new JLabel("Wifi");

    //dropbox for swimming pool
    String[] pool = {"true", "false"};
    JComboBox<String> poolBox = new JComboBox<>(pool); //
    JLabel poolLabel = new JLabel("Swimming Pool");

    //dropbox for furnished
    String[] furnished = {"Fully", "Semi"};
    JComboBox<String> furnishedBox = new JComboBox<>(furnished); //
    JLabel furnishedLabel = new JLabel("Furnished");

    //dropbox for aircond
    String[] aircond = {"true", "false"};
    JComboBox<String> aircondBox = new JComboBox<>(aircond); //
    JLabel aircondLabel = new JLabel("Aircond");

    //house facilities infomation label box
    JLabel bathLabel = new JLabel("Bathroom");
    JLabel bedLabel = new JLabel("Bedroom");
    JLabel parkingLabel = new JLabel("Parking");

    public agentAddPropety(String acc,boolean isItAddProperty){
        account = acc;
        mainPanel.setLayout(null);
        addBtn.addActionListener(this);
        backBtn.addActionListener(this);

        topPanel.setBackground(Color.darkGray);
        topPanel.setLayout(new BorderLayout());
        topPanel.setBorder(new LineBorder(Color.darkGray,3));
        titleLabel.setFont(new Font("Papyrus", Font.BOLD,20));
        titleLabel.setForeground(Color.white);

        //main info label
        propertyIDLabel.setBounds(25,30,100,30);
        propertyTypeLbl.setBounds(25,60,100,30);
        sizeLabel.setBounds(25,90,100,30);
        priceLabel.setBounds(25,120,100,30);
        streetLabel.setBounds(25,150,100,30);
        cityLabel.setBounds(25, 180, 100, 30);
        postcodeLabel.setBounds(25, 210, 100, 30);
        stateLbl.setBounds(25,240,150,30);
        statusTypeLbl.setBounds(25,270,150,30);
        bedLabel.setBounds(25,300,100,30);
        bathLabel.setBounds(25,330,150,30);
        parkingLabel.setBounds(25,360,100,30);
        wifiLabel.setBounds(25,390,100,30);
        poolLabel.setBounds(25,420,100,30);
        aircondLabel.setBounds(25,450,100,30);
        furnishedLabel.setBounds(25,480,100,30);

        //main info field
        propertyIDField.setBounds(135, 30, 150, 30);
        propertyTypeBox.setBounds(135, 60, 150, 30);
        sizeField.setBounds(135,90,150,30);
        priceField.setBounds(135,120,150,30);
        streetLabelField.setBounds(135,150,150,30);
        cityField.setBounds(135, 180, 150, 30);
        postcodeField.setBounds(135, 210, 150, 30);
        statebox.setBounds(135,240,150,30);
        propertyStatusbox.setBounds(135,270,150,30);
        bedField.setBounds(135,300,150,30);
        bathField.setBounds(135, 330, 150, 30);
        parkingField.setBounds(135,360,150,30);
        wifiBox.setBounds(135,390,150,30);
        poolBox.setBounds(135,420,150,30);;
        aircondBox.setBounds(135,450,150,30);
        furnishedBox.setBounds(135,480,150,30);

        addBtn.setBounds(20,550,100,40);
        backBtn.setBounds(150,550,150,40);

        //additional info
        topPanel.add(titleLabel);

        mainPanel.add(sizeLabel);
        mainPanel.add(propertyIDLabel);
        mainPanel.add(propertyTypeLbl);
        mainPanel.add(statusTypeLbl);
        mainPanel.add(priceLabel);
        mainPanel.add(streetLabel);
        mainPanel.add(cityLabel);
        mainPanel.add(stateLbl);
        mainPanel.add(postcodeLabel);
        mainPanel.add(furnishedLabel);
        mainPanel.add(bathLabel);
        mainPanel.add(bedLabel);
        mainPanel.add(parkingLabel);
        mainPanel.add(wifiLabel);
        mainPanel.add(poolLabel);
        mainPanel.add(aircondLabel);

        mainPanel.add(sizeField);
        mainPanel.add(propertyIDField);
        mainPanel.add(propertyTypeBox);
        mainPanel.add(propertyStatusbox);
        mainPanel.add(priceField);
        mainPanel.add(streetLabelField);
        mainPanel.add(cityField);
        mainPanel.add(postcodeField);
        mainPanel.add(statebox);
        mainPanel.add(bathField);
        mainPanel.add(bedField);
        mainPanel.add(parkingField);
        mainPanel.add(wifiBox);
        mainPanel.add(poolBox);
        mainPanel.add(aircondBox);
        mainPanel.add(furnishedBox);

        mainPanel.add(addBtn);
        mainPanel.add(backBtn);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(mainPanel);
        this.setTitle("Add Propety");
        this.setSize(350, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Property data = new Property();
        if (e.getSource() == addBtn){
            //todo: calculate terus rental rate provided in Property
            //todo: do OOP style

            //location form
            String addProperty = propertyIDField.getText();
            String propertyType = (String) propertyTypeBox.getSelectedItem();
            String propertyStatus = (String) propertyStatusbox.getSelectedItem();
            String price = priceField.getText();
            String size = sizeField.getText();
            String rentalRate = data.getValueOfRentalRate(price,size);
            String street = streetLabelField.getText();
            String postcode = postcodeField.getText();
            String city = cityField.getText();
            String state = (String) statebox.getSelectedItem();
            String bathroom = bathField.getText();
            String bedroom = bedField.getText();
            String parking = parkingField.getText();
            String wifi = (String) wifiBox.getSelectedItem();
            String pool = (String) poolBox.getSelectedItem();
            String aircond = (String) aircondBox.getSelectedItem();
            String furnished = (String) furnishedBox.getSelectedItem();

            //facilities form
            assert propertyType != null;
            if (propertyType.equals("Select")) {
                JOptionPane.showMessageDialog(this,"Please Select Property Type");
            }
            assert state != null;
            if (state.equals("Select")) {
                JOptionPane.showMessageDialog(this,"Please Select State");
            } else if (addProperty == null || rentalRate == null || price == null || size == null || street == null
                    || postcode == null || city == null || bathroom == null || bedroom == null || parking == null ) {
                JOptionPane.showMessageDialog(this,"Please fill in the form");
            } else {
                String propertyID = "";
                if (propertyType.equals("Double Storey"))
                    propertyID += "HO";
                if (propertyType.equals("Condominium"))
                    propertyID += "CD";
                if (propertyType.equals("Apartment"))
                    propertyID += "AP";
                if (propertyType.equals("Room"))
                    propertyID += "RO";
                propertyID += addProperty;
                String[] location = {account,propertyID,rentalRate,price,propertyStatus,furnished,size
                        ,bedroom,bathroom,parking,wifi,pool,aircond,street,city,postcode,state};
                String[][] checkPropertyID;
                try {
                    checkPropertyID = FileConverter.readAllLines("location.txt");

                    int checkNum = 0;
                    for (String[] strings : checkPropertyID) {
                        if (Objects.equals(strings[1], propertyID)) {
                            checkNum++;
                        }
                    }
                    if (checkNum > 0) {
                        JOptionPane.showMessageDialog(this, "Property Already Exist");
                    } else {
                        if(account.equals("")) //Add
                            System.out.println(Arrays.toString(location));
//                            FileConverter.appendFile("location.txt", location);
                        else
//                            FileConverter.updateFile("location.txt",);
                        JOptionPane.showMessageDialog(this, "Added Successful");
                        this.dispose();
                    }

                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        String acc = "AG3902";
        String acc2 = "AD5889";

        new agentAddPropety("",true);

    }
}

