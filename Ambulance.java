package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends  JFrame {
    Ambulance(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,980,450);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,13));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(15,11,100,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Gender");
        label2.setBounds(200,9,70,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label2);

        JLabel label3 = new JLabel("Car_Name");
        label3.setBounds(400,9,110,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label3);

        JLabel label4 = new JLabel("Available");
        label4.setBounds(600,9,110,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label4);

        JLabel label5 = new JLabel("Location");
        label5.setBounds(790,9,110,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label5);

        JButton b1= new JButton("BACK");
        b1.setBounds(450,510,120,35);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1000,600);
        setLocation(350,230);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
       new Ambulance();
    }
}
