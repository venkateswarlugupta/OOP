package gui;

import javax.swing.*;
import java.awt.*;

public class Main2 {
    public static void main(String[] args) {
        ImageIcon image=new ImageIcon("src\\gui\\kxip.jpg");

        JLabel label=new JLabel();
        label.setText("Hi Venkatesh");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(0,100,200));
        label.setFont(new Font("MV Boli",Font.PLAIN,20));
        label.setIconTextGap(100);
        label.setBackground(Color.BLACK);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.add(label);
    }
}
