package de.souppvp.onevsonemanager;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.souppvp.data.Data;
import de.souppvp.data.ItemCreator;
import de.souppvp.listener.PlayerJoinListener;
import de.souppvp.spawnmanager.SpawnManager;

public class LeaveOneVSOne implements Listener{
	
	@EventHandler
	public void onLeave(PlayerInteractEvent e){
		Player p = e.getPlayer();
		try{
		if(e.getItem().getType() == Material.BARRIER){
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				if(Data.OneVSOneJoin.contains(p)){
					Data.OneVSOneJoin.remove(p);
					OneVSOneLobby.setOneVSOneInventory(p);
					OneVSOneWarteschlange.warteschlange.remove(p);
					if(OneVSOneChallenger.fight.containsKey(p)){
					OneVSOneChallenger.fight.remove(p);
					}
					Data.firstJoin.add(p);
					SpawnManager.teleportToSpawn(p, "Spawn");
					p.sendMessage(Data.Prefix + "§eDu befindest dich nun am §6Spawn§e!");
					p.playSound(p.getLocation(), Sound.ARROW_HIT, 1, 1);
					PlayerJoinListener.getLobbyItems(p);
					Data.INOneVSOneJoin.remove(p);
					Data.OneVSOneWarteschlange.remove(p);
					OneVSOneWarteschlange.warteschlange.remove(p);
					
				}
			}
		}
	}catch(Exception e1){}
	}

}
