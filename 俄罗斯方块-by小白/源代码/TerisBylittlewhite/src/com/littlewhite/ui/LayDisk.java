package com.littlewhite.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayDisk extends LayData {

	public static Image IMG_BD = new ImageIcon("Graphics/string/jilu.png").getImage();
	public  LayDisk(int x, int y, int w, int h) {
		super(x,y,w,h);
		
	}
	
	public void paint(Graphics g){
		this.paintWindow(g, IMG_BD, this.dto.getDiskRecode());
	}
}
