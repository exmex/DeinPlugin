package de.anweisung.classes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Chat implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(PermissionsEx.getUser(p).inGroup("default")){
			e.setFormat("§7" + p.getName() + "§7 > §8" + e.getMessage());
		}
		if(PermissionsEx.getUser(p).inGroup("Owner")){
			e.setFormat("§4" + p.getName() + " > §6" + e.getMessage());
		}
		if(PermissionsEx.getUser(p).inGroup("Premium")){
			e.setFormat("§5" + p.getName() + " > §e" + e.getMessage());
		}
		
	}

}
