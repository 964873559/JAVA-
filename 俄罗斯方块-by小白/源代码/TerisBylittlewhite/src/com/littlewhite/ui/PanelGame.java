package com.littlewhite.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.littlewhite.control.GameControl;
import com.littlewhite.control.PlayerControl;
import com.littlewhite.dto.GameDto;
import com.littlewhite.service.PlayerSet;

@SuppressWarnings("serial")
public class PanelGame extends JPanel {
	private JButton start;
	private JButton menu;
	private static ImageIcon START = new ImageIcon("Graphics/string/start.png");
	private static ImageIcon MENU = new ImageIcon("Graphics/string/menu.png");
	
	private PlayerSet playerSet;
	public GameControl gameControl;
	
	// 数据过多的重复使用时创建数组
	public Lay[] lay = new Lay[] { new LayDateBase(40, 32, 334, 279),
			new LayDisk(40, 343, 334, 279), new LayGame(414, 32, 334, 590),
			new LayButton(788, 32, 334, 110), new LayNext(788, 182, 192, 128),
			new LayLevel(1010, 182, 112, 128), new LayPoint(788, 342, 334, 160) ,
	new LayAbout(788,522,334,100)};

	public PanelGame(GameControl gameControl,GameDto dto, PlayerSet playerSet) {
		this.gameControl = gameControl;
		this.playerSet = playerSet;
		this.setLayout(null);
		this.addButton();
		//控制器的加入
		this.addKeyListener(new PlayerControl(gameControl));
		for (int a = 0; a < 8; a++) {
			lay[a].setDto(dto);
		}
	}
	
	//初始化按钮
	private void addButton(){
		this.start = new JButton(START);
		start.setBounds(830,58, 110, 60);
		this.start.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 gameControl.start();
			 }
		});
		this.add(start);
		this.menu = new JButton(MENU);
		menu.setBounds(975,58,110,60);
		this.menu.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 gameControl.menu();
			 }
		});
		this.add(menu);
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 背景图片
		Image img1 = new ImageIcon("Graphics/background/bg0"+this.playerSet.bg+".jpg").getImage();
		g.drawImage(img1, 0, 0, 1162, 670, null);
		// 画边框
		for (int i = 0; i < lay.length; i++) {
			lay[i].paint(g);
		}
		this.requestFocus();
	}

	/*
	 * 按鈕可點
	 */
	public void  buttonSwitch(boolean onOff){
		this.start.setEnabled(onOff);
		this.menu.setEnabled(onOff);
	}
}
