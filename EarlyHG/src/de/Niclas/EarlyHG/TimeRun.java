package de.Niclas.EarlyHG;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeRun extends BukkitRunnable {

	public static int min = 2;
	public static int sec = 59;
	
	@Override
	public void run() {

		if(min == 0 && sec == 1) {
			min = 2;
			sec = 59;
			ChestManager.clear();
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
			}
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(Data.prefix + "§7Es wurden alle §cKisten §7wieder §caufgefüllt§7!");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			for(Entity ent : Bukkit.getWorld(Data.getLocation("spawn").getWorld().getName()).getEntities()) {
				if(ent instanceof Player) {
					
				} else {
					ent.remove();
				}
			}
		} else {
			sec--;
		}
		if(sec == 0) {
			sec = 59;
			min--;
		}
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			if(sec > 9) {
			Listeners.sendActionBar(all, "§7Der nächste §eRefill §7findet in §e0" + min + ":" + sec + "§7 Minuten statt!");
			} else {
				Listeners.sendActionBar(all, "§7Der nächste §eRefill §7findet in §e0" + min + ":0" + sec + "§7 Minuten statt!");
			}
		}
		
	}
	
	

}
