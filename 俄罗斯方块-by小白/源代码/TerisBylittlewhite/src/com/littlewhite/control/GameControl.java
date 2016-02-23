package com.littlewhite.control;

import com.littlewhite.dao.Data;
import com.littlewhite.dao.DataBase;
import com.littlewhite.dao.DataDisk;
import com.littlewhite.dto.GameDto;
import com.littlewhite.dto.Player;
import com.littlewhite.service.GameService;
import com.littlewhite.service.PlayerSet;
import com.littlewhite.ui.FrameGame;
import com.littlewhite.ui.JFrameSavePoint;
import com.littlewhite.ui.PanelGame;

public class GameControl {

	public PlayerSet playerSet;
	/*
	 * ������ӿ�A��B
	 */
	private Data DataA;
	private Data DataB;
	
	public PanelGame panelGame;
	protected GameService gameService;
	//��Ϸ����Դ
    protected GameDto dto;
    //��������Ĵ���
    private JFrameSavePoint jframeSavaPoint;
    /*
     * �����߳�
     */
    private Thread gameThread = null;
	/*
	 * ���Panel�Ŀ���
	 */
	public GameControl() {
   	    //�[�򔵓�
   	    GameDto dto = new GameDto();
   	    this.dto = dto;
   	   //�[�򷽉K
   	   GameService service = new GameService(dto);
   	   this.gameService = service;
   	   //��Ҹ�������
   	   PlayerSet playerSet = new PlayerSet();
   	   this.playerSet = playerSet;
  	    //�[�򴰿�
  	    PanelGame panel = new PanelGame(this,dto,playerSet);
		this.panelGame = panel;
        DataA = new DataBase();
        DataB = new DataDisk();
        //��������
        this.dto.setDbRecode(DataA.loadDate());
        this.dto.setDiskRecode(DataB.loadDate());
        //������Ϸ���ڣ���װ��Ϸ���
        new FrameGame(this.panelGame);
        this.jframeSavaPoint = new JFrameSavePoint(this);
        }
	
	/*
	 * ������������
	 */
	
	public void keyUp() {
		//��Ϸ�����ж�
		if(this.gameService.checklose()){
			return;
		}
		//��ͣ�ж�
		if(this.dto.isPause()){
			return;
		}
		this.gameService.keyUp();
		this.panelGame.repaint();
	}
	public void keyDown() {
		//��Ϸ�����ж�
		if(this.gameService.checklose()){
			return;
		}
		//��ͣ�ж�
		if(this.dto.isPause()){
			return;
		}
		this.gameService.keyDown();
		this.panelGame.repaint();
	}
	public void keyLeft() {
		//��ͣ�ж�
		if(this.dto.isPause())
			return;
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}
	public void keyRight() {
		//��ͣ�ж�
		if(this.dto.isPause())
			return;
		this.gameService.keyRight();
		this.panelGame.repaint();
	}
	//���װ��I
	public void keyZ(){
		this.dto.setIscheat(true);
		this.gameService.keyZ();
		this.panelGame.repaint();
	}
//Ѹ������
	public void keyX() {
		//��Ϸ�����ж�
		if(this.gameService.checklose()){
			return;
		}
		//��ͣ�ж�
		if(this.dto.isPause()){
			return;
		}
		this.gameService.keyX();
		this.panelGame.repaint();
	}
	//��ͣ
	public void keySPACE() {
		this.gameService.keySPACE();
	}
	//�_ʼ
	public void keyENTER() {
		this.start();
	}
	//��ʼ��ť�߼�
	public void start() {
		//��ť���ɵ��
		this.panelGame.buttonSwitch(false);
		this.playerSet.setVisible(false);
		this.jframeSavaPoint.setVisible(false);
		//��Ϸ���ݳ�ʼ��
		this.gameService.startMain();
		this.gameThread = new MainThread();
		//�����߳�
	   this.gameThread.start();
	   this.panelGame.repaint();
	   
	}
	
	/*
	 * �߳��ڲ���
	 */
	private class MainThread extends Thread{
		public void run(){
			panelGame.repaint();
			while(dto.isStart()){
				try {
					Thread.sleep(dto.getDowntime());
					if(dto.isPause()){
						panelGame.repaint();
						continue;
					}
					gameService.keyDown();
					panelGame.repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			lose();
		}
	}
	
	
	/*
	 * ʧ�ܺ�Ĳ���
	 */
	private void lose(){
		this.panelGame.buttonSwitch(true);
		if(!this.dto.isIscheat()){
			this.jframeSavaPoint.show(this.dto.getNowpoint());
		}
	}
/*
 * �����������
 */
	public void savePoint(String name) {
		//����Ϸ���ݱ���
		Player p = new Player(name,this.dto.getNowpoint());
		this.DataA.saveData(p);
		this.DataB.saveData(p);
		this.dto.setDbRecode(DataA.loadDate());
	    this.dto.setDiskRecode(DataB.loadDate());
	    //ˢ�»���
	    this.panelGame.repaint();
	}

	public void menu() {
		this.playerSet.playerSet();
	    this.panelGame.repaint();	
	}
	
}
