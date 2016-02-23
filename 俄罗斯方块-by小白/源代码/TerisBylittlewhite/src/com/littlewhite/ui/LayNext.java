package com.littlewhite.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayNext extends Lay {

	public static Image[] NEXT_ACT = {
		new ImageIcon("Graphics/game/1.png").getImage(),
		new ImageIcon("Graphics/game/2.png").getImage(),
		new ImageIcon("Graphics/game/3.png").getImage(),
		new ImageIcon("Graphics/game/4.png").getImage(),
		new ImageIcon("Graphics/game/5.png").getImage(),
		new ImageIcon("Graphics/game/6.png").getImage(),
		new ImageIcon("Graphics/game/7.png").getImage()
	};
	
	
	public static Image IMG_NT = new ImageIcon("Graphics/string/next.png").getImage();
	public  LayNext(int x, int y, int w, int h) {
		super(x,y,w,h);
		
	}
	
	public void paint(Graphics g){
		this.paintWindow(g);
		g.drawImage(IMG_NT, this.x+X*2/5, this.y+Y*2/5,null);
		if(this.dto.isStart()){
			if(this.dto.getNext()==0)
				g.drawImage(NEXT_ACT[this.dto.getNext()],this.x+32,this.y+55,null);
			else if(this.dto.getNext()==5)
				g.drawImage(NEXT_ACT[this.dto.getNext()],this.x+60,this.y+50,null);
			else
				g.drawImage(NEXT_ACT[this.dto.getNext()],this.x+55,this.y+50,null);
			
		}
	}
}
