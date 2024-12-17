package hospital.management.system;

import javax.swing.*;
import java.awt.*;

public class bg extends JFrame {

    bg() {
        setSize(500, 500);
        setLayout(null);
        setTitle("BG Image");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400,100);

        ImageIcon img = new ImageIcon("icons/BG.png");
        JLabel label = new JLabel();
        label.setBounds(0, 0, 1200, 700);
        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        new bg();
    }
}
