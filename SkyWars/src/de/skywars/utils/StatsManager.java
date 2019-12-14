package de.skywars.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.skywars.main.MySQL;
import de.tiger.NickSystem.manager.NameUtils;

public class StatsManager implements Listener{
	 
 private static HashMap<Player, Integer> loadkills = new HashMap<>();
 private static HashMap<Player, Integer> loadTode = new HashMap<>();
	
	
    public static boolean playerExists(String Name) {

        ResultSet rs = MySQL.getResult("SELECT * FROM SkyWarsStats WHERE Name = '" + Name + "' ");
        try {
            if(rs.next()) {
                return rs.getString("Name") != null;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void createPlayer(String Name) {
        if(!(playerExists(Name))) {
            MySQL.update("INSERT INTO SkyWarsStats (Name , Kills , Tode) VALUES ('" + Name  + "' , ' 0' , '0');");
        }
    }


    public static int getKills(String Name) {
        int i = 0;
        if(playerExists(Name)) {
            ResultSet rs = MySQL.getResult("SELECT * FROM SkyWarsStats WHERE Name = '" + Name + "';");
            try {
                 if((!rs.next()) || (Integer.valueOf(rs.getInt("Kills")) == null));
                i = rs.getInt("Kills");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            createPlayer(Name);
            getKills(Name);
        }
        return i;
    }

    public static int getTode(String Name) {
        int i = 0;
        if(playerExists(Name)) {
            ResultSet rs = MySQL.getResult("SELECT * FROM SkyWarsStats WHERE Name = '" + Name + "';");
            try {
                if((!rs.next()) || (Integer.valueOf(rs.getInt("Tode")) == null));
                i = rs.getInt("Tode");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            createPlayer(Name);
            getTode(Name);
        }
        return i;
    }


    public static void setKills(String Name , int Kills) {
        if(playerExists(Name)) {

            MySQL.update("UPDATE SkyWarsStats SET Kills = '" + Kills + "' WHERE Name = '" + Name + "';");

        }else {
            createPlayer(Name);
            setKills(Name , Kills);
        }
    }

    public static void setTode(String Name , int Tode) {
        if(playerExists(Name)) {

            MySQL.update("UPDATE SkyWarsStats SET Tode = '" + Tode + "' WHERE Name = '" + Name + "';");

        }else {
            createPlayer(Name);
            setTode(Name , Tode);
        }
    }
	

	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		loadStatsIntoHasHMap(p);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();
		InsertStatsIntoMySQL(p);
	}
	
	
	
	public static void InsertStatsIntoMySQL(final Player p) {
		try {
			setKills(NameUtils.getRealName(p), loadkills.get(p));
			setTode(NameUtils.getRealName(p), loadTode.get(p));
		}catch (Exception e) {
			System.out.println("Es gab Fehler beim Speichern der Stats vom Spieler » " + NameUtils.getRealName(p));
		}
		System.out.println("Die Stats vom Spieler » " + p.getName() + " wurden erfolgreich gespeichert!");
	}
	
	public static void loadStatsIntoHasHMap(final Player p) {
		try {
			
			loadkills.put(p, getKills(NameUtils.getRealName(p)));
			loadTode.put(p, getTode(NameUtils.getRealName(p)));
			
			
		}catch (Exception e1) {
			
			
			p.kickPlayer("§bStatsSystem §8» §7Es gab feher bitte Reloggen!");
			
		}
	}
	
	public static void addCurrentKills(final Player p , int kills) {
		loadkills.put(p, loadkills.get(p) + kills);
	}
	
	public static void addCurrentTode(final Player p , int Tode) {
		loadTode.put(p, loadTode.get(p)  + Tode);
	}
	
	
	public static void removeCurrentKills(final Player p , int kills) {
		loadkills.put(p, loadkills.get(p) + kills);
	}
	
	public static void removeCurrentTode(final Player p , int Tode) {
		loadTode.put(p, loadTode.get(p)  + Tode);
	}
	
	
    public static int getCurrentKills(final Player p) {
	    int i = 0;

	    if(loadkills.get(p) == null) {
	        i = 0;
        }else {
	        i = loadkills.get(p);
        }
	    return i;

    }

    public static int getCurrentTode(final Player p) {
	    int i = 0;

	    if(loadTode.get(p) == null) {
	        i = 0;
        }else {
	        i = loadTode.get(p);
        }
	    return  i;
    }
	
	
	
	

}