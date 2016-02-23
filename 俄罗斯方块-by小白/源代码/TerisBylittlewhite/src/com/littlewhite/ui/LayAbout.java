package com.littlewhite.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayAbout extends Lay {
	private Image ABOUT = new ImageIcon("Graphics/other/about.png").getImage();
	public LayAbout(int x, int y, int w, int h) {
		super(x, y, w, h);

	}

	public void paint(Graphics g) {
		this.paintWindow(g);
		g.drawImage(ABOUT, this.x, this.y, null);
	}
}
