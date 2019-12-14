package de.skywars.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.skywars.gamestates.GameState;
import de.skywars.methods.SpawnManager;
import de.skywars.utils.Data;

public class TeleportListener implements Listener{
	static int tpi;
	static int cd;
	public TeleportListener(de.skywars.main.Main Main){
		this.pl = Main;
	}
	private static de.skywars.main.Main pl;
	public static ArrayList<Player> players = new ArrayList<Player>();
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(Main.gs == GameState.LOBBY){
		players.add(p);
	}
	}

}
