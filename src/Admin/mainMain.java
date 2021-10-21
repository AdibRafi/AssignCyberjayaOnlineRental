package Admin;

import Agent.learnMore;
import DataSystem.Data;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class mainMain implements ActionListener {
    JFrame frame;

    JPanel topPanel = new JPanel();
    JLabel titleLabel = new JLabel("myProperty House Rental");
    JButton panelBtn = new JButton("Login/Register");

    Property accountData = new Property();

    mainMain(String accountID) throws IOException {
        accountData.setPropertyInfo(FileConverter.getSingleLineInfo("location.txt",accountID));
        createWindow();
        setSize();
        addComponent();
        actionEvent();
    }

    public void createWindow() throws IOException {
        frame = new JFrame();
        frame.setTitle("Main frame");
        frame.setBounds(40,40,1000,680);
        topPanel.setBackground(Color.darkGray);
        topPanel.setLayout(new BorderLayout());
        topPanel.setBorder(new LineBorder(Color.darkGray,3));

        //table part - adib
        String[] column = {"Agent", "Type", "price", "Status", "Furnished",
                "Size (sq.ft.)","Rental Rate", "bed", "bath", "parking", "Address"
                , "City", "State"};
        String[][] data = FileConverter.readAllLines("location.txt");
//        data = Data.removeColumnFromData(data,false,true,true);
//        data = Data.removeColumnFromData(data, 9);
//        data = Data.removeColumnFromData(data, 9);
//        data = Data.removeColumnFromData(data, 9);
//
//        data = Data.removeColumnFromData(data, 11);
//        for (int i = 0; i < data.length; i++) {
//            data[i] = Data.changeValue(data[i],data[i][1]);
//        }

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
//                    new learnMore();
                }
            }
        });

        JScrollPane mainPanel = new JScrollPane(table);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.getContentPane().setBackground(Color.cyan);
//        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setSize(){
        topPanel.setBounds(0,0,780,60);
    }
    public void addComponent(){
        frame.add(topPanel, BorderLayout.NORTH);
        topPanel.add(titleLabel);
        topPanel.add(panelBtn, BorderLayout.LINE_END);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Papyrus", Font.BOLD,20));


    }
    public void actionEvent(){
        panelBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == panelBtn){
            new LoginForm();
        }
    }

    public static void main(String[] args) throws IOException {
//        new mainMain();
        Property data = new Property();
        data.setPropertyInfo(FileConverter.getSingleLineInfo("location.txt","AG2345"));
        System.out.println(Arrays.toString(data.getPropertyInfoToDisplay()));
        //todo: buat backend apa nak letak based on mark sheets
        new mainMain(data.getAccountID());

    }
}



