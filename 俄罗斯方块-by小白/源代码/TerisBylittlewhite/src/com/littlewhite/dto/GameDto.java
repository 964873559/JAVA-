package com.littlewhite.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.littlewhite.entity.GameAct;

public class GameDto {

	private List<Player> dbRecode;
	private List<Player> diskRecode;
	private boolean[][] gameMap;
	private GameAct gameAct;
	private int next;
	private int level;
	private int nowpoint;
	private int moveline;
	private boolean start;
	private boolean pause;
	private boolean ischeat;
	private int downtime;
	
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public GameDto() {
		dtoInit();
	}
	/*
	 * dto�ĳ�ʼ��
	 */
	public void dtoInit(){
		this.gameMap = new boolean[10][18];
		this.level = 0;
		this.nowpoint = 0;
		this.moveline = 0;
		this.pause = false;
		this.ischeat = false;
		this.downtime =1000- this.getLevel()*18;
	}
	/*
	 * ���ݴ�����
	 */
	private List<Player> setAllData(List<Player> data){
		if(data == null){
			data = new ArrayList<Player>();
		}
		while(data.size()<5){
			data.add(new Player("No Data",0));
		}
		Collections.sort(data);
		return data;
	}
	
	/*
	 * �������GET��SET����
	 */
	public List<Player> getDbRecode() {
		return dbRecode;
	}
	public void setDbRecode(List<Player> dbRecode) {
		this.dbRecode = this.setAllData(dbRecode);
	}
	/*
	 * ����ӛ䛵�GET��SET����
	 */
	public List<Player> getDiskRecode() {
		return diskRecode;
	}
	public void setDiskRecode(List<Player> diskRecode) {
		this.diskRecode = this.setAllData(diskRecode);
	}
	/*
	 * �[��؈D��GET��SET����
	 */
	public boolean[][] getGameMap() {
		return gameMap;
	}
	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}
	/*
	 * �[�򷽉K��GET��SET����
	 */
	public GameAct getGameAct() {
		return gameAct;
	}
	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}
	/*
	 * ��һ���ŉK��GET��SET����
	 */
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	/*
	 * �ȼ���GET��SET����
	 */
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
		if(this.level<=50)
			this.downtime =1000- this.level*18;
		else
		    this.downtime = 100;
	}
	/*
	 * �֔���GET��SET����
	 */
	public int getNowpoint() {
		return nowpoint;
	}
	public void setNowpoint(int nowpoint) {
		this.nowpoint = nowpoint;
	}
	/*
	 * ���е�GET��SET����
	 */
	public int getMoveline() {
		return moveline;
	}
	public void setMoveline(int moveline) {
		this.moveline = moveline;
	}
	public boolean isPause() {
		return pause;
	}
	public void changePause() {
		this.pause =!this.pause;
	}
	//�����Ƿ�����
	public boolean isIscheat() {
		return ischeat;
	}
	public void setIscheat(boolean ischeat) {
		this.ischeat = ischeat;
	}
	public int getDowntime() {
		return downtime;
	}
	
}
