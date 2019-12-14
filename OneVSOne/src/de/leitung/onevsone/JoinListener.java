package de.leitung.onevsone;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener{
public static int startcd = 11;	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
	if(Bukkit.getOnlinePlayers().size() == 1){
		p.sendMessage(Main.Prefix + "§cWarte auf einen weiteren Spieler...");
	}else if(Bukkit.getOnlinePlayers().size() == 2){
		
      
		
	}
	
	}
}
