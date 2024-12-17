package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Searchroom  extends JFrame {

    Choice choice;
    JTable table;

    Searchroom(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JLabel For = new JLabel("Search for Room");
        For.setBounds(250,5,186,35);
        For.setFont(new Font("Tahoma",Font.BOLD,14));
        For.setForeground(Color.WHITE);
        panel.add(For);

        JLabel status= new JLabel("Status");
        status.setBounds(70,73,80,20);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        status.setForeground(Color.WHITE);
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setBackground(Color.white);
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel Roomno= new JLabel("Room Number");
        Roomno.setBounds(11,162,150,20);
        Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        Roomno.setForeground(Color.WHITE);
        panel.add(Roomno);

        JLabel available= new JLabel("Availability");
        available.setBounds(175,162,150,20);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel Price = new JLabel("Price");
        Price.setBounds(350,162,150,20);
        Price.setFont(new Font("Tahoma",Font.BOLD,14));
        Price.setForeground(Color.WHITE);
        panel.add(Price);

        JLabel Variant = new JLabel("Variant");
        Variant.setBounds(520,162,150,20);
        Variant.setFont(new Font("Tahoma",Font.BOLD,14));
        Variant.setForeground(Color.WHITE);
        panel.add(Variant);

        JButton search = new JButton("Search");
        search.setBounds(260,410,130,30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where availability = '"+choice.getSelectedItem()+"'";
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back= new JButton("BACK");
        back.setBounds(400,410,130,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLocation(400,250);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Searchroom();

    }
}
