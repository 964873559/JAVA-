package com.littlewhite.service;

import java.awt.Point;

import com.littlewhite.dto.GameDto;
import com.littlewhite.entity.GameAct;

public class GameService {
	private GameDto dto;


	public GameService(GameDto dto ){
		this.dto = dto;
	}


	/*
	 * ������������
	 */
	

	public void keyUp() {
		synchronized (this.dto) {
			this.dto.getGameAct().round(this.dto.getGameMap());
		}
		
	}
	public boolean keyDown() {
		synchronized (this.dto) {
				if(this.dto.getGameAct().move(0,1,this.dto.getGameMap())){
					return false;
				}
				//�@���[��؈D
				boolean[][] map  = this.dto.getGameMap();
				Point[] act =this.dto.getGameAct().getActPoint();
				for(int i = 0;i<act.length;i++){
					map[act[i].x][act[i].y] = true;
					
				}
				int exp = this.moveLine();
				//��������
				this.levelUp(exp);
				//������һ������
				this.dto.getGameAct().init(this.dto.getNext());
				//���������һ������
				this.dto.setNext((int)(Math.random()*1000)%7);
				//�Д��Ƿ��[��Y��
				if(this.checklose()){
					this.dto.setStart(false);
				}
				return true;
			}
	}
/*
 * Ѹ������
 */
	public void keyX() {
		while(!this.keyDown());
	}

	public boolean checklose() {
		Point[] points = this.dto.getGameAct().getActPoint();
		boolean[][] map = this.dto.getGameMap();
		for(int i = 0;i<points.length;i++){
			if(map[points[i].x][points[i].y]){
				return true;
			}
		}
		return false;
	}     


	/*
	 * ��������
	 */
	private void levelUp(int exp) {
		int lv = this.dto.getLevel();
		int rmline = this.dto.getMoveline();
		int point = this.dto.getNowpoint();
		switch(exp){
		case 1:
			this.dto.setNowpoint(point+10);
			break;
		case 2:
			this.dto.setNowpoint(point+20);
			break;
		case 3:
			this.dto.setNowpoint(point+40);
			break;
		case 4:
			this.dto.setNowpoint(point+80);
			break;
			}
		this.dto.setMoveline(exp+rmline);
		if(rmline%20+exp>=20){
			this.dto.setLevel(++lv);
		}
	}


	/*
	 * ���в���
	 */
	private int moveLine(){
		boolean[][] map  = this.dto.getGameMap();
		int exp = 0;
		for(int y = 0;y<18;y++)
			if(this.judgeMoveLine(y, map))
			{
				this.removeLine(y,map);
				exp++;
			}
		return exp;
		}
	
	
	private void removeLine(int rowNumber,boolean[][] map) {
		for(int x = 0;x<10;x++)
			for(int y = rowNumber;y>0;y--){
				map[x][y] = map[x][y-1];
			}
	}


	/*
	 * ����ɨ���Ƿ�����
	 */
	private boolean judgeMoveLine(int y,boolean[][] map){
		for(int x = 0;x<10;x++){
			if(!map[x][y])
			{
				return false;
			}
		}
		return true;
	}
	
	public void keyLeft() {
		synchronized (this.dto) {
				this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
		}
	}
	public void keyRight() {
		synchronized (this.dto) {
				this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
		}
	}
	
//�����̵ķ���
	public void startMain() {
		GameAct act = new GameAct();
		this.dto.setNext((int)(Math.random()*1000)%7);
		this.dto.setGameAct(act);
		this.dto.setStart(true);
		//��ʼ������
		this.dto.dtoInit();
	}
	
	
	//���װ��I����
	public void keyZ() {
		int point = this.dto.getNowpoint();
		int rmline = this.dto.getMoveline();
		int lv = this.dto.getLevel();
		point+=10;
		rmline+=1;
		if(rmline%20==0)
			lv+=1;
		this.dto.setNowpoint(point);
		this.dto.setLevel(lv);
		this.dto.setMoveline(rmline);
	}


	public void keySPACE() {
		if(this.dto.isStart()){
			this.dto.changePause();
		}
	}




}
