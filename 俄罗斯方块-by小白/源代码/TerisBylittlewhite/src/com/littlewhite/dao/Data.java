package com.littlewhite.dao;

import java.util.List;

import com.littlewhite.dto.Player;

public interface Data {
	/*
	 * �������
	 */
   public List<Player> loadDate();
	
   /*
    * ��������
    */
   public void saveData(Player players);
}
