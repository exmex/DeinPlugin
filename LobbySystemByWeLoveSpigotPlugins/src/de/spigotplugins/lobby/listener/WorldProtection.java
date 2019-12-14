package de.spigotplugins.lobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import de.spigotplugins.lobby.configmanager.Strings;
import de.spigotplugins.lobby.data.Data;

public class WorldProtection implements Listener{
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e){
		if(Data.GHunger == true){
		if(Data.Hunger == false){
		e.setCancelled(true);	
		}else{
			e.setCancelled(false);
		}
		}else{
			if(e.getEntity().getWorld().getName().equals(Strings.WeltName)){
				if(Data.Hunger == false){
					e.setCancelled(true);
				}else{
					e.setCancelled(false);
				}
			}
		}
	}
	@EventHandler
	public void onFood(BlockBreakEvent e){
		if(Data.GAbbauen == true){
		if(Data.Abbauen == false){
		e.setCancelled(true);	
		}else{
			e.setCancelled(false);
		}
		}else{
			if(e.getPlayer().getWorld().getName().equals(Strings.WeltName)){
				if(Data.Abbauen == false){
					e.setCancelled(true);
				}else{
					e.setCancelled(false);
				}
			}
		}
	}
	@EventHandler
	public void onFood(BlockPlaceEvent e){
		if(Data.GAbbauen == true){
		if(Data.Abbauen == false){
		e.setCancelled(true);	
		}else{
			e.setCancelled(false);
		}
		}else{
			if(e.getPlayer().getWorld().getName().equals(Strings.WeltName)){
				if(Data.Abbauen == false){
					e.setCancelled(true);
				}else{
					e.setCancelled(false);
				}
			}
		}
	}
	@EventHandler
	public void onFood(EntityDamageEvent e){
		if(e.getEntity() instanceof Player){
		if(Data.GSchaden == true){
		if(Data.Schaden == false){
		e.setCancelled(true);	
		}else{
			e.setCancelled(false);
		}
		}else{
			if(e.getEntity().getWorld().getName().equals(Strings.WeltName)){
				if(Data.Schaden == false){
					e.setCancelled(true);
				}else{
					e.setCancelled(false);
				}
			}
		}
		}
	}
}
