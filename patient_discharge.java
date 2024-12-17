package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class patient_discharge extends JFrame {
    patient_discharge(){

        Choice c1,c2;

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(120,20,200,20);
        label.setFont(new Font("Tahoma",Font.BOLD,25));
        label.setForeground(Color.BLACK);
        panel.add(label);

        JLabel label2 = new JLabel("Customer Id");
        label2.setBounds(30,80,120,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_Info");
            while (resultSet.next()){
                choice.add(resultSet.getString("number"));

            }
         ;


        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel label3 = new JLabel("Name");
        label3.setBounds(30,140,140,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);


        JLabel name  = new JLabel();
        name.setBounds(200,140,150,20);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.WHITE);
        panel.add(name);



        JLabel label4 = new JLabel("Room_No");
        label4.setBounds(30,200,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel RNo  = new JLabel();
        RNo.setBounds(200,200,150,20);
        RNo.setFont(new Font("Tahoma",Font.BOLD,15));
        RNo.setForeground(Color.WHITE);
        panel.add(RNo);

        JLabel label5 = new JLabel("Deposite");
        label5.setBounds(30,260,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);


        JLabel deposite  = new JLabel();
        deposite.setBounds(200,230,250,70);
        deposite.setFont(new Font("Tahoma",Font.BOLD,14));
        deposite.setForeground(Color.WHITE);
        panel.add(deposite);

        JLabel label6 = new JLabel("INTime");
        label6.setBounds(30,320,140,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JLabel INTime = new JLabel();
        INTime.setBounds(200,140,150,375);
        INTime.setFont(new Font("Tahoma",Font.BOLD,14));
        INTime.setForeground(Color.WHITE);
        panel.add(INTime);

        JLabel label7 = new JLabel("Out Time");
        label7.setBounds(30,380,140,20);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        Date date= new Date();

        JLabel OUTTime = new JLabel(""+date);
        OUTTime.setBounds(200,140,150,500);
        OUTTime.setFont(new Font("Tahoma",Font.BOLD,14));
        OUTTime.setForeground(Color.WHITE);
        panel.add(OUTTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,450,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);

        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    c.statement.executeUpdate("delete from Patient_Info where number = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where Room_No = '"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton Check = new JButton("Check");
        Check.setBounds(170,450,120,30);
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        panel.add(Check);

        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info where number = '"+choice.getSelectedItem()+"'");
                    while(resultSet.next()){
                        RNo.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));
                        name.setText(resultSet.getString("Name"));
                        deposite.setText(resultSet.getString("Deposite"));

                    }

                } catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(310,450,120,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
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
        new patient_discharge();

    }
}
