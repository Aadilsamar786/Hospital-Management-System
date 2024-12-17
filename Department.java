package hospital.management.system;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department  extends JFrame{

    Department(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(205,209,212));
        add(panel);

        JTable table = new JTable();
        table.setBounds(15,40,1000,350);
        table.setBackground(new Color(205,209,212));
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from Department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Department");
        label1.setBounds(50,15,105,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(500,15,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label2);

//
        JButton b1= new JButton("BACK");
        b1.setBounds(250,410,130,30);
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
        setSize(700,500);
        setLayout(null);
        getContentPane().setBackground(Color.PINK);
        setLocation(350,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Department();

    }
}