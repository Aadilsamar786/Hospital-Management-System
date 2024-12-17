package hospital.management.system;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class update_patient_details extends JFrame {

    update_patient_details(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,940,540);
        panel.setBackground(new Color(90,154,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);


        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,11,270,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Name ");
        label2.setBounds(25,88,150,20);
        label2.setFont(new Font("Tahoma",Font.PLAIN,20));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,150,25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number ");
        label3.setBounds(25,130,180,20);
        label3.setFont(new Font("Tahoma",Font.PLAIN,20));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,129,150,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("IN-Time ");
        label4.setBounds(25,180,100,20);
        label4.setFont(new Font("Tahoma",Font.PLAIN,20));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldINTime = new JTextField();
        textFieldINTime.setBounds(248,174,150,20);
        panel.add(textFieldINTime);

        JLabel label5 = new JLabel("Amount Paid  ");
        label5.setBounds(25,230,150,20);
        label5.setFont(new Font("Tahoma",Font.PLAIN,20));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,229,150,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount  ");
        label6.setBounds(25,280,180,20);
        label6.setFont(new Font("Tahoma",Font.PLAIN,20));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248,280,150,20);
        panel.add(textFieldPending);

        JButton check = new JButton("Check");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q =  "select * from Patient_Info where Name = '"+id+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()) {
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldINTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));
                    }
                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no = '"+textFieldR.getText()+"'");
                    while(resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price)-Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);

                    }

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("Update");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c = new conn();
                    String q= choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINTime.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("update Patient_Info set Room_Number = '"+room+"', Time = '"+time+"', Deposite = '"+amount+"' where name = '"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);

                }catch(Exception E){
                    E.printStackTrace();
                }

            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(168,378,89,23);
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
        setSize(950,550);
        setLocation(400,250);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new update_patient_details();

    }
}
