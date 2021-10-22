package Agent;

import Admin.AdminMainPage;
import DataSystem.Property;
import FileSystem.FileConverter;
import Tenant.LoginForm;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class mainDisplay implements ActionListener {
    boolean login;
    JFrame frame;

    JPanel topPanel = new JPanel();
    JLabel titleLabel = new JLabel("myProperty House Rental             ");
    JButton panelBtn;
    JButton logOutBtn;
    JPanel bottomPanel = new JPanel();
    JButton refreshButton = new JButton("Refresh");

    //search box for project
    JLabel projectLabel = new JLabel("Project");
    JTextField projectField = new JTextField();

    //dropbox for property type
    String[] propertyType = {"Select", "Landed House", "Condominium", "Apartment", "Room"};
    JComboBox<String> propertyTypeBox = new JComboBox<>(propertyType);
    JLabel propertyTypeLbl = new JLabel("Property Type");

    //dropbox for property status
    String[] propertyStatus = {"active", "inactive"};
    JComboBox<String> propertyStatusbox = new JComboBox<>(propertyStatus); //
    JLabel statusTypeLbl = new JLabel("   Status");

    //dropbox for furnish status
    String[] furnishStatus = {"Select", "Fully", "Semi"};
    JComboBox<String> furnishbox = new JComboBox<>(furnishStatus); //
    JLabel furnishLbl = new JLabel("   Furnished");

    //dropbox for rental price status
    String[] rentalPrice = {"Select", "< 1.00", "> 1.00 & < 2.00","> 2.00"};
    JComboBox<String> rentalPricebox = new JComboBox<>(rentalPrice); //
    JLabel rentalPriceLbl = new JLabel("   Rental Price");

    // checkbox for facility
    String[] wifiOption = {"Select","true","false"};
    JComboBox<String> wifiComboBox = new JComboBox<>(wifiOption);
    JLabel wifiLbl = new JLabel("   Wifi");
    String[] swimOption = {"Select","true","false"};
    JComboBox<String> swimComboBox = new JComboBox<>(wifiOption);
    JLabel swimLbl = new JLabel("   Swimming Pool");
    String[] aircondOption = {"Select","true","false"};
    JComboBox<String> aircondComboBox = new JComboBox<>(wifiOption);
    JLabel aircondLbl = new JLabel("   Aircond");



    public mainDisplay(boolean indicator, String[][] data) throws IOException {
        login = indicator;
        if(!indicator){
            panelBtn = new JButton("Login/Register");
        }
        if(indicator){
            panelBtn = new JButton("Manage Profile");
            logOutBtn = new JButton("Log Out");
        }
        createWindow(data);
        setSize();
        addComponent();
        actionEvent();
    }

    public void createWindow(String[][] data) throws IOException {
        frame = new JFrame();
        frame.setTitle("Agent.Main frame");
        topPanel.setBackground(Color.darkGray);
        topPanel.setLayout(new BorderLayout());
        topPanel.setBorder(new LineBorder(Color.darkGray,3));

        //table part - adib
        String[] column = {"Agent", "Type", "price", "Active Property", "Furnished",
                "Size (sq.ft.)", "bed", "bath", "parking", "Address", "City",
                "Postcode", "State"};

        DefaultTableModel tableModel = new DefaultTableModel(data,column){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(tableModel);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int input = table.getSelectedRow();
                    try {
                        String[][] allInfo = FileConverter.readAllLines("location.txt");
                        String propertyID = allInfo[input][1];
                        String accountID = allInfo[input][0];
                        new learnMore(propertyID,accountID,propertyID);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JScrollPane mainPanel = new JScrollPane(table);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.getContentPane().setBackground(Color.cyan);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    public void setSize(){
        frame.setBounds(40,40,1250,700);
        topPanel.setPreferredSize(new Dimension(1250, 50));
        bottomPanel.setPreferredSize(new Dimension(1250, 123));
        projectField.setColumns(15);
    }

    public void addComponent(){
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Papyrus", Font.BOLD,20));

        //top panel(title and button)
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(titleLabel);
        if(!login){
            topPanel.add(panelBtn);
        }
        else if(login){
            topPanel.add(panelBtn);
            topPanel.add(logOutBtn);
        }

        //bottom panel for sorting
        bottomPanel.add(projectLabel);
        bottomPanel.add(projectField);
        bottomPanel.add(propertyTypeLbl);
        bottomPanel.add(propertyTypeBox);
        bottomPanel.add(statusTypeLbl);
        bottomPanel.add(propertyStatusbox);
        bottomPanel.add(furnishLbl);
        bottomPanel.add(furnishbox);
        bottomPanel.add(rentalPriceLbl);
        bottomPanel.add(rentalPricebox);
        bottomPanel.add(wifiLbl);
        bottomPanel.add(wifiComboBox);
        bottomPanel.add(swimLbl);
        bottomPanel.add(swimComboBox);
        bottomPanel.add(aircondLbl);
        bottomPanel.add(aircondComboBox);
        bottomPanel.add(refreshButton);

    }

    public void actionEvent(){
        panelBtn.addActionListener(this);
        logOutBtn.addActionListener(this);
        refreshButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //top button
        if(!login) {
            if (e.getSource() == panelBtn) {
                new LoginForm();
            }
        }
        if(login){
            if(e.getSource() == panelBtn) {
                try {
                    //parameter: change picture n ID
                    frame.dispose();
                    new AdminMainPage("Myvi","AG2345");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }else if(e.getSource() == logOutBtn){
                try {
                    new mainDisplay(false, resetAllInfo());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        //sort
        if(e.getSource() == refreshButton){
            Property data;
            ArrayList<String> result = new ArrayList<>();
            try {
                String[][] allInfo = FileConverter.readAllLines("location.txt");
                for (int i = 0; i < allInfo.length; i++) {
                    String project = projectField.getText();
                    String propertyType = (String) propertyTypeBox.getSelectedItem();
                    String propertyStatus = (String) propertyStatusbox.getSelectedItem();
                    String furnish = (String) furnishbox.getSelectedItem();
                    String rentalRate = (String) rentalPricebox.getSelectedItem();
                    String wifi = (String) wifiComboBox.getSelectedItem();
                    String pool = (String) swimComboBox.getSelectedItem();
                    String aircond = (String) aircondComboBox.getSelectedItem();
                    data = new Property();
                    data.setPropertyInfo(FileConverter.getSingleLineInfo("location.txt",
                            allInfo[i][0], allInfo[i][1]));
                    assert furnish != null;
                    if(furnish.equals("Select")){
                        furnish = data.getFurnishedStatus();
                    }
                    if (project.equals(""))
                        project = data.getAddress2();
                    assert propertyType != null;
                    if (propertyType.equals("Select"))
                        propertyType = data.getHouseType();

                    //for checkbox
                    assert wifi != null;
                    if(wifi.equals("Select")){
                        wifi = data.getHaveWifi();
                    }
                    assert pool != null;
                    if(pool.equals("Select")){
                        pool = data.getHaveSwimmingPool();
                    }
                    assert aircond != null;
                    if(aircond.equals("Select")){
                        aircond = data.getHaveAirCond();
                    }

//                    System.out.println(data.getAddress2());
//                    System.out.println(project);
//                    System.out.println(data.getHouseType());
//                    System.out.println(propertyType);
//                    System.out.println(data.getActiveProperty());
//                    System.out.println(propertyStatus);
//                    System.out.println(data.getFurnishedStatus());
//                    System.out.println(furnish);
//                    System.out.println(data.getHaveWifi());
//                    System.out.println(wifi);
//                    System.out.println(data.getHaveSwimmingPool());
//                    System.out.println(pool);
//                    System.out.println(data.getHaveAirCond());
//                    System.out.println(aircond);


                    if (data.getAddress2().contains(project) && data.getHouseType().equals(propertyType) &&
                            data.getActiveProperty().equals(propertyStatus) && data.getFurnishedStatus().equals(furnish) &&
                            data.getHaveWifi().equals(wifi) && data.getHaveSwimmingPool().equals(pool) &&
                            data.getHaveAirCond().equals(aircond)) {
                        //RENTAL RATE
                        assert rentalRate != null;
                        if (rentalRate.equals("> 1.00 & < 2.00")){
                            if (Float.parseFloat(data.getRentalRate()) > 1.00 &&
                                    Float.parseFloat(data.getRentalRate()) < 2.00) {
                                result.add(FileConverter.addDashIntoString(data.getPropertyInfoForDisplay()));
                            }
                        }
                        else if (rentalRate.equals("< 1.00")){
                            if (Float.parseFloat(data.getRentalRate()) < 1.00){
                                result.add(FileConverter.addDashIntoString(data.getPropertyInfoForDisplay()));
                            }
                        }
                        else if (rentalRate.equals("> 2.00")){
                            if (Float.parseFloat(data.getRentalRate())>2.00){
                                result.add(FileConverter.addDashIntoString(data.getPropertyInfoForDisplay()));
                            }
                        }
                        else
                            result.add(FileConverter.addDashIntoString(data.getPropertyInfoForDisplay()));
                    }
                }
                String[][] finalResult = new String[result.size()][20];
                for (int i = 0; i < result.size(); i++) {
                    finalResult[i] = FileConverter.lineSplitter(result.get(i));
                }
                System.out.println(Arrays.deepToString(finalResult));
                new mainDisplay(login,finalResult);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //todo: letak for loop dlm ni and make sure pergi else if, if null -> data sama
            //for dropbox furnish

//            Property data;
//            try {
//                String[][] allInfo = FileConverter.readAllLines("location.txt");
//                String[] result = new String[allInfo.length];
//                for (int i = 0; i < allInfo.length; i++) {
//                    data = new Property();
//                    data.setPropertyInfo(FileConverter.getSingleLineInfo("location.txt",
//                            allInfo[i][0], allInfo[i][1]));
//                }
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }

        }
    }
    public static String[][] resetAllInfo() throws IOException{
        String[][] allInfo = FileConverter.readAllLines("location.txt");
        Property data;
        ArrayList<String> t = new ArrayList<>();
        for (int i = 0; i < allInfo.length; i++) {
            data = new Property();
            data.setPropertyInfo(FileConverter.getSingleLineInfo("location.txt",
                    allInfo[i][0],allInfo[i][1]));
            t.add(FileConverter.addDashIntoString(data.getPropertyInfoForDisplay()));
        }
        String[][] x = new String[t.size()][20];
        for (int i = 0; i < t.size(); i++) {
            x[i] = FileConverter.lineSplitter(t.get(i));
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        new mainDisplay(true, resetAllInfo());
    }
}

