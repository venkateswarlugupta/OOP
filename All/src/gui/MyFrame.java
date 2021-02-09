package gui;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){
        this.setTitle("First JFrame");//sets title of this
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        this.setResizable(false);//prevent this from being resized
        this.setSize(400,400);//sets x,y dimensions of the this
        this.setVisible(true);//make this visible
        ImageIcon image=new ImageIcon("src\\gui\\logo.jpg");//create an image icon
        this.setIconImage(image.getImage());//change icon of this
        this.getContentPane().setBackground(new Color(0x123456));
    }
}
