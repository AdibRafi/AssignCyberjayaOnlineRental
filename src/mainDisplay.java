
import FileSystem.FileConverter;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class mainDisplay implements ActionListener {
    JFrame frame;

    JPanel topPanel = new JPanel();


    mainDisplay() {
        createWindow();
        setSize();
        addComponent();
    }

    private void createWindow() {
        frame = new JFrame();
        frame.setTitle("Main frame");
        frame.setBounds(40,40,700,580);
        topPanel.setBackground(Color.cyan);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setSize(){
        topPanel.setBounds(0,0,700,80);
    }
    public void addComponent(){
        frame.add(topPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

class Main {
    public static void main(String[] args) {
        new mainDisplay();
    }
}

