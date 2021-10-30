package Adib;

import DataSystem.Data;
import FileSystem.FileConverter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Represent Managing User by Admin
 * @author Adib
 */
public class ManageUser extends JFrame {
    JFrame frame = new JFrame();

    /**
     * Start GUI for ManageUser
     * @param profileAccountID accountID that already log in
     * @throws IOException occurred when I/O operation is interrupted or failed
     * @author Adib, Darwisy
     */
    ManageUser(String profileAccountID) throws IOException {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(new Color(51,153,255));

        JLabel txtLabel = new JLabel("Double Click to Approve/Reject");
        txtLabel.setForeground(Color.darkGray);
        txtLabel.setFont(new Font("Times New Roman",Font.BOLD,20));

        JButton addBtn = new JButton("Add User");
        JButton removeBtn = new JButton("Remove User");
        JButton backBtn = new JButton("Back");

        addBtn.addActionListener(e -> {
            System.out.println("add");
            frame.dispose();
            try {
                new AddUser(profileAccountID);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        removeBtn.addActionListener(e ->{
            System.out.println("Remove");
            frame.dispose();
            try {
                new RemoveUser(profileAccountID);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        backBtn.addActionListener(e ->{
            System.out.println("Back");
            frame.dispose();
            try {
                new ProfileMainPage("Myvi",profileAccountID);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });




        String[] column = {"ID", "Name", "Phone Number", "Gender"};
        String[][] data = FileConverter.readAllLines("accountApproval.txt");
        data = Data.removeColumnFromData(data, 2);
        DefaultTableModel tableModel = new DefaultTableModel(data,column){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        JTable table = new JTable(tableModel);
        String[][] finalData = data;
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String[] options = {"Add", "Remove", "Cancel"};
                    int x = JOptionPane.showOptionDialog(null,
                            "What do you want to do with this user?",
                            "Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, options, options[0]);
                    if (x == 0){
                        try {
                            String[] info = FileConverter.getSingleLineInfo
                                    ("accountApproval.txt", finalData[table.getSelectedRow()][0]);
                            FileConverter.removeSingleLine
                                    ("accountApproval.txt",finalData[table.getSelectedRow()][0]);
                            FileConverter.appendFile("account.txt",info);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (x == 1){
                        try {
                            FileConverter.removeSingleLine
                                    ("accountApproval.txt", finalData[table.getSelectedRow()][0]);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        JScrollPane mainPanel = new JScrollPane(table);

        topPanel.add(txtLabel);
        topPanel.add(addBtn);
        topPanel.add(removeBtn);
        topPanel.add(backBtn);
        topPanel.setBorder(new LineBorder(Color.darkGray,3));

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel,BorderLayout.CENTER);
        mainPanel.setBackground(new Color(51,153,255));
        frame.setTitle("Manage User");
        frame.setSize(650, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
//    public static void main(String[] args) throws IOException {
//        new ManageUser("AD1234");
//    }
}
