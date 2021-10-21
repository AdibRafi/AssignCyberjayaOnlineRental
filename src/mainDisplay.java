
import FileSystem.FileConverter;
import Tenant.*;
import Tenant.LoginForm;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpResponse;
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
    String[] propertyType = {"Select", "Double Storey", "Condominium", "Apartment", "Room"};
    JComboBox<String> propertyTypeBox = new JComboBox<>(propertyType);
    JLabel propertyTypeLbl = new JLabel("Property Type");

    //dropbox for property status
    String[] propertyStatus = {"Active", "Inactive"};
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
    JCheckBox facilityCheckBox1 = new JCheckBox("Wifi");
    JCheckBox facilityCheckBox2 = new JCheckBox("Swimming Pool");
    JCheckBox facilityCheckBox3 = new JCheckBox("Aircond");






    mainDisplay(boolean indicator) throws IOException {
        login = indicator;
        if(indicator == false){
            panelBtn = new JButton("Login/Register");
        }
        if(indicator == true){
            panelBtn = new JButton("Manage Profile");
            logOutBtn = new JButton("Log Out");
        }
        createWindow();
        setSize();
        addComponent();
        actionEvent();
    }

    public void createWindow() throws IOException {
        frame = new JFrame();
        frame.setTitle("Main frame");
        topPanel.setBackground(Color.darkGray);
        topPanel.setLayout(new BorderLayout());
        topPanel.setBorder(new LineBorder(Color.darkGray,3));

        //table part - adib
        String[] column = {"Agent", "Type", "price", "Active Property", "Furnished",
                "Size (sq.ft.)", "bed", "bath", "parking", "facilities"
                , "Address"};
        String[][] data = FileConverter.readAllLines("location.txt");

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
                    //todo: go to learn more display -adib
                    System.out.println("Clicked");
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
        frame.setBounds(40,40,750,700);
        topPanel.setPreferredSize(new Dimension(750, 50));
        bottomPanel.setPreferredSize(new Dimension(750, 123));
        projectField.setColumns(15);
    }

    public void addComponent(){
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Papyrus", Font.BOLD,20));

        //top panel(title and button)
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(titleLabel);
        if(login == false){
            topPanel.add(panelBtn);
        }
        else if(login == true){
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
        bottomPanel.add(facilityCheckBox1);
        bottomPanel.add(facilityCheckBox2);
        bottomPanel.add(facilityCheckBox3);
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
        if(login == false) {
            if (e.getSource() == panelBtn) {
                new LoginForm();
            }
        }
        if(login == true){
            if(e.getSource() == panelBtn) {
                JOptionPane.showMessageDialog(null, "Manage Profile button was pushed!");
            }else if(e.getSource() == logOutBtn){
                try {
                    new mainDisplay(false);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        //sort
        if(e.getSource() == refreshButton){
            String project = projectField.getText();
            String propertyType = (String) propertyTypeBox.getSelectedItem();
            String propertyStatus = (String) propertyStatusbox.getSelectedItem();
            String furnish = (String) furnishbox.getSelectedItem();
            String rentalRate = (String) rentalPricebox.getSelectedItem();;
            String wifi = null;
            String pool = null;
            String aircond = null;

            //for dropbox furnish
            if(furnish.equals("Select")){
                furnish = null;
            }
            //for dropbox rental price
            if(rentalRate.equals("Select")){
                rentalRate = null;
            }
            else if(rentalRate.equals("< 1.00")){
                rentalRate = "< 1.00";
            }
            else if(rentalRate.equals("Low to High")){
                rentalRate = "> 1.00 & < 2.00";
            }
            else if(rentalRate.equals("> 2.00")){
                rentalRate = "> 2.00";
            }

            //for checkbox
            if(facilityCheckBox1.isSelected()){
                wifi = "Wifi";
            }
            if(facilityCheckBox2.isSelected()){
                pool = "Swimming Pool";
            }
            if(facilityCheckBox3.isSelected()){
                aircond = "Aircond";
            }
            System.out.println(project);
            System.out.println(propertyType);
            System.out.println(propertyStatus);
            System.out.println(furnish);
            System.out.println(rentalRate);
            System.out.println(wifi);
            System.out.println(pool);
            System.out.println(aircond);

        }
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        new mainDisplay(true);
    }
}

