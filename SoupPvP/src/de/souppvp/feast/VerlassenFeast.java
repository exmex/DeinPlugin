package de.souppvp.feast;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.souppvp.data.Data;
import de.souppvp.listener.PlayerJoinListener;
import de.souppvp.spawnmanager.SpawnManager;

public class VerlassenFeast implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		try{
		if(e.getItem().getType() == Material.BARRIER){
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				if(Data.FeastNoKit.contains(p)){
					PlayerJoinListener.getLobbyItems(p);
					Data.FeastJoin.remove(p);
					Data.FeastNoKit.remove(p);
					Data.firstJoin.add(p);
					SpawnManager.teleportToSpawn(p, "Spawn");
					p.playSound(p.getLocation(), Sound.ARROW_HIT, 1, 1);
				}
			}
		}
		}catch(Exception e1){}
		
	}

}
