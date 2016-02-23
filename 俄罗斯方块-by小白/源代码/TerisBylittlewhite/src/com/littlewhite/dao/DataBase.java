package com.littlewhite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.littlewhite.dto.Player;

public class DataBase implements Data{
	private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String DB_URI="jdbc:sqlserver://127.0.0.1:1433;database=gametest";
	private static String DB_USER="gm";
	private static String DB_PWD="gm123";
	private static String LOAD_SQL = " SELECT TOP 5 user_name,point FROM user_point WHERE type_id = 1 ORDER BY point DESC";
	private static String SAVE_SQL = "INSERT INTO user_point (user_name,point,type_id) VALUES (?,?,?)";
	
	static {try {
		Class.forName(DRIVER);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}}

	@Override
	public List<Player> loadDate() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs =null;
		List<Player> players = new ArrayList<Player>();
		try {
			conn = DriverManager.getConnection(DB_URI,DB_USER,DB_PWD);
			stmt = conn.prepareStatement(LOAD_SQL);
			rs = stmt.executeQuery();
			while(rs.next()){
				players.add(new Player(rs.getString(1),rs.getInt(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
				try {
					if(conn!=null)
						conn.close();
					if(stmt!=null)
						stmt.close();
					if(rs!=null)
						rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return players;
	}
	@Override
	public void saveData(Player players) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
		    conn = DriverManager.getConnection(DB_URI,DB_USER,DB_PWD);
			stmt = conn.prepareStatement(SAVE_SQL);
			stmt.setObject(1, players.getName());
			stmt.setObject(2, players.getPoint());
			stmt.setObject(3, 1);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null)
					conn.close();
				if(stmt!=null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}}
	}
}
