package com.littlewhite.dao;

import java.util.List;

import com.littlewhite.dto.Player;

public interface Data {
	/*
	 * 获得数据
	 */
   public List<Player> loadDate();
	
   /*
    * 储存数据
    */
   public void saveData(Player players);
}
