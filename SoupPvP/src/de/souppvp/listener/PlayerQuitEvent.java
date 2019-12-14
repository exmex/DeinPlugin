package de.souppvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import de.souppvp.data.Data;
import de.souppvp.onevsonemanager.OneVSOneWarteschlange;
import de.souppvp.statssystem.StatsSystem;

public class PlayerQuitEvent implements Listener{
	
	@EventHandler
	public void onQuit(org.bukkit.event.player.PlayerQuitEvent e){
		e.setQuitMessage(null);
		Player p = e.getPlayer();
		StatsSystem.loadStatsFromHashMapIntoConfig(p);
		PlayerJoinListener.getLobbyItems(p);
			Data.FeastJoin.remove(p);
			Data.firstJoin.remove(p);
			Data.OneVSOneJoin.remove(p);
			Data.INOneVSOneJoin.remove(p);
			Data.FeastNoKit.remove(p);
			Data.OneVSOneWarteschlange.remove(p);
			OneVSOneWarteschlange.warteschlange.remove(p);
	}
}
