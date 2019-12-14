package de.ttt.game;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

import de.ttt.gamestates.GameState;
import de.ttt.main.Main;
import de.ttt.manager.Inventorys;
import de.ttt.manager.Scoreboard;
import de.ttt.stats.StatsManager;
import de.ttt.utils.Data;

public class JoinManager implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		StatsManager.loadStatsFormPlayer(p);
		if(Main.gs == GameState.LOBBY){
			e.setJoinMessage(Data.prefix + "§eDer Spieler §6" + p.getName() + "§e ist der Runde beigetreten!");
		}else{
			e.setJoinMessage(null);
		}
		Scoreboard.setScoreboard(p);
		Inventorys.getLobbyItems(p);
	}

}
