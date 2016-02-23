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
		this.setTitle("��������");
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
				errMsg.setText("����˵�����");
			}
		});
		this.JBbiankuang.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				bk++;
				if(bk>=10)
					bk = bk%10;
				Lay.set("Graphics/window/Window0"+bk+".png");
				errMsg.setText("����˵�����");
			}
		});
	}

	private void button(){
		//���PANEL
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//������ť
		this.JBbackground = new JButton("�л�����");
		this.errMsg = new JLabel();
		this.errMsg.setForeground(Color.RED);
		north.add(errMsg);
		this.JBbiankuang = new JButton("��ʾ�߿�");
		panel.add(JBbackground);
		panel.add(JBbiankuang);
		//���JPanel��JFrame
		this.add(north,BorderLayout.SOUTH);
		this.add(panel,BorderLayout.WEST);
		this.add(panel,BorderLayout.EAST);
	}
	
	
	public PlayerSet(){
	}
}
