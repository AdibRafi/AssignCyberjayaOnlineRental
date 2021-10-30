package Adib;

import DataSystem.Data;
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

/**
 * Represent for Removing User by Admin
 * @author Adib
 */
public class RemoveUser extends JFrame {
    /**
     * Start GUI for RemoveUser
     * @param profileAccountID AccountID that already log in
     * @throws IOException Occurred when I/O operation is interrupted or failed
     * @author Adib, Darwisy
     */
    RemoveUser(String profileAccountID) throws IOException {
        JFrame frame = new JFrame();
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(51,153,255));
        topPanel.setBorder(new LineBorder(Color.darkGray,3));

        JLabel titleLabel = new JLabel("Remove User");
        titleLabel.setForeground(Color.darkGray);
        titleLabel.setAlignmentX(JFrame.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Times New Roman",Font.BOLD,20));

        JButton backBtn = new JButton("Back");


        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.dispose();
                    new ManageUser(profileAccountID);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


        String[] column = {"ID", "Name", "Phone Number", "Gender"};
        String[][] data = FileConverter.readAllLines("account.txt");
        String[][] newData = Data.removeColumnFromData(data, 2);
        DefaultTableModel tableModel = new DefaultTableModel(newData, column){
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
                    int input = JOptionPane.showConfirmDialog(null,
                            "Are you sure to remove this user?","Select an Options...",
                            JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        frame.dispose();
                        try {
                            frame.dispose();
                            FileConverter.removeSingleLine("account.txt",newData[table.getSelectedRow()][0]);
                            new ManageUser(profileAccountID);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        JScrollPane mainPanel = new JScrollPane(table);

        topPanel.add(titleLabel);
        topPanel.add(backBtn);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setTitle("Remove User");
        frame.setSize(600, 300);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

//    public static void main(String[] args) throws IOException {
//        new RemoveUser("AD1234");
//    }

}
