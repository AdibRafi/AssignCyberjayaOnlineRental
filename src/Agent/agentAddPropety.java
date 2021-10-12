package Agent;

import FileSystem.FileConverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class agentAddPropety extends JFrame implements ActionListener {
    private static int acc;

    //dropbox for property type
    String[] propertyType = {"Select", "Double Storey", "Condominium", "Apartment"};
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
    JLabel accountIDLabel = new JLabel("Account ID");
    JLabel propertyIDLabel = new JLabel("Property ID");
    JLabel rentalRateLabel = new JLabel("Rental Rate");
    JLabel houseNumLabel = new JLabel("House Num");
    JLabel streetLabel = new JLabel("Street");
    JLabel cityLabel = new JLabel("City");
    JLabel postcodeLabel = new JLabel("Postcode");


    //button
    JButton addBtn = new JButton("Add");
    JButton backBtn = new JButton("Back to Main Menu");

    JTextField accountIDField = new JTextField();
    JTextField propertyIDField = new JTextField();
    JTextField rentalRateField = new JTextField();
    JTextField houseNumField = new JTextField();
    JTextField streetLabelField = new JTextField();
    JTextField cityField = new JTextField();
    JTextField postcodeField = new JTextField();

    //facilities information

    //dropbox for wifi
    String[] wifi = {"Yes", "No"};
    JComboBox<String> wifiBox = new JComboBox<>(wifi);
    JLabel wifiLabel = new JLabel("Wifi");

    //dropbox for swimming pool
    String[] pool = {"Yes", "No"};
    JComboBox<String> poolBox = new JComboBox<>(pool); //
    JLabel poolLabel = new JLabel("Swimming Pool");

    //dropbox for aircond
    String[] aircond = {"Yes", "No"};
    JComboBox<String> aircondBox = new JComboBox<>(aircond); //
    JLabel aircondLabel = new JLabel("Aircond");

    //house facilities infomation label box
    JLabel bathLabel = new JLabel("Bathroom");
    JLabel bedLabel = new JLabel("Bedroom");
    JLabel parkingLabel = new JLabel("Parking");

    JTextField bathField = new JTextField();
    JTextField bedField = new JTextField();
    JTextField parkingField = new JTextField();




    agentAddPropety(int account){
        acc = account;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        addBtn.addActionListener(this);
        backBtn.addActionListener(this);

        //main info label
        accountIDLabel.setBounds(25,30,100,30);
        propertyIDLabel.setBounds(25,60,100,30);
        propertyTypeLbl.setBounds(25,90,100,30);
        rentalRateLabel.setBounds(25,120,100,30);
        houseNumLabel.setBounds(25,150,100,30);
        streetLabel.setBounds(25, 180, 100, 30);
        cityLabel.setBounds(25, 210, 100, 30);
        postcodeLabel.setBounds(25,240,150,30);
        stateLbl.setBounds(25,270,150,30);
        statusTypeLbl.setBounds(25,300,100,30);

        bathLabel.setBounds(25,330,150,30);
        bedLabel.setBounds(25,360,100,30);
        parkingLabel.setBounds(25,390,100,30);
        wifiLabel.setBounds(25,420,100,30);
        poolLabel.setBounds(25,450,100,30);
        aircondLabel.setBounds(25,480,100,30);

        //main info field
        accountIDField.setBounds(135, 30, 150, 30);
        propertyIDField.setBounds(135, 60, 150, 30);
        propertyTypeBox.setBounds(135,90,150,30);
        rentalRateField.setBounds(135,120,150,30);
        houseNumField.setBounds(135,150,150,30);
        streetLabelField.setBounds(135, 180, 150, 30);
        cityField.setBounds(135, 210, 150, 30);
        postcodeField.setBounds(135,240,150,30);
        statebox.setBounds(135,270,150,30);
        propertyStatusbox.setBounds(135,300,150,30);

        bathField.setBounds(135, 330, 150, 30);
        bedField.setBounds(135,360,150,30);
        parkingField.setBounds(135,390,150,30);
        wifiBox.setBounds(135,420,150,30);;
        poolBox.setBounds(135,450,150,30);
        aircondBox.setBounds(135,480,150,30);

        addBtn.setBounds(20,545,100,40);
        backBtn.setBounds(150,545,150,40);

        //additional info

        panel.add(accountIDLabel);
        panel.add(propertyIDLabel);
        panel.add(propertyTypeLbl);
        panel.add(statusTypeLbl);
        panel.add(rentalRateLabel);
        panel.add(houseNumLabel);
        panel.add(streetLabel);
        panel.add(cityLabel);
        panel.add(stateLbl);
        panel.add(postcodeLabel);

        panel.add(bathLabel);
        panel.add(bedLabel);
        panel.add(parkingLabel);
        panel.add(wifiLabel);
        panel.add(poolLabel);
        panel.add(aircondLabel);

        panel.add(accountIDField);
        panel.add(propertyIDField);
        panel.add(propertyTypeBox);
        panel.add(propertyStatusbox);
        panel.add(rentalRateField);
        panel.add(houseNumField);
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

        panel.add(addBtn);
        panel.add(backBtn);

        this.add(panel);
        this.setTitle("Add Propety");
        this.setSize(350, 650);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new agentAddPropety(2);// 1 = agent, 2 = admin
        System.out.println(acc);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn){

            //location form
            String addProperty = propertyIDField.getText();
            String propertyType = (String) propertyTypeBox.getSelectedItem();
            String propertyStatus = (String) propertyStatusbox.getSelectedItem();
            String rentalRate = rentalRateField.getText();
            String houseNum = houseNumField.getText();
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


            //facilities form
            String account = "";
            if (propertyType.equals("Select")) {
                JOptionPane.showMessageDialog(this,"Please Select Property Type");
            }if (state.equals("Select")) {
                JOptionPane.showMessageDialog(this,"Please Select State");
            } else if (addProperty == null || rentalRate == null || houseNum == null || street == null || postcode == null || city == null || bathroom == null || bedroom == null || parking == null ) {
                JOptionPane.showMessageDialog(this,"Please fill in the form");
            } else {
                String propertyID = "";
                if (propertyType.equals("Double Storey"))
                    propertyID += "DS";
                if (propertyType.equals("Condominium"))
                    propertyID += "CO";
                if (propertyType.equals("Apartment"))
                    propertyID += "AP";
                propertyID += addProperty;
                String[] facilities = {propertyID,bathroom,bedroom,parking,wifi,pool,aircond};
                String[][] checkPropertyID;
                String[][] checkAgentID;
                int indicator = 0;
                try {
                    checkPropertyID = FileConverter.readAllLines("location.txt");
                    checkAgentID = FileConverter.readAllLines("account.txt");
                    if(acc==1) {
                        account += "AG";
                        account += accountIDField.getText();
                        for (String[] strings : checkAgentID) {
                            if (Objects.equals(strings[0], account)) {
                                System.out.println(strings[0]);
                                indicator = 1;
                            }
                        }
                    }if(acc==2) {
                        account += "AD";
                        account += accountIDField.getText();
                        for (String[] strings : checkAgentID) {
                            if (strings[0].equals(account)) {
                                System.out.println(strings[0]);
                                indicator = 1;
                            }
                        }
                    }
                    String[] location = {account,propertyID,rentalRate,street,city,postcode,state};

                    if (indicator == 1) {
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
                            FileConverter.appendFile("locationFacilities.txt", facilities);
                            this.dispose();
                        }
                    }else {
                        JOptionPane.showMessageDialog(this, "Account Doesn't Exist");
                    }

                    } catch(IOException ex){
                        ex.printStackTrace();
                    }
            }
        }
    }
}

