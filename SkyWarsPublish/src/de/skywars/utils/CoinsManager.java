package de.skywars.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.jar.Attributes.Name;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


import de.skywars.main.MySQL;

public class CoinsManager implements Listener{
	
	private static HashMap<Player, Integer> loadCoins = new HashMap<>();
	
	public static boolean playerExists(String Name) {
		ResultSet rs = MySQL.getResult("SELECT * FROM SkyCoins WHERE Name = '" + Name + "';");
		
		try {
			if(rs.next()) {
				return rs.getString("Name") != null;
			}
			return false;
		} catch (SQLException e) {}
		return false;
	}
	
	
	public static void createPlayer(String Name ) {
		if(!(playerExists(Name))) {
			MySQL.update("INSERT INTO SkyCoins (Name, Coins) VALUES ('" + Name + "' , '0');");
		}
	}
	
	
	public static int getCoins(String Name) {
		
		int i = 0;
		
		if(playerExists(Name)) {
			ResultSet rs = MySQL.getResult("SELECT * FROM SkyCoins WHERE Name = '" + Name + "';");
            try {
				if((!rs.next()) || (Integer.valueOf(rs.getInt("Coins")) == null));
				 i = rs.getInt("Coins");
			} catch (SQLException e) {}
           
		}else {
			createPlayer(Name);
			getCoins(Name);
		}
		return i;
	}
	
	public static void setCoins(String Name , int Coins) {
		if(playerExists(Name)) {
			MySQL.update("UPDATE SkyCoins SET Coins = '" + Coins + "' WHERE Name = '" + Name + "';");
		}else {
			createPlayer(Name);
			setCoins(Name, Coins);
		}
	}
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		InsertCoinsIntoHash(p);
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		loadHashCoinsIntoSQL(p);
	}
	
	//NUR MIT DIESER METHODE COINS ADDEN
	public static void addCurrentCoins(final Player p , int coins) {
		loadCoins.put(p, loadCoins.get(p) + coins);	
	}
	//NUR MIT DIESER METHODE COINS REMOVEN
	public static void removeCurrentCoins(final Player p , int coins) {
		loadCoins.put(p, loadCoins.get(p) - coins);
	}
	
	public static void InsertCoinsIntoHash(final Player p) {
		try {
			loadCoins.put(p, getCoins(p.getName()));
		}catch (Exception e1) {}	
	}
	
	public static void loadHashCoinsIntoSQL(final Player p) {
		try {
			setCoins(p.getName(), loadCoins.get(p));			
		}catch (Exception e1) {}
	}

	//NUR MIT DIESER METHODE COINS GTTEN
	public static int getCurrentCoins(final Player p) {
		int i = 0;
		
		if(loadCoins.get(p) == null) {
			i = 0;
		}else {
			i = loadCoins.get(p);
		}
		return i;
	}
	
	

}
