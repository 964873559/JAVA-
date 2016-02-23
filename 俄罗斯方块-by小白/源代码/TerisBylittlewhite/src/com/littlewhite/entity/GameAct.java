package com.littlewhite.entity;

import java.awt.Point;


public class GameAct {
/*
 * ���K���M
 */
	private  Point[] actPoint;
	
	private static int MIN_X = 0;
	private static int MAX_X = 9;
	private static int MIN_Y = 0;
	private static int MAX_Y = 17;
	public int type =0;
	
	public GameAct(){
		this.init((int)(Math.random()*1000)%7);
	}
/*
 * �ų����K5�����D
 */
	public void init(int actCode){
		//ˢ�·���
		this.type=actCode;
		switch(actCode){
		case 0:
			actPoint = new Point[]{
					new Point(4,0),
					new Point(3,0),
					new Point(5,0),
					new Point(6,0),
			};
			break;
	case 1:
		actPoint = new Point[]{
				new Point(4,0),
				new Point(5,0),
				new Point(3,1),
				new Point(4,1),
		};
		break;
	case 2:
		actPoint = new Point[]{
				new Point(4,0),
				new Point(3,0),
				new Point(4,1),
				new Point(5,1),
		};
		break;
	case 3:
		actPoint = new Point[]{
				new Point(4,0),
				new Point(3,0),
				new Point(5,0),
				new Point(4,1),
		};
		break;
	case 4:
		actPoint = new Point[]{
				new Point(4,0),
				new Point(3,0),
				new Point(5,0),
				new Point(3,1),};
		break;
	case 5:
		actPoint = new Point[]{
				new Point(4,0),
				new Point(5,0),
				new Point(4,1),
				new Point(5,1),
		};
		break;
	case 6:
		actPoint = new Point[]{
				new Point(4,0),
				new Point(3,0),
				new Point(5,0),
				new Point(5,1),
		};
		break;
	}
	}
	
	
	public Point[] getActPoint() {
		return actPoint;
	}
	
	/*
	 * ���K���ж�
	 */
	public boolean move(int moveX,int moveY,boolean[][] gameMap){
		for(int i = 0;i<actPoint.length;i++){
			int newX = actPoint[i].x+moveX;
			int newY = actPoint[i].y+moveY;
			if(this.isOverMap(newX, newY,gameMap))
				return false;
		}
		for(int i = 0;i<actPoint.length;i++){
			actPoint[i].x+=moveX;
			actPoint[i].y+=moveY;
		}
		return true;
 	}
	/*
	 * �������ת
	 */
	
	public void round(boolean[][] gameMap){
		if(type ==5)
			return;
		for(int i = 1;i<actPoint.length;i++){
			int newX = actPoint[0].y+actPoint[0].x-actPoint[i].y;
			int newY = actPoint[0].y-actPoint[0].x+actPoint[i].x;
			if(this.isOverMap(newX, newY,gameMap))
				return;
		}
		for(int i =1;i<actPoint.length;i++){
			int newX = actPoint[0].y+actPoint[0].x-actPoint[i].y;
			int newY = actPoint[0].y-actPoint[0].x+actPoint[i].x;
			actPoint[i].x= newX;
			actPoint[i].y= newY;
		}
	}
	/*
	 * ���õ�߉݋�Ϊ����b
	 */
	
	public boolean isOverMap(int x,int y,boolean[][] gameMap){
		return x<MIN_X||x>MAX_X||y<MIN_Y||y>MAX_Y||gameMap[x][y];
	}
}
