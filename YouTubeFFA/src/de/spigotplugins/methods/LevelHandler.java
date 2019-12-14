package de.spigotplugins.methods;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.spigotplugins.ffa.data.Data;

public class LevelHandler implements Listener{
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		e.setDroppedExp(0);
		
		Player k = e.getEntity().getKiller();
		if(k != null){
			k.setLevel(k.getLevel() +1);
			if(k.getLevel() == 5){
				Bukkit.broadcastMessage(Data.Prefix + "§3Der Spieler §e" + k.getName() + "§e hat eine Killstreak von §6"+ k.getLevel() + " §eerreicht!");
			}
			if(k.getLevel() == 10){
				Bukkit.broadcastMessage(Data.Prefix + "§3Der Spieler §e" + k.getName() + "§e hat eine Killstreak von §6"+ k.getLevel() + " §eerreicht!");
			}
			if(k.getLevel() == 20){
				Bukkit.broadcastMessage(Data.Prefix + "§3Der Spieler §e" + k.getName() + "§e hat eine Killstreak von §6"+ k.getLevel() + " §eerreicht!");
			}
			if(k.getLevel() == 30){
				Bukkit.broadcastMessage(Data.Prefix + "§3Der Spieler §e" + k.getName() + "§e hat eine Killstreak von §6"+ k.getLevel() + " §eerreicht!");
			}
			if(k.getLevel() == 40){
				Bukkit.broadcastMessage(Data.Prefix + "§3Der Spieler §e" + k.getName() + "§e hat eine Killstreak von §6"+ k.getLevel() + " §eerreicht!");
			}
			if(k.getLevel() == 50){
				Bukkit.broadcastMessage(Data.Prefix + "§3Der Spieler §e" + k.getName() + "§e hat eine Killstreak von §6"+ k.getLevel() + " §eerreicht!");
			}
		}
	}

}
