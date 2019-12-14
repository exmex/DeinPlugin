package de.leitung.scoreboardstats.classes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class StatsListener implements Listener{
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		
		StatsManager.addDeath(p);
		StatsScoreboard.setScoreboard(p);
		if(k != null){
			StatsManager.addKill(k);
			StatsScoreboard.setScoreboard(k);
		}
		
	}

}
