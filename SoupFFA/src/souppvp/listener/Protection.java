package souppvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import souppvp.manager.StatsManager;
import souppvp.methods.Scoreboard;

public class Protection implements Listener{
	
	@EventHandler
	public void onF(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void onP(PlayerCommandPreprocessEvent e){
		if(e.getMessage().equalsIgnoreCase("/stop") || e.getMessage().equalsIgnoreCase("/reload") || e.getMessage().equalsIgnoreCase("/rl")){
			for(Player all : Bukkit.getOnlinePlayers()){
				all.kickPlayer("§cDer Server startet neu!");
				StatsManager.loadStatsFromHashMapIntoConfig(all);
				if(e.getMessage().equalsIgnoreCase("/stop")){
					Bukkit.shutdown();
				}else{
					Bukkit.reload();
				}
			}
		}
	}
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE && e.getPlayer().hasPermission("claymc.admin")){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE && e.getPlayer().hasPermission("claymc.admin")){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		if(e.getPlayer().getLocation().getY() < 0){
			e.getPlayer().damage(20.0);
		}
	}
}
