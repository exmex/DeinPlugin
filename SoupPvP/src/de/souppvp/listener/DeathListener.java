package de.souppvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.Score;

import de.souppvp.data.Scoreboard;
import de.souppvp.levelsystem.LevelData;
import de.souppvp.statssystem.StatsSystem;
import io.netty.util.ResourceLeakDetector.Level;

public class DeathListener implements Listener{
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		StatsSystem.addDeath(p);
		Scoreboard.setScoreboard(p);
		if(k != null){
		LevelData.getLevel(k);
		StatsSystem.addKill(k);
		Scoreboard.setScoreboard(k);
		}
		e.setDeathMessage(null);

	}

}
