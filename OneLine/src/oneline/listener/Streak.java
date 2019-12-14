package oneline.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import oneline.data.Data;

public class Streak implements Listener{
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		e.getEntity().setLevel(0);
		if(e.getEntity().getKiller() != null){
			e.getEntity().getKiller().setLevel(e.getEntity().getKiller().getLevel() +1);		
		
		Player p = e.getEntity().getKiller();
		if(p.getLevel() == 5){
			Bukkit.broadcastMessage(Data.Prefix + "§6" + p.getName() + "§e hat eine Killstreak von §a" + p.getLevel() + "§9 Kills!");
		}
		if(p.getLevel() == 10){
			Bukkit.broadcastMessage(Data.Prefix + "§6" + p.getName() + "§e hat eine Killstreak von §a" + p.getLevel() + "§9 Kills!");
		}
		if(p.getLevel() == 15){
			Bukkit.broadcastMessage(Data.Prefix + "§6" + p.getName() + "§e hat eine Killstreak von §a" + p.getLevel() + "§9 Kills!");
		}
		if(p.getLevel() == 20){
			Bukkit.broadcastMessage(Data.Prefix + "§6" + p.getName() + "§e hat eine Killstreak von §a" + p.getLevel() + "§9 Kills!");
		}
		if(p.getLevel() == 25){
			Bukkit.broadcastMessage(Data.Prefix + "§6" + p.getName() + "§e hat eine Killstreak von §a" + p.getLevel() + "§9 Kills!");
		}
		}
		
		
	}

}
