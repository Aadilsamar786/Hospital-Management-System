package hospital.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.sql.ResultSet;


public class Login  extends  JFrame implements ActionListener {

    JTextField textField;

    JPasswordField jPasswordField;

    JButton b1,b2;


    Login(){

    JLabel namelabel=new JLabel("Username");
    namelabel.setBounds(40, 26, 100,30 );
    namelabel.setFont(new Font("Tahoma0",Font.BOLD,20));
    namelabel.setForeground(Color.BLACK);
    add(namelabel);

    JLabel password=new JLabel("password");
    password.setBounds(40, 80, 100,30 );
    password.setFont(new Font("Tahoma0",Font.BOLD,20));
    password.setForeground(Color.BLACK);
    add(password);

    textField=new JTextField();
    textField.setBounds(150, 30, 150,30 );
    textField.setFont(new Font("Tahoma",Font.PLAIN,15));
    textField.setForeground(Color.BLACK);
    textField.setBackground(new Color(255,179,0));
    add(textField);

//    password Field
    jPasswordField=new JPasswordField();
    jPasswordField.setBounds(150, 80, 150,30 );
    jPasswordField.setFont(new Font("Tahoma",Font.PLAIN,15));
    jPasswordField.setBackground(Color.BLACK);
    jPasswordField.setBackground(new Color(255,179,0));
    add(jPasswordField);

    ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
    Image i1= imageIcon.getImage().getScaledInstance( 300,300,Image.SCALE_DEFAULT);
    ImageIcon imageIcon1=new ImageIcon(i1);
    JLabel label=new JLabel(imageIcon1);
    label.setBounds(250, 30, 500,250 );
    add(label);

    b1=new JButton("Login");
    b1.setBounds(40, 180, 120,30 );
    b1.setFont(new Font("serif",Font.BOLD,15));
    b1.setForeground(Color.WHITE);
    b1.setBackground(Color.BLACK);
    b1.addActionListener(this);
    add(b1);

    b2=new JButton("Cancel");
    b2.setBounds(180, 180, 120,30 );
    b2.setFont(new Font("serif",Font.BOLD,15));
    b2.setForeground(Color.WHITE);
    b2.setBackground(Color.BLACK);
    b2.addActionListener(this);
    add(b2);





        getContentPane().setBackground(new Color(205, 212, 219));
        setSize( 500,300);
        setTitle("Login ");
        setLocation(400,270);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conn c = new conn();
                String user = textField.getText();
                String pass = jPasswordField.getText();

                String q = "select * from login where ID= '" + user + "' and PW = '" + pass + "'";
                ResultSet resultSet = (ResultSet) c.statement.executeQuery(q);


                if (resultSet.next()) {
                    new reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Details");

                }


            } catch (Exception E) {
                E.printStackTrace();
            }


            } else{
                System.exit(10);

            }
        }

    public static void main(String[]args){
        new Login();

}

}