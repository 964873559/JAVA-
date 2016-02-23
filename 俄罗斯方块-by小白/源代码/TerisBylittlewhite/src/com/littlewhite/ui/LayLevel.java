package com.littlewhite.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayLevel extends Lay {

	public static Image IMG_DJ = new ImageIcon("Graphics/string/level.png").getImage();
	
	public static Image IMG_NB = new ImageIcon("Graphics/string/number.png").getImage();
	public static int NB_W = 40;
	public static int NB_H = 50;
	
	public  LayLevel(int x, int y, int w, int h) {
		super(x,y,w,h);
		
	}
	
	/*
	 *繪製等級
	 */
	public void paint(Graphics g){
		int lv = this.dto.getLevel();
		this.paintWindow(g);
		g.drawImage(IMG_DJ, this.x+2*X/3, this.y+2*Y/3,null);
		if(lv>=99){
			this.drawN(15, 52, 99, g);
		}
		else{
			this.drawN(15, 52, this.dto.getLevel(), g);
		}
	}
	
	public void drawN(int x,int y,int number, Graphics g){
		//判断数字是否是个位数
		if(number<10)
		for(int i = 0;i<2;i++){
			if(i==0)
			g.drawImage(IMG_NB,this.x+x+NB_W*i,this.y+y,this.x+x+NB_W*(i+1),this.y+y+NB_H,0,0,NB_W,NB_H,null);
			else
			g.drawImage(IMG_NB,this.x+x+NB_W*i,this.y+y,this.x+x+NB_W*(i+1),this.y+y+NB_H,number*NB_W,0,(number+1)*NB_W,NB_H,null);
		}
		else
		this.drawNumber(x+15, y, number, g);
	}
}
