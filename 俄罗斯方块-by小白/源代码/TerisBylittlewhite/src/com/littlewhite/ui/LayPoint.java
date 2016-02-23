package com.littlewhite.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayPoint extends Lay {

	public static Image IMG_FS = new ImageIcon("Graphics/string/fenshu.png")
			.getImage();
	public static Image IMG_XH = new ImageIcon("Graphics/string/xiaohang.png")
			.getImage();
	//exp槽的高度、长、宽
    public static int locEXP_Y = 90;
	public static int EXP_W=290;
	public static int EXP_H=30;

	public static Image IMG_NB = new ImageIcon("Graphics/string/number.png")
			.getImage();
	public static int NB_W = 40;
	public static int NB_H = 50;
	

	public LayPoint(int x, int y, int w, int h) {
		super(x, y, w, h);

	}

	public void paint(Graphics g) {
		this.paintWindow(g);
		// 顯示分數
		g.drawImage(IMG_FS, this.x + X, this.y + 2 * Y / 3, null);
		this.drawWhat(135, 8, this.dto.getNowpoint(), g);
		// 顯示消行
		g.drawImage(IMG_XH, this.x + X, this.y + 3 * Y / 2 + 40, null);
		this.drawWhat(135, 57, this.dto.getMoveline(), g);
		// 获取已消行，画Exp
		int rmline = this.dto.getMoveline();
		this.drawCao(EXP_W,EXP_H,locEXP_Y,"下一级",null,(double) (rmline % 20)/20.00, g);
	}

	/*
	 * 繪製方法
	 */

	public void drawWhat(int x, int y, int number, Graphics g) {
		String strNum = Integer.toString(number);
		// 判断几位数，不够五位的前面补零
		switch (5 - strNum.length()) {
		case 0:
			this.drawNumber(x, y, number, g);
			break;
		case 1:
			for (int i = 0; i < 1; i++)
				g.drawImage(IMG_NB, this.x + x + NB_W * i - 15, this.y + y,
						this.x + x + NB_W * (i + 1) - 15, this.y + y + NB_H, 0,
						0, NB_W, NB_H, null);
			this.drawNumber(x * 5 / 4 + 5, y, number, g);
			break;
		case 2:
			for (int i = 0; i < 2; i++)
				g.drawImage(IMG_NB, this.x + x + NB_W * i - 15, this.y + y,
						this.x + x + NB_W * (i + 1) - 15, this.y + y + NB_H, 0,
						0, NB_W, NB_H, null);
			this.drawNumber(x * 4 / 3 + 33, y, number, g);
			break;
		case 3:
			for (int i = 0; i < 3; i++)
				g.drawImage(IMG_NB, this.x + x + NB_W * i - 15, this.y + y,
						this.x + x + NB_W * (i + 1) - 15, this.y + y + NB_H, 0,
						0, NB_W, NB_H, null);
			this.drawNumber(x * 3 / 2 + 50, y, number, g);
			break;
		case 4:
			for (int i = 0; i < 4; i++)
				g.drawImage(IMG_NB, this.x + x + NB_W * i - 15, this.y + y,
						this.x + x + NB_W * (i + 1) - 15, this.y + y + NB_H, 0,
						0, NB_W, NB_H, null);
			this.drawNumber(x * 2 + 25, y, number, g);
			break;
		}
	}
}
