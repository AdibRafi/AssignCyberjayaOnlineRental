package Agent;

import FileSystem.FileConverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class agentAddPropety extends JFrame implements ActionListener {
    private static String account;

    //dropbox for property type
    String[] propertyType = {"Select", "Double Storey", "Condominium", "Apartment", "Room"};
    JComboBox<String> propertyTypeBox = new JComboBox<>(propertyType);
    JLabel propertyTypeLbl = new JLabel("Property Type");

    //dropbox for property status
    String[] propertyStatus = {"Active", "Inactive"};
    JComboBox<String> propertyStatusbox = new JComboBox<>(propertyStatus); //
    JLabel statusTypeLbl = new JLabel("Propety Status");

    //dropbox for property state
    String[] state = {"Select", "Johor", "Kedah", "Kelantan", "Kuala Lumpur", "Labuan", "Malacca", "Negeri Sembilan", "Pahang", "Penang", "Perak", "Perlis", "Putrajaya", "Sabah", "Sarawak", "Selangor", "Terengganu"};
    JComboBox<String> statebox = new JComboBox<>(state); //
    JLabel stateLbl = new JLabel("State");

    //house location infomation label box
    JLabel propertyIDLabel = new JLabel("Property ID");
    JLabel rentalRateLabel = new JLabel("Rental Rate (RM)");
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
    JTextField rentalRateField = new JTextField();
    JTextField priceField = new JTextField();
    JTextField streetLabelField = new JTextField();
    JTextField cityField = new JTextField();
    JTextField postcodeField = new JTextField();

    //facilities information

    //dropbox for wifi
    String[] wifi = {"True", "False"};
    JComboBox<String> wifiBox = new JComboBox<>(wifi);
    JLabel wifiLabel = new JLabel("Wifi");

    //dropbox for swimming pool
    String[] pool = {"True", "False"};
    JComboBox<String> poolBox = new JComboBox<>(pool); //
    JLabel poolLabel = new JLabel("Swimming Pool");

    //dropbox for furnished
    String[] furnished = {"Fully", "Semi"};
    JComboBox<String> furnishedBox = new JComboBox<>(furnished); //
    JLabel furnishedLabel = new JLabel("Furnished");

    //dropbox for aircond
    String[] aircond = {"True", "False"};
    JComboBox<String> aircondBox = new JComboBox<>(aircond); //
    JLabel aircondLabel = new JLabel("Aircond");

    //house facilities infomation label box
    JLabel bathLabel = new JLabel("Bathroom");
    JLabel bedLabel = new JLabel("Bedroom");
    JLabel parkingLabel = new JLabel("Parking");


    JTextField bathField = new JTextField();
    JTextField bedField = new JTextField();
    JTextField parkingField = new JTextField();

    public agentAddPropety(String acc){
        account = acc;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        addBtn.addActionListener(this);
        backBtn.addActionListener(this);

        //main info label
        propertyIDLabel.setBounds(25,30,100,30);
        propertyTypeLbl.setBounds(25,60,100,30);
        sizeLabel.setBounds(25,90,100,30);
        rentalRateLabel.setBounds(25,120,100,30);
        priceLabel.setBounds(25,150,100,30);
        streetLabel.setBounds(25, 180, 100, 30);
        cityLabel.setBounds(25, 210, 100, 30);
        postcodeLabel.setBounds(25,240,150,30);
        stateLbl.setBounds(25,270,150,30);
        statusTypeLbl.setBounds(25,300,100,30);
        bedLabel.setBounds(25,330,150,30);
        bathLabel.setBounds(25,360,100,30);
        parkingLabel.setBounds(25,390,100,30);
        wifiLabel.setBounds(25,420,100,30);
        poolLabel.setBounds(25,450,100,30);
        aircondLabel.setBounds(25,480,100,30);
        furnishedLabel.setBounds(25,510,100,30);


        //main info field
        propertyIDField.setBounds(135, 30, 150, 30);
        propertyTypeBox.setBounds(135, 60, 150, 30);
        sizeField.setBounds(135,90,150,30);
        rentalRateField.setBounds(135,120,150,30);
        priceField.setBounds(135,150,150,30);
        streetLabelField.setBounds(135, 180, 150, 30);
        cityField.setBounds(135, 210, 150, 30);
        postcodeField.setBounds(135,240,150,30);
        statebox.setBounds(135,270,150,30);
        propertyStatusbox.setBounds(135,300,150,30);
        bedField.setBounds(135, 330, 150, 30);
        bathField.setBounds(135,360,150,30);
        parkingField.setBounds(135,390,150,30);
        wifiBox.setBounds(135,420,150,30);;
        poolBox.setBounds(135,450,150,30);
        aircondBox.setBounds(135,480,150,30);
        furnishedBox.setBounds(135,510,150,30);

        addBtn.setBounds(20,575,100,40);
        backBtn.setBounds(150,575,150,40);

        //additional info

        panel.add(sizeLabel);
        panel.add(propertyIDLabel);
        panel.add(propertyTypeLbl);
        panel.add(statusTypeLbl);
        panel.add(rentalRateLabel);
        panel.add(priceLabel);
        panel.add(streetLabel);
        panel.add(cityLabel);
        panel.add(stateLbl);
        panel.add(postcodeLabel);
        panel.add(furnishedLabel);
        panel.add(bathLabel);
        panel.add(bedLabel);
        panel.add(parkingLabel);
        panel.add(wifiLabel);
        panel.add(poolLabel);
        panel.add(aircondLabel);

        panel.add(sizeField);
        panel.add(propertyIDField);
        panel.add(propertyTypeBox);
        panel.add(propertyStatusbox);
        panel.add(rentalRateField);
        panel.add(priceField);
        panel.add(streetLabelField);
        panel.add(cityField);
        panel.add(postcodeField);
        panel.add(statebox);
        panel.add(bathField);
        panel.add(bedField);
        panel.add(parkingField);
        panel.add(wifiBox);
        panel.add(poolBox);
        panel.add(aircondBox);
        panel.add(furnishedBox);

        panel.add(addBtn);
        panel.add(backBtn);

        this.add(panel);
        this.setTitle("Add Propety");
        this.setSize(350, 650);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        String acc = "AG3902";
        String acc2 = "AD5889";

        new agentAddPropety(acc);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn){
            //todo: calculate terus rental rate provided in Property
            //todo: do OOP style

            //location form
            String addProperty = propertyIDField.getText();
            String propertyType = (String) propertyTypeBox.getSelectedItem();
            String propertyStatus = (String) propertyStatusbox.getSelectedItem();
            String rentalRate = rentalRateField.getText();
            String price = priceField.getText();
            String size = sizeField.getText();
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
            if (propertyType.equals("Select")) {
                JOptionPane.showMessageDialog(this,"Please Select Property Type");
            }if (state.equals("Select")) {
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
                        JOptionPane.showMessageDialog(this, "Added Successful");
                        FileConverter.appendFile("location.txt", location);
                        this.dispose();
                    }

                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}

