package de.spigotplugins.freebuild.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.spigotplugins.freebuild.data.Data;

public class JoinListener implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		e.setJoinMessage(Data.Prefix + "§eDer Spieler §6" + e.getPlayer().getName() + "§e hat den Server betreten!");
		Player p = e.getPlayer();
		if(!p.hasPlayedBefore()){
			p.teleport(Bukkit.getWorld(p.getWorld().getName()).getSpawnLocation());
		} 
	}

}
