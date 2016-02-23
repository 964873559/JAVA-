package com.littlewhite.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FrameGame extends JFrame{
	@SuppressWarnings("unused")
	private int screenWidth,frameWidth;
	@SuppressWarnings("unused")
	private int screenHeight,frameHeight;
	private int x,y;
      public FrameGame(PanelGame panelGame){
    	  Toolkit kit = Toolkit.getDefaultToolkit();
    	  Dimension screenSize = kit.getScreenSize();
    	  screenWidth = screenSize.width;
    	  screenHeight = screenSize.height;
    	  frameWidth = 3 * screenWidth / 4;
  		  frameHeight = 3 * screenHeight / 4 +screenHeight/8;
  		  x = screenWidth/21;
  		  y = screenHeight/13;
  		  setSize(1162, 670);
  		  setLocation(x, y);
    	  this.setTitle("¶íÂÞË¹·½¿éBYÐ¡°×");
    	  this.setResizable(false);
    	  add(panelGame);
    	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  this.setVisible(true);
      }
	
}
