package com.littlewhite.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayDateBase extends LayData {

	public static Image IMG_SJ = new ImageIcon("Graphics/string/shujuku.png").getImage();
	
	public  LayDateBase(int x, int y, int w, int h) {
		super(x,y,w,h);
		
	}
	
	public void paint(Graphics g){
		this.paintWindow(g, IMG_SJ, this.dto.getDbRecode());
	}
}
