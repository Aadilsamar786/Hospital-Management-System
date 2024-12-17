package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends JFrame {

    reception (){


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1520,670);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 1520,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dr.png"));
        Image image= i1.getImage().getScaledInstance(245,245,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1300,0,250,250);
        panel1.add(label);
//
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/amb.png"));
        Image image1= i11.getImage().getScaledInstance(300,100,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1 = new JLabel(i22);
        label1.setBounds(1000,50,300,100);
        panel1.add(label1);

        JButton btn1 = new JButton("Add new pateint");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(new Color(226,228,239));
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new NEW_PATEINT();
            }
        });


    JButton btn2 = new JButton("Room");
    btn2.setBounds(30,58,200,30);
    btn2.setBackground(new Color(226, 228, 239));
    panel1.add(btn2);
    btn2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new room();

        }
    });


    JButton btn3 = new JButton("Department");
    btn3.setBounds(30,102,200,30);
    btn3.setBackground(new Color(226,228,239));
    panel1.add(btn3);
    btn3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Department();

        }
    });

    JButton btn4 =new JButton("All Employee Info");
    btn4.setBounds(270,15,200,30);
    btn4.setBackground(new Color(226,228,239));
    panel1.add(btn4);
    btn4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Employe_info();

        }
    });


    JButton btn5 = new JButton("Pateint Info");
    btn5.setBounds(270,58,200,30);
    btn5.setBackground(new Color(226,228,239));
    panel1.add(btn5);
    btn5.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ALL_patient_Info();
        }
    });

    JButton btn6 = new JButton("pateint Discharge");
    btn6.setBounds(270,102,200,30);
    btn6.setBackground(new Color(226,228,239));
    panel1.add(btn6);
    btn6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new patient_discharge();

        }
    });


    JButton btn7 = new JButton("Update Pateint Details");
    btn7.setBounds(510,15,200,30);
    btn7.setBackground(new Color(226,228,239));
    panel1.add(btn7);
    btn7.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new update_patient_details();
        }
    });

    JButton btn8 = new JButton("Ambulance");
    btn8.setBounds(510,58,200,30);
    btn8.setBackground(new Color(226,228,239));
    panel1.add(btn8);
    btn8.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Ambulance();

        }
    });

    JButton btn9 = new JButton("Search Rooms");
    btn9.setBounds(510,102,200,30);
    btn9.setBackground(new Color(226,228,239));
    panel1.add(btn9);
    btn9.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Searchroom();

        }
    });

    JButton btn10 = new JButton("Logout");
    btn10.setBounds(750,15,200,30);
    btn10.setBackground(new Color(226,228,239));
    panel1.add(btn10);
    btn10.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Login();
        }
    });


        setSize(1950,1090);
        getContentPane().setBackground(Color.PINK);
        setTitle("Reception");
        setLayout(null);
        setVisible(true);
    }



    public static void main(String[]args){
        new reception();

    }
}