package de.builderhub.spigotplugins.main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Join implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		e.setJoinMessage(Main.Prefix + "§eDer Spieler §6" + e.getPlayer().getName() + "§e hat den Server betreten!");
		e.getPlayer().setGameMode(GameMode.ADVENTURE);
		e.getPlayer().setHealth(20);
		e.getPlayer().setFoodLevel(20);
		for(Player all : Bukkit.getOnlinePlayers()){
			Scoreboard.setScoreboard(all);
		}
	}
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		e.setQuitMessage(null);
	}
	@EventHandler
	public void onFood(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
}
