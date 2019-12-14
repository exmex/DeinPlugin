package de.leitung.lobby.classes;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Schutzschild implements Listener{
	
ArrayList<String> hideShow = new ArrayList<String>();
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		for(Player players : Bukkit.getOnlinePlayers()){
			if(hideShow.contains(players.getName())){
				players.hidePlayer(p);
			}
		}
	}
	
	@EventHandler
	public void OnInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		try{
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getItem().getType() == Material.TNT){
			if(hideShow.contains(p.getName())){
				hideShow.remove(p.getName());
				for(Player players : Bukkit.getOnlinePlayers()){
					p.showPlayer(players);
				}
				p.sendMessage("§7Du hast die §eSilent-Lobby §cverlassen§7!");
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 1, 1);

			} else {
				hideShow.add(p.getName());
				for(Player players : Bukkit.getOnlinePlayers()){
					p.hidePlayer(players);
				}
				p.sendMessage("§7Du hast die §eSilent-Lobby§2 betreten§7!");
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 1, 1);
			}
		
	}
		}
	}catch(Exception e1){}
}
}
	