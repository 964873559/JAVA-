package com.littlewhite.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.littlewhite.control.GameControl;

@SuppressWarnings("serial")
public class JFrameSavePoint extends JFrame{
	private JButton JBok = null;
	private JLabel Label = null;
	private JLabel errMsg = null;
	private JLabel name= null;
	private TextField Name = null;
	private int screenWidth;
	private int screenHeight;
	
	private  GameControl gameControl = null;

	public JFrameSavePoint(GameControl gameControl){
		this.gameControl = gameControl;
		this.setTitle("保存記錄");
		Toolkit kit = Toolkit.getDefaultToolkit();
    	Dimension screenSize = kit.getScreenSize();
    	screenWidth = screenSize.width;
    	screenHeight = screenSize.height;
    	this.setSize(256,128);
    	this.setLocation(screenWidth*40/100, screenHeight*44/100);
		this.setLayout(new BorderLayout());
		this.button();
		this.createAction();
		this.setResizable(false);
	}
	/*
	 * 设置分数方法
	 */
	public void show (int point){
		this.Label.setText("您的分数是：" + point);
		this.setVisible(true);
	}
	private void createAction() {

		this.JBok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = Name.getText();
				if(name.length()>16||name.length() == 0||" ".equals(name)){
					errMsg.setText("请输入16位以内的名字");
				}else{
					setVisible(false);
					gameControl.savePoint(name);
				}
			}
			
		});
	}

	private void button(){
		//上面的PANEL
		JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.Label = new JLabel();
		north.add(Label);
		this.errMsg = new JLabel();
		this.errMsg.setForeground(Color.RED);
		north.add(errMsg);
		this.add(north,BorderLayout.NORTH);
		//中间的PANEL
		JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.name = new JLabel("请输入您的姓名：");
		this.Name = new TextField(10);
		center.add(name);
		center.add(this.Name);
		this.add(center, BorderLayout.CENTER);
		//下面的PANEL
		JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//创建确定按钮
		this.JBok = new JButton("确定");
		south.add(JBok);
		//添加JPanel到JFrame
		this.add(south,BorderLayout.SOUTH);
	}
}
