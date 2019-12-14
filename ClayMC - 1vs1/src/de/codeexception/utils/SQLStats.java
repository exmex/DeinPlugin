package de.codeexception.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class SQLStats {

	public static String gamename = "1vs1";
	
	public static boolean playerEx(String uuid) {
		ResultSet rs = MySQL.query("SELECT * FROM "+ gamename +" WHERE UUID= '" + uuid + "'");
		try {
			if (rs.next()) {
				return rs.getString("UUID") != null;
			}
		} catch (SQLException e) {
			
		}
		return false;
	}
	public static void createPlayer(String uuid) {
		if(!playerEx(uuid)) {
			MySQL.update("INSERT INTO "+gamename+"(UUID, Kills, Deaths) VALUES ('" + uuid + "', '0', '0');");
		}
	}
	public static Integer getKills(String uuid) {
		Integer i = Integer.valueOf(0);
		try {
			ResultSet rs = MySQL.query("SELECT * FROM "+gamename+" WHERE UUID= '" + uuid + "'");
			if ((rs.next()) && (Integer.valueOf(rs.getInt("Kills")) == null));
			i = Integer.valueOf(rs.getInt("Kills"));
		} catch (SQLException e) {
			System.err.println(e);
		}
		return i;
	}
	public static Integer getDeaths(String uuid) {
		Integer i = Integer.valueOf(0);
		try {
			ResultSet rs = MySQL.query("SELECT * FROM "+gamename+" WHERE UUID= '" + uuid + "'");
			if ((rs.next()) && (Integer.valueOf(rs.getInt("Deaths")) == null));
			i = Integer.valueOf(rs.getInt("Deaths"));
		} catch (SQLException e) {
			System.err.println(e);
		}
		return i;
	}
	public static void setKills(String uuid, Integer kills) {
		MySQL.update("UPDATE "+gamename+" SET Kills= '" + kills + "' WHERE UUID= '" + uuid + "';");
	}
	public static void setDeaths(String uuid, Integer deaths) {
		MySQL.update("UPDATE "+gamename+" SET Deaths= '" + deaths + "' WHERE UUID= '" + uuid + "';");
	}
	public static void addKills(String uuid, Integer kills) {
		setKills(uuid, getKills(uuid)+kills);
	}
	public static void adddeaths(String uuid, Integer deaths) {
		setDeaths(uuid, getDeaths(uuid)+deaths);
	}
	public static void removeKills(String uuid, Integer kills) {
		setKills(uuid, getKills(uuid)-kills);
	}
	public static void removedeaths(String uuid, Integer deaths) {
		setDeaths(uuid, getDeaths(uuid)-deaths);
	}
	public static ArrayList<String> getTopPlayers() {
		ArrayList<String> top = new ArrayList<String>();
		ResultSet rs = MySQL.query("SELECT * FROM " + gamename + " ORDER BY Kills desc LIMIT 10");
		try {
			while (rs.next() && rs.getString("UUID") != null) {
				top.add(rs.getString("UUID"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return top;
	}
	public static void setup() {
		MySQL.update("CREATE TABLE IF NOT EXISTS "+gamename+"(UUID varchar(64), Kills int, Deaths int);");
	}
}
