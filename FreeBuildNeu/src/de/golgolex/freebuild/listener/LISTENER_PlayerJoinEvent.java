package de.golgolex.freebuild.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.connorlinfoot.titleapi.TitleAPI;

import de.golgolex.freebuild.methods.Data;
import de.golgolex.freebuild.methods.FreebuildAPI;
import de.golgolex.freebuild.methods.Stats;

public class LISTENER_PlayerJoinEvent implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage(Data.pr + "§7Der Spieler §2" + p.getName() + " §7ist dem Server beigetreten");
		
		TitleAPI.sendFullTitle(p, 20, 40, 20, "§2Freebuild", "§aTeaming ist erlaubt");
		
		Data.deathcount.put(p, null);
		
		Stats.loadStatsFromConfigIntoHashMap(p);
		
		
		for(Player all : Bukkit.getOnlinePlayers()){
			
		}
		
		if(!p.hasPlayedBefore()){
			if(Data.Spawn == null){
				FreebuildAPI.getHub(p);
				Location loc = FreebuildAPI.getHub(p);
				Data.Spawn.put("Spawn", loc);
				FreebuildAPI.setFirstJoin(p);
			}else{
				p.teleport(Data.Spawn.get("Spawn"));
				FreebuildAPI.setFirstJoin(p);
			}
		}else{
			 p.sendMessage("");
	         p.sendMessage(Data.pr + "§7 Um an den Spawn zu gelangen gebe folgendes ein:");
	         p.sendMessage(Data.pr + "§7- §a/Spawn");
	         p.sendMessage("");
		}
	}

}
