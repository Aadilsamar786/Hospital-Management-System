package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ALL_patient_Info extends JFrame {

    ALL_patient_Info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(226,228,239));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,980,450);
        table.setBackground(new Color(226,228,239));
        table.setFont(new Font("Tahoma",Font.BOLD,13));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from patient_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("ID");
        label1.setBounds(31,11,100,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Number");
        label2.setBounds(130,9,70,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setBounds(250,9,110,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(370,9,110,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(500,9,110,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label5);

        JLabel label6 = new JLabel("Room_No");
        label6.setBounds(620,9,110,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label6);

        JLabel label7 = new JLabel("Time");
        label7.setBounds(770,9,110,20);
        label7.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label7);

        JLabel label8 = new JLabel("Deposite");
        label8.setBounds(870,9,110,20);
        label8.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label8);

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
        getContentPane().setBackground(Color.PINK);
        setLocation(350,230);
        setLayout(null);
        setVisible(true);
    }



    public static void main(String[] args) {
        new ALL_patient_Info();
    }
}
