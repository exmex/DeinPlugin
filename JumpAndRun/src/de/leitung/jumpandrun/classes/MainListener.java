package de.leitung.jumpandrun.classes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MainListener implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage(Main.Prefix + "§9Der Spieler §e" + p.getName() + "§9 hat den Server betreten!");
		Methode.setStartItem(p);
		p.teleport(SpawnManager.getConfigLoc("Lobby", SpawnManager.cfg));
	}
	@EventHandler
	public void onQ(PlayerQuitEvent e){
		e.setQuitMessage(null);
	}
}
