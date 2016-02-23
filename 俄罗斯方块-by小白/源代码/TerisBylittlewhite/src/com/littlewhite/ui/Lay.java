package com.littlewhite.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.littlewhite.dto.GameDto;
import com.littlewhite.service.PlayerSet;

//画边框

public class Lay {
	public static void set(String path)
	{
		IMG = new  ImageIcon(path)//
		.getImage();
	}
	//无边框改动
	public PlayerSet playerSet;
	
	public static final int SIZE = 7;
	public static final int X=20;
	public static final int Y=16;
	public static Image IMG = new ImageIcon("Graphics/window/Window00.png")
			.getImage();
	public static final int IMGW = IMG.getWidth(null);
	public static final int IMGH = IMG.getHeight(null);
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected GameDto dto = null;
	//數字畫法常量
	public static Image IMG_NB = new ImageIcon("Graphics/string/number.png").getImage();
	public static int NB_W = 40;
	public static int NB_H = 50;

	//画槽常量
	public static Image IMG_EXP = new ImageIcon("Graphics/window/exp.png")
	.getImage();
	public static Font DEF_FONT = new Font("黑体",Font.BOLD,20);
	public Lay(int x, int y, int w, int h) {

		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

    public void paint(Graphics g){
    	
    }
/*
 * 画边框
 */
	protected void paintWindow(Graphics g) {
		
			g.drawImage(IMG, x, y, x + SIZE, y + SIZE, 0, 0, SIZE, SIZE, null);
			g.drawImage(IMG, x + SIZE, y, x + w - SIZE, y + SIZE, SIZE, 0, IMGW
					- SIZE, SIZE, null);
			g.drawImage(IMG, x + w - SIZE, y, x + w, y + SIZE, IMGW - SIZE, 0,
					IMGW, SIZE, null);
			g.drawImage(IMG, x, y + SIZE, x + SIZE, h + y - SIZE, 0, SIZE, SIZE,
					IMGH - SIZE, null);
			g.drawImage(IMG, x, h + y - SIZE, x + SIZE, h + y, 0, IMGH - SIZE,
					SIZE, IMGH, null);
			g.drawImage(IMG, x + SIZE, h + y - SIZE, x + w - SIZE, h + y, SIZE,
					IMGH - SIZE, IMGW - SIZE, IMGH, null);
			g.drawImage(IMG, x + w - SIZE, h + y - SIZE, x + w, h + y, IMGW - SIZE,
					IMGH - SIZE, IMGW, IMGH, null);
			g.drawImage(IMG, x + w - SIZE, y + SIZE, x + w, y + h - SIZE, IMGW
					- SIZE, SIZE, IMGW, IMGH - SIZE, null);
			g.drawImage(IMG, x + SIZE, y + SIZE, x + w - SIZE, y + h - SIZE, SIZE,
					SIZE, IMGW - SIZE, IMGH - SIZE, null);
	}
	
	/*
	 * 封裝分割數字的畫法
	 */
	//分割数字
	public void drawNumber(int x,int y,int number, Graphics g){
		String strNum = Integer.toString(number);
		for(int i = 0;i<strNum.length();i++){
			int bit = strNum.charAt(i)-'0';
			g.drawImage(IMG_NB,this.x+x+NB_W*i-15,this.y+y,this.x+x+NB_W*(i+1)-15,this.y+y+NB_H,bit*NB_W,0,(bit+1)*NB_W,NB_H,null);
		}
	}
	
	/*
	 * 封装画槽的方法
	 */
	public void drawCao(int x,int y,int locY,String string,String number ,double percent, Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(this.x + X + 5, this.y + 3 * Y / 2 + locY, x,y);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(this.x + X + 5 + 2, this.y + 3 * Y / 2 + locY + 2, x - 4,
				y - 4);
		g.setColor(Color.black);
		g.fillRect(this.x + X + 5 + 4, this.y + 3 * Y / 2 + locY + 4, x - 8,
				y-8);
		//经验槽外框
		int w = (int) (percent * (x - 8));
	 //经验槽内部
		int exp = (int)(percent*320)-1;
		g.drawImage(IMG_EXP, this.x + X + 5 + 4, this.y + 3 * Y / 2 + locY + 4,
				this.x + X + 5 + 4+w, this.y + 3 * Y / 2 + locY + 4+y- 8, exp, 0, exp+1, 32, null);
		g.setFont(DEF_FONT);
		g.setColor(Color.white);
		g.drawString(string,this.x + X + 10 + 4 , this.y + 3 * Y / 2 + locY+18 + 4);
		if(number!=null){
			g.drawString(number,this.x + X + 200 , this.y + 3 * Y / 2 + locY+18 + 4);
		}
	}


	public GameDto getDto() {
		return dto;
	}

	public void setDto(GameDto dto){
		this.dto = dto;
	}
}