package Admin;

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

public class AdminManageUser extends JFrame {
    JFrame frame = new JFrame();


    AdminManageUser() throws IOException {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(new Color(0x313131));

        JLabel txtLabel = new JLabel("Double Click to Approve/Reject");
        txtLabel.setForeground(Color.white);
        txtLabel.setFont(new Font("Times New Roman",Font.BOLD,20));

        JButton addBtn = new JButton("Add User");
        JButton removeBtn = new JButton("Remove User");
        JButton backBtn = new JButton("Back");

        //Todo: letak each function accordingly
        addBtn.addActionListener(e -> {
            System.out.println("add");
            frame.dispose();
            try {
                new AdminAddUser();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        removeBtn.addActionListener(e ->{
            System.out.println("Remove");
            frame.dispose();
            try {
                new AdminRemoveUser();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        backBtn.addActionListener(e ->{
            System.out.println("Back");
            frame.dispose();
            try {
                //parameter: change pictureName n AccountID
                new AdminMainPage("Myvi","AD1234");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });




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

        topPanel.add(txtLabel);
        topPanel.add(addBtn);
        topPanel.add(removeBtn);
        topPanel.add(backBtn);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel,BorderLayout.CENTER);
        frame.setTitle("Manage User");
        frame.setSize(600, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void main(String[] args) throws IOException {
        new AdminManageUser();
    }
}
