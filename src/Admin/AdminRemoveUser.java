package Admin;

import DataSystem.Data;
import FileSystem.FileConverter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class AdminRemoveUser extends JFrame {
    AdminRemoveUser() throws IOException {
        JFrame frame = new JFrame();
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0x313131));

        JLabel titleLabel = new JLabel("Remove User");
        titleLabel.setForeground(Color.white);
        titleLabel.setAlignmentX(JFrame.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Times New Roman",Font.BOLD,20));

        JButton backBtn = new JButton("Back");


        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.dispose();
                    //parameter: change pictureName n AccountID
                    new AdminMainPage("Myvi", "AD1234");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });


        String[] column = {"ID", "Name", "Phone Number", "Gender"};
        String[][] data = FileConverter.readAllLines("account.txt");
        String[][] newData = Data.removeColumnFromData(data, 2);
        //fixme: change it the sorted data
        String[][] newData1 = Data.sortData(newData);
        System.out.println(Arrays.deepToString(newData1));

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
                        //fixme: change it the sorted data
                        System.out.println(newData[table.getSelectedRow()][0]);
                        frame.dispose();
                        try {
                            //fixme: change it the sorted data
                            FileConverter.removeSingleLine("account.txt",newData[table.getSelectedRow()][0]);
                            //parameter: change picture name and ID
                            new AdminMainPage("Myvi", "AD1234");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        JScrollPane mainPanel = new JScrollPane(table);

        topPanel.add(titleLabel);
        //fixme: cari ways utk letak backBtn belah kanan
        topPanel.add(backBtn);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setTitle("Remove User");
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException {
        new AdminRemoveUser();
    }

}
