package Admin;

import Agent.learnMore;
import Agent.sort;
import DataSystem.Data;
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

public class AdminManageProperty extends JFrame {

    JFrame frame = new JFrame();

    AdminManageProperty() throws IOException {
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
                    new AdminMainPage("Myvi","AD1234");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        String[] column = {"AgentID", "Price", "ActiveProperty", "Furnished", "Size",
                "Bedroom", "Bathroom", "Parking Spots", "Wifi", "Swimming Pool",
                "AirConditioner", "Street", "City", "PostCode", "State"};
        String[][] data = FileConverter.readAllLines("location.txt");
        data = Data.removeColumnFromData(data, 1);
        DefaultTableModel tableModel = new DefaultTableModel(data, column){
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
                    System.out.println("clicked");
//                    new learnMore("Myvi");
                }
            }
        });
        JScrollPane mainPanel = new JScrollPane(table);

        topPanel.add(txtLabel);
        topPanel.add(backBtn);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setTitle("Manage Property");
        frame.setSize(1250, 400);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException {
        new AdminManageProperty();
    }
}
