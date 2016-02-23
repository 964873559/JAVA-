package com.littlewhite.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import com.littlewhite.dto.Player;
/*
 * 封装画数据库和本地记录的方法
 */
public class LayData extends Lay {
	//Data的高度初始、长、宽
	public static int locDATA_Y = 30;
	public static int DATA_W = 285;
	public static int DATA_H = 30;
	
	public LayData(int x, int y, int w, int h) {
		super(x,y,w,h);
	}
	public void paintWindow(Graphics g,Image title,List<Player> players){
		this.paintWindow(g);
		g.drawImage(title, this.x+X+5, this.y+Y-5, null);
		//画数据库
		int nowPoint = this.dto.getNowpoint();
		for(int i =0;i<5;i++){
			Player p = players.get(i);
			double percent = (double)nowPoint/p.getPoint();
			String string = Integer.toString(p.getPoint()) == null? null : Integer.toString(p.getPoint());
			percent = percent>1?1.0:percent;
			this.drawCao(DATA_W, DATA_H, locDATA_Y +45*i,p.getName(), string,percent, g);
	}
}}
