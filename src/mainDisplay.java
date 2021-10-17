
import FileSystem.FileConverter;
import Tenant.*;
import Tenant.LoginForm;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class mainDisplay implements ActionListener {
    JFrame frame;

    JPanel topPanel = new JPanel();
    JLabel titleLabel = new JLabel("myProperty House Rental");
    JButton panelBtn = new JButton("Login/Register");

     mainDisplay() throws IOException {
        createWindow();
        setSize();
        addComponent();
        actionEvent();
    }

    public void createWindow() throws IOException {
        frame = new JFrame();
        frame.setTitle("Main frame");
        frame.setBounds(40,40,780,680);
        topPanel.setBackground(Color.darkGray);
        topPanel.setLayout(new BorderLayout());
        topPanel.setBorder(new LineBorder(Color.darkGray,3));

        //table part - adib
        String[] column = {"Agent", "Type", "price", "Active Property", "Furnished",
                "Size (sq.ft.)", "bed", "bath", "parking", "facilities"
                , "Address"};
        String[][] data = FileConverter.readAllLines("location.txt");
        System.out.println(Arrays.deepToString(data));

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
                    System.out.println("Clicked");
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
}

class Main {
    public static void main(String[] args) throws IOException {
        new mainDisplay();
    }
}

