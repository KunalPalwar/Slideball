package com.example.java;

import java.awt.*;



public class Grid {
    public int map[][];
    public int brickwidth;
    public int brickheight;
    private int row;
    private int col;
    public Grid(int row,int col){
        map=new int[row][col];
        this.row =row;
        this.col=col;
        this.brickwidth=60;
        this.brickheight=35;
        for(int i=0;i<row;i++)
            for(int j=0;j<map[0].length;j++)
                map[i][j]=1;
    }


    public void draw(Graphics2D g){
        for(int i=0;i<map.length;i++)
            for(int j=0;j<map[0].length;j++)
                if (map[i][j]>0){
                    g.setColor(Color.WHITE);
                    g.fillRect(j*brickwidth+125,i*brickheight+80,brickwidth,brickheight);

                    g.setColor(Color.BLACK);
                    g.setStroke(new BasicStroke(3));
                    g.drawRect(j*brickwidth+125,i*brickheight+80,brickwidth,brickheight);

                }
    }
    public void setMap(int value,int i, int j){
        map[i][j]=value;
    }

}
