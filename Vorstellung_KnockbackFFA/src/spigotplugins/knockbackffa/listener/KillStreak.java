package spigotplugins.knockbackffa.listener;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import spigotplugins.knockbackffa.storage.Data;

public class KillStreak implements Listener{
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		p.setLevel(0);
		e.setDroppedExp(0);
		if(k != null){
			k.setLevel(k.getLevel() + 1);
		if(k.getLevel() == 3){
			Bukkit.broadcastMessage(new Data().Prefix + "§3" + k.getName() + "§e hat eine Killstreak von §6" + k.getLevel() + "§e Kills!");
			for(Player all : Bukkit.getOnlinePlayers()){
				all.playSound(all.getLocation(), Sound.ENDERMAN_IDLE, 10, 10);
			}
		}
		if(k.getLevel() == 5){
			Bukkit.broadcastMessage(new Data().Prefix + "§3" + k.getName() + "§e hat eine Killstreak von §6" + k.getLevel() + "§e Kills!");
			for(Player all : Bukkit.getOnlinePlayers()){
				all.playSound(all.getLocation(), Sound.ENDERMAN_IDLE, 10, 10);
			}
		}
		if(k.getLevel() == 10){
			Bukkit.broadcastMessage(new Data().Prefix + "§3" + k.getName() + "§e hat eine Killstreak von §6" + k.getLevel() + "§e Kills!");
			for(Player all : Bukkit.getOnlinePlayers()){
				all.playSound(all.getLocation(), Sound.ENDERMAN_IDLE, 10, 10);
			}
		}
		if(k.getLevel() == 15){
			Bukkit.broadcastMessage(new Data().Prefix + "§3" + k.getName() + "§e hat eine Killstreak von §6" + k.getLevel() + "§e Kills!");
			for(Player all : Bukkit.getOnlinePlayers()){
				all.playSound(all.getLocation(), Sound.ENDERMAN_IDLE, 10, 10);
			}
		}
		if(k.getLevel() == 20){
			Bukkit.broadcastMessage(new Data().Prefix + "§3" + k.getName() + "§e hat eine Killstreak von §6" + k.getLevel() + "§e Kills!");
			for(Player all : Bukkit.getOnlinePlayers()){
				all.playSound(all.getLocation(), Sound.ENDERMAN_IDLE, 10, 10);
			}
		}
	}
	}
}
