package souppvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import net.minecraft.server.v1_8_R3.Scoreboard;
import souppvp.data.Data;
import souppvp.manager.SpawnManager;
import souppvp.manager.StatsManager;
import souppvp.methods.Inventory;

public class JoinListener implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		Data.amspawn.add(p);
		e.setJoinMessage("");
		Inventory.setLobbyItems(p);
		p.teleport(Data.spawn);
		StatsManager.loadStatsFormConfigIntoHashMap(p);
		p.setFoodLevel(20);
		p.setHealth(20);
		for(Player all : Bukkit.getOnlinePlayers()){
			souppvp.methods.Scoreboard.setScoreboard(all);
		}
	}

}
