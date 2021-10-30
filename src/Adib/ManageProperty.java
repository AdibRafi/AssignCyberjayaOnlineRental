package Adib;

import Ariez.AddOrUpdateProperty;
import Ariez.LearnMore;
import Ariez.MainDisplay;
import DataSystem.Data;
import DataSystem.Property;
import FileSystem.FileConverter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represent managing property by Admin or Agent
 * @author Adib
 */
public class ManageProperty extends JFrame {

    JFrame frame = new JFrame();
    Property accountData = new Property();

    /**
     * Start GUI of ManageProperty
     * @param profileAccountID accountID that already log in
     * @throws IOException occurred when I/O operation is interrupted or failed
     * @author Adib, Darwisy
     */
    public ManageProperty(String profileAccountID) throws IOException {
        accountData.setMainInfo(FileConverter.getSingleLineInfo("account.txt", profileAccountID));
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(51,153,255));
        topPanel.setBorder(new LineBorder(Color.darkGray,3));

        JLabel txtLabel = new JLabel("Double Click for Options");
        txtLabel.setForeground(Color.darkGray);
        txtLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    new AddOrUpdateProperty(accountData.getAccountID(), true, "",
                            true, profileAccountID, MainDisplay.resetAllInfo(), true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton backBtn = new JButton("Back");
        backBtn.setAlignmentX(JFrame.RIGHT_ALIGNMENT);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.dispose();
                    new ProfileMainPage("Myvi", accountData.getAccountID());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        String[] column = {"AgentID", "PropertyID", "Price", "ActiveProperty", "Furnished", "Size",
                "Rental Rate", "Bedroom", "Bathroom", "Parking Spots", "Wifi", "Swimming Pool",
                "AirConditioner", "Street","Project", "City", "PostCode", "State"};
        String[][] data = FileConverter.readAllLines("location.txt");
        int userType = Data.checkTypeUser(profileAccountID);
        ArrayList<String> info = new ArrayList<>();
        if (userType == 1) {
            for (String[] datum : data) {
                if (datum[0].equals(profileAccountID))
                    info.add(FileConverter.addDashIntoString(datum));
            }
        }
        else{
            for (String[] datum : data) {
                info.add(FileConverter.addDashIntoString(datum));
            }
        }
        String[][] finalInfo = new String[info.size()][20];
        for (int i = 0; i < info.size(); i++) {
            finalInfo[i] = FileConverter.lineSplitter(info.get(i));
        }
        DefaultTableModel tableModel = new DefaultTableModel(finalInfo, column){
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
                        frame.dispose();
                        new LearnMore(finalInfo[input][1], finalInfo[input][0]
                                , finalInfo[input][1], true, profileAccountID, MainDisplay.resetAllInfo(),true);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        JScrollPane mainPanel = new JScrollPane(table);

        topPanel.add(txtLabel);
        topPanel.add(addBtn);
        topPanel.add(backBtn);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setTitle("Manage Property");
        frame.setSize(1500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

//    public static void main(String[] args) throws IOException {
//        new ManageProperty("AD1234");
//    }
}
