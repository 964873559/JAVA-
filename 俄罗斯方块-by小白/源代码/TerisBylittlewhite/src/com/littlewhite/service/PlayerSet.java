package com.littlewhite.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.littlewhite.ui.Lay;

@SuppressWarnings("serial")
public class PlayerSet extends JFrame{
	
	private JLabel errMsg = null;
	private JButton JBbackground = null;
	private JButton JBbiankuang = null;
	public int bg = 0;
	public int bk = 0;
	
	public void playerSet(){
		this.setTitle("个性设置");
		this.setSize(195,90);
		this.setLocation(0, 0);
		this.setLayout(new BorderLayout());
		this.button();
		this.createAction();
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(1);
	}
	private void createAction() {

		this.JBbackground.addActionListener(new ActionListener(){


			@Override
			public void actionPerformed(ActionEvent e) {
				bg++;
				if(bg>=10)
					bg = bg%10;
				errMsg.setText("点击菜单保存");
			}
		});
		this.JBbiankuang.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				bk++;
				if(bk>=10)
					bk = bk%10;
				Lay.set("Graphics/window/Window0"+bk+".png");
				errMsg.setText("点击菜单保存");
			}
		});
	}

	private void button(){
		//添加PANEL
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//创建按钮
		this.JBbackground = new JButton("切换背景");
		this.errMsg = new JLabel();
		this.errMsg.setForeground(Color.RED);
		north.add(errMsg);
		this.JBbiankuang = new JButton("显示边框");
		panel.add(JBbackground);
		panel.add(JBbiankuang);
		//添加JPanel到JFrame
		this.add(north,BorderLayout.SOUTH);
		this.add(panel,BorderLayout.WEST);
		this.add(panel,BorderLayout.EAST);
	}
	
	
	public PlayerSet(){
	}
}
