package Admin;

import Agent.learnMore;
import DataSystem.Data;
import DataSystem.Property;
import FileSystem.FileConverter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AdminManageProperty extends JFrame {

    JFrame frame = new JFrame();
    Property accountData = new Property();
    AdminManageProperty(String accountID) throws IOException {
        accountData.setMainInfo(FileConverter.getSingleLineInfo("account.txt", accountID));
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0x313131));
        //fixme: Cari ways txtLabel kat tgh n btn kat kanan
        JLabel txtLabel = new JLabel("Double Click for Options");
        txtLabel.setForeground(Color.white);
        txtLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JButton backBtn = new JButton("Back");
        backBtn.setAlignmentX(JFrame.RIGHT_ALIGNMENT);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.dispose();
                    //parameter: change pictureName n AccountID
                    new AdminMainPage("Myvi", accountData.getAccountID());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        String[] column = {"AgentID", "PropertyID", "Price", "ActiveProperty", "Furnished", "Size",
                "Rental Rate", "Bedroom", "Bathroom", "Parking Spots", "Wifi", "Swimming Pool",
                "AirConditioner", "Street","Project", "City", "PostCode", "State"};
        String[][] data = FileConverter.readAllLines("location.txt");
        int userType = Data.checkTypeUser(accountID);
        ArrayList<String> info = new ArrayList<>();
        if (userType == 1) {
            for (String[] datum : data) {
                if (datum[0].equals(accountID))
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
                        new learnMore(data[input][1], accountData.getAccountID()
                                , data[input][1]);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        JScrollPane mainPanel = new JScrollPane(table);

        topPanel.add(txtLabel);
        topPanel.add(backBtn);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setTitle("Manage Property");
        frame.setSize(1500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException {
        new AdminManageProperty("AG5372");
    }
}
