package de.souppvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import de.souppvp.data.Data;

public class ItemDrop implements Listener{
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		if(e.getItemDrop().isOnGround()){
			if(e.getItemDrop().getCustomName().equals("§3Suppe")){
				e.getItemDrop().remove();
			}
		}
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		if(Data.INOneVSOneJoin.contains(p) || Data.OneVSOneJoin.contains(p)){
			e.getDrops().clear();
		}
	}
}
