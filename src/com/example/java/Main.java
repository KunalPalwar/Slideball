package com.example.java;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        JFrame obj=new JFrame();
        Gameplay game=new Gameplay();
        obj.add(game);
        obj.setBounds(1,1,700,600);
        obj.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        obj.setResizable(false);
        obj.setTitle("SLIDING BALL GAME");
        obj.setVisible(true);

    }
}
