package Admin;

import javax.swing.*;
import java.awt.*;

public class AdminManage extends JFrame {
    //assign: need to add,remove admin


    AdminManage(){
        JPanel btnPanel = new JPanel(new GridLayout(0,3));

        JButton addBtn = new JButton("Add");
        JButton removeBtn = new JButton("Remove");
        JButton backBtn = new JButton("Back");

        btnPanel.add(addBtn);
        btnPanel.add(removeBtn);
        btnPanel.add(backBtn);

        this.add(btnPanel, BorderLayout.CENTER);
        this.setTitle("Manage Admin");
        this.setSize(300, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {

    }
}
