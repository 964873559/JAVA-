package com.littlewhite.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.littlewhite.dto.Player;

public class DataDisk implements Data{
	/*
	 * 读取本地数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Player> loadDate() {
		ObjectInputStream ois = null;
		List<Player> players = null;
		try {
		 ois = new ObjectInputStream(new FileInputStream("save/disk.bat"));
		 players = (List<Player>)ois.readObject();
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return players;
	}
	/*
	 * 存储本地数据
	 */
	public void saveData(Player pla) {
		//取出数据
		List<Player> players = this.loadDate();
		//添加数据
		players.add(pla);
		//重新写入
		ObjectOutputStream oos = null;
		try{
			oos = new ObjectOutputStream(new FileOutputStream("save/disk.bat"));
			oos.writeObject(players);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
