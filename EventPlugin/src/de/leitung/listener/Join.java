package de.leitung.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.leitung.data.Data;
import de.leitung.utils.Utils;

public class Join implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("claymc.event")){
			e.setJoinMessage(Data.Prefix + "§6Der Spieler §e" + p.getName() + "§6 hat das Event betreten! §8» §3" + Bukkit.getOnlinePlayers().size());
			return;
		}
		e.setJoinMessage(Data.Prefix + "§6Der Spieler §e" + p.getName() + "§6 hat das Event betreten! §8» §3" + Bukkit.getOnlinePlayers().size());
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		
		Utils.playerlist.add(p);
		
		
	}

}
