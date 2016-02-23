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
		this.setTitle("����ӛ�");
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
	 * ���÷�������
	 */
	public void show (int point){
		this.Label.setText("���ķ����ǣ�" + point);
		this.setVisible(true);
	}
	private void createAction() {

		this.JBok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = Name.getText();
				if(name.length()>16||name.length() == 0||" ".equals(name)){
					errMsg.setText("������16λ���ڵ�����");
				}else{
					setVisible(false);
					gameControl.savePoint(name);
				}
			}
			
		});
	}

	private void button(){
		//�����PANEL
		JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.Label = new JLabel();
		north.add(Label);
		this.errMsg = new JLabel();
		this.errMsg.setForeground(Color.RED);
		north.add(errMsg);
		this.add(north,BorderLayout.NORTH);
		//�м��PANEL
		JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.name = new JLabel("����������������");
		this.Name = new TextField(10);
		center.add(name);
		center.add(this.Name);
		this.add(center, BorderLayout.CENTER);
		//�����PANEL
		JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//����ȷ����ť
		this.JBok = new JButton("ȷ��");
		south.add(JBok);
		//���JPanel��JFrame
		this.add(south,BorderLayout.SOUTH);
	}
}
