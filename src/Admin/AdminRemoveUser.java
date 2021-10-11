package Admin;

import DataSystem.Data;
import FileSystem.FileConverter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Arrays;

public class AdminRemoveUser extends JFrame {
    AdminRemoveUser() throws IOException {
        JFrame frame = new JFrame();
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0x313131));

        JLabel titleLabel = new JLabel("Remove User");
        titleLabel.setAlignmentX(JFrame.CENTER_ALIGNMENT);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Times New Roman",Font.BOLD,20));


        String[] column = {"ID", "Name", "Phone Number", "Gender"};
        String[][] data = FileConverter.readAllLines("account.txt");
        String[][] newData = Data.removeColumnFromData(data, 2);
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

                }
            }
        });

        JScrollPane mainPanel = new JScrollPane(table);

        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);
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
