package com.example.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements ActionListener, KeyListener {
    private int totalBrick;
    private boolean play=false;
    private Timer timer;
   private Grid grid;
   private Sound sound;
    private int ballX=310;
    private int ballY=350;
    private int ballXdir=-1;
    private int ballYdir=-5;

    private int barX=100;

    public Gameplay(){
        grid = new Grid(3,7);
        sound = new Sound();
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        setFocusable(true);
        timer=new Timer(8,this);
        timer.start();






    }
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(2,2,698,592);

        grid.draw((Graphics2D) g);
        //border
        g.setColor(Color.yellow);
        g.fillRect(0,0,700,10);
        g.fillRect(0,2,10,592);
        g.fillRect(674,2,10,590);

        //ball
        g.setColor(Color.CYAN);
        g.fillOval(ballX,ballY,20,20);

        //slide bar
        g.setColor(Color.GREEN);
        g.fillRect(barX,543,150,13);

        g.dispose();


    }









    @Override
    public void actionPerformed(ActionEvent e) {
       timer.start();
       if (play){

           for (int i=0;i<grid.map.length;i++)
               for (int j=0;j<grid.map[0].length;j++)
                   if (grid.map[i][j]>0)
                   {
                       int brickX=j*grid.brickwidth+125;
                       int brickY=i* grid.brickheight+80;
                       int brickwidth= grid.brickwidth;
                       int brickheight= grid.brickheight;

                       Rectangle ball=new Rectangle(ballX,ballY,20,20);
                       Rectangle brick= new Rectangle(brickX,brickY,brickwidth,brickheight);

                       if (ball.intersects(brick)){
                           grid.setMap(0,i,j);

                           if (ballX + 19 <= brick.x||ballY + 1 > brick.x + brick.width)
                           ballXdir = - ballXdir;
                           else
                               ballYdir = -ballYdir;
                       }
                   }

            if (new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(barX,543,150,13))){
               sound.setupMidi(34,3);
           }

           if (new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(barX,543,150,13)))
           {
               ballYdir= -ballYdir;
           }

           ballX+=ballXdir;
           ballY+=ballYdir;
           if (ballX<9)
               ballXdir=-ballXdir;
           if (ballY<3)
               ballYdir= -ballYdir;
           if (ballX>655)
               ballXdir = -ballXdir;
       }

       repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if(barX>=672-150-13)
                barX=672-150;
            else
            {play=true;
                barX+=20;}

        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT){
            if (barX<=25)
                barX=12;
            else
            { play=true;
                barX-=20;
        }}

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
