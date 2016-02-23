package com.littlewhite.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import com.littlewhite.entity.GameAct;

public class LayGame extends Lay {


	//���K
	private static Image ACT = new ImageIcon("Graphics/game/rect.png")
			.getImage();

	//��ͣ�DƬ
	public static Image pause = new ImageIcon("Graphics/string/zanting.png").getImage();
	
	public LayGame(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	/*
 * ���Ӱ���k��
 */
	private void showShadow(Point[] points,boolean b,Graphics g){
		if(!b)
			return;
		int LEFT_X =0;
		int RIGHT_X =9;
		for(Point p:points){
			LEFT_X=p.x<LEFT_X?LEFT_X:p.x;
			RIGHT_X=p.x>RIGHT_X?RIGHT_X:p.x;
		}
		g.setColor(new Color(255,0,0,70));
		g.fillRect(this.x+SIZE+RIGHT_X*32, this.y+SIZE, (LEFT_X-RIGHT_X+1)*32, this.h-2*SIZE);
	}
	
	public void paint(Graphics g) {
		this.paintWindow(g);
		GameAct ACT = this.dto.getGameAct();
		if(ACT != null){
			Point[] points = this.dto.getGameAct().getActPoint();
			//������Ӱ����
			this.showShadow(points, true, g);
			//�L�u��ӷ��K
			this.drawMoveAct(points,g);
		}
		//�L�u��ӵ؈D
		this.drawMap(g);
		//�L�u��ͣ
		if(this.dto.isPause()){
			g.drawImage(pause, 490, 250, null);
		}
	}
	/*
	 * �L�u��ӷ��K
	 */
	private void drawMoveAct(Point[] points,Graphics g) {
		//��ӡ���K
		int typeCode = this.dto.getGameAct().type;
		for (int i = 0; i < points.length; i++) {
			g.drawImage(ACT, this.x+7 + points[i].x * 32, this.y + points[i].y
					* 32+7, this.x +7+ points[i].x * 32 + 32, this.y + points[i].y
					* 32 + 32+7, 32*(typeCode+1), 0, 32*(typeCode+2), 32, null);
			
		}
	}
/*
 * �L�u�؈D
 */
	private void drawMap(Graphics g) {
		//��ӡ�؈D
		boolean[][] map = this.dto.getGameMap();
		//��ͬ�ȼ���ɫ��һ��
		int ID = this.dto.getLevel();
	    int ID_ACT;
	    if(ID==0)
	        ID_ACT = ID;
	    else
	    	ID_ACT = ID%7+1;
	    /*
	     * �����ѽ��ѷe�ķ��K
	     */
	    if(!this.dto.isStart()){
	    	ID_ACT = 8;
	    	for(int i = 0;i<10;i++)
	    		if(map[i][17]){
	    			for(int x=3;x<6;x++){
	    				for(int y= 0;y<2;y++){
	    					g.drawImage(ACT, this.x+7 +x * 32, this.y + y
	    							* 32+7, this.x +7+ x * 32 + 32, this.y + y
	    							* 32 + 32+7, ID_ACT*32, 0, (ID_ACT+1)*32, 32, null);
	    				}
	    			}
	    		}
	    }
		for(int x=0;x<map.length;x++){
			for(int y= 0;y<map[x].length;y++){
				if(map[x][y]){
					g.drawImage(ACT, this.x+7 +x * 32, this.y + y
							* 32+7, this.x +7+ x * 32 + 32, this.y + y
							* 32 + 32+7, ID_ACT*32, 0, (ID_ACT+1)*32, 32, null);
				}
			}
		}
	}
}
