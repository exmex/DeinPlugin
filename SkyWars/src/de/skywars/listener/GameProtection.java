package de.skywars.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.CraftItemEvent;

import de.skywars.gamestates.GameState;
import de.skywars.main.Main;
import de.skywars.utils.Data;

public class GameProtection implements Listener{
	
	@EventHandler
	public void onBlockBr(BlockBreakEvent e){
		if(Main.gs == GameState.LOBBY || Main.gs == GameState.ENDING){
			e.setCancelled(true);
		}else{
			e.setCancelled(false);
		}
	}
	@EventHandler
	public void onBlockBr(BlockPlaceEvent e){
		if(Main.gs == GameState.LOBBY || Main.gs == GameState.ENDING){
			e.setCancelled(true);
		}else{
			e.setCancelled(false);
		}
	}
	@EventHandler
	public void onBlockBr(FoodLevelChangeEvent e){
		if(Main.gs == GameState.LOBBY || Main.gs == GameState.ENDING){
			e.setCancelled(true);
		}else{
			e.setCancelled(false);
		}
	}
	@EventHandler
	public void onBlockBr(EntityDamageByEntityEvent e){
		if(Main.gs == GameState.LOBBY || Main.gs == GameState.ENDING){
			e.setCancelled(true);
		}else{
			e.setCancelled(false);
		}
	}
	@EventHandler
	public void onBlockBr(EntityDamageEvent e){
		if(Main.gs == GameState.LOBBY || Main.gs == GameState.ENDING){
			e.setCancelled(true);
		}else{
			e.setCancelled(false);
		}
	}
	@EventHandler
	public void onCraft(CraftItemEvent e){
		if(e.getCurrentItem().getType() == Material.CHEST){
			e.setCancelled(true);
			Player p = (Player)e.getWhoClicked();
			p.sendMessage(Data.Prefix + "§cDu darfst keine Truhen craften...");
		}
	}
}
