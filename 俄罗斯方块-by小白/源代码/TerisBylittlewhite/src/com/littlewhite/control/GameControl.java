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
	 * 數據庫接口A、B
	 */
	private Data DataA;
	private Data DataB;
	
	public PanelGame panelGame;
	protected GameService gameService;
	//游戏数据源
    protected GameDto dto;
    //保存分数的窗口
    private JFrameSavePoint jframeSavaPoint;
    /*
     * 创建线程
     */
    private Thread gameThread = null;
	/*
	 * 获得Panel的控制
	 */
	public GameControl() {
   	    //遊戲數據
   	    GameDto dto = new GameDto();
   	    this.dto = dto;
   	   //遊戲方塊
   	   GameService service = new GameService(dto);
   	   this.gameService = service;
   	   //玩家个性设置
   	   PlayerSet playerSet = new PlayerSet();
   	   this.playerSet = playerSet;
  	    //遊戲窗口
  	    PanelGame panel = new PanelGame(this,dto,playerSet);
		this.panelGame = panel;
        DataA = new DataBase();
        DataB = new DataDisk();
        //设置数据
        this.dto.setDbRecode(DataA.loadDate());
        this.dto.setDiskRecode(DataB.loadDate());
        //创建游戏窗口，安装游戏面板
        new FrameGame(this.panelGame);
        this.jframeSavaPoint = new JFrameSavePoint(this);
        }
	
	/*
	 * 控制上下左右
	 */
	
	public void keyUp() {
		//游戏结束判断
		if(this.gameService.checklose()){
			return;
		}
		//暂停判断
		if(this.dto.isPause()){
			return;
		}
		this.gameService.keyUp();
		this.panelGame.repaint();
	}
	public void keyDown() {
		//游戏结束判断
		if(this.gameService.checklose()){
			return;
		}
		//暂停判断
		if(this.dto.isPause()){
			return;
		}
		this.gameService.keyDown();
		this.panelGame.repaint();
	}
	public void keyLeft() {
		//暂停判断
		if(this.dto.isPause())
			return;
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}
	public void keyRight() {
		//暂停判断
		if(this.dto.isPause())
			return;
		this.gameService.keyRight();
		this.panelGame.repaint();
	}
	//作弊按鍵
	public void keyZ(){
		this.dto.setIscheat(true);
		this.gameService.keyZ();
		this.panelGame.repaint();
	}
//迅速下落
	public void keyX() {
		//游戏结束判断
		if(this.gameService.checklose()){
			return;
		}
		//暂停判断
		if(this.dto.isPause()){
			return;
		}
		this.gameService.keyX();
		this.panelGame.repaint();
	}
	//暫停
	public void keySPACE() {
		this.gameService.keySPACE();
	}
	//開始
	public void keyENTER() {
		this.start();
	}
	//开始按钮逻辑
	public void start() {
		//按钮不可点击
		this.panelGame.buttonSwitch(false);
		this.playerSet.setVisible(false);
		this.jframeSavaPoint.setVisible(false);
		//游戏数据初始化
		this.gameService.startMain();
		this.gameThread = new MainThread();
		//启动线程
	   this.gameThread.start();
	   this.panelGame.repaint();
	   
	}
	
	/*
	 * 线程内部类
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
	 * 失败后的操作
	 */
	private void lose(){
		this.panelGame.buttonSwitch(true);
		if(!this.dto.isIscheat()){
			this.jframeSavaPoint.show(this.dto.getNowpoint());
		}
	}
/*
 * 保存分数方法
 */
	public void savePoint(String name) {
		//将游戏数据保存
		Player p = new Player(name,this.dto.getNowpoint());
		this.DataA.saveData(p);
		this.DataB.saveData(p);
		this.dto.setDbRecode(DataA.loadDate());
	    this.dto.setDiskRecode(DataB.loadDate());
	    //刷新画面
	    this.panelGame.repaint();
	}

	public void menu() {
		this.playerSet.playerSet();
	    this.panelGame.repaint();	
	}
	
}
