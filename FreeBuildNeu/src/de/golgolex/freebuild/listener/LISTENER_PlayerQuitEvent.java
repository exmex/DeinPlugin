package de.golgolex.freebuild.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.golgolex.freebuild.methods.Data;
import de.golgolex.freebuild.methods.Stats;

public class LISTENER_PlayerQuitEvent implements Listener{
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		
		e.setQuitMessage(Data.pr + "§7Der Spieler §2" + p.getName() + " §7hat den Server verlassen");
		
		Stats.loadStatsFromHashMapIntoConfig(p);
		
		
	}

}
