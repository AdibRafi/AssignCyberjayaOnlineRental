package Admin;

import FileSystem.FileConverter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class AdminManageUser extends JFrame {
    //assign: need to add,remove admin/user/tenant


    AdminManageUser() throws IOException {
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JLabel txtLabel = new JLabel("Double Click to Approve/Reject");
        JButton addBtn = new JButton("Add User");
        //check: either nak letak or not remove btn ni
        JButton removeBtn = new JButton("Remove");
        JButton backBtn = new JButton("Back");

        btnPanel.add(txtLabel);
        btnPanel.add(addBtn);
        btnPanel.add(removeBtn);
        btnPanel.add(backBtn);

        // TODO: 07/10/2021 kena buat file baru utk approval only and only use that for this class
        String[] column = {"ID", "Name", "Password", "Phone Number", "Gender"};
        String[][] data = FileConverter.readAllLines("account.txt");
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
                    String[] options = {"Add", "Remove"};
                    int x = JOptionPane.showOptionDialog(null,
                            "What do you want to do with this user?",
                            "Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, options, options[0]);
                    // TODO: 07/10/2021 letak showMsg utk CONFIRMATION
                    if (x == 0)
                        System.out.println("add");
                    if (x == 1)
                        System.out.println("remove");
                }
            }
        });

        JScrollPane mainPanel = new JScrollPane(table);

        this.add(btnPanel, BorderLayout.NORTH);
        this.add(mainPanel,BorderLayout.CENTER);
        this.setTitle("Manage Admin");
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void main(String[] args) throws IOException {
        new AdminManageUser();
    }
}
