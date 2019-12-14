package de.jumpit.itemfunctions;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import de.jumpit.methods.Build;
import de.jumpit.utils.Data;

public class CompassListener implements Listener{
	
	@EventHandler
	public void on(PlayerInteractEvent e){
		try{
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getItem().getType() == Material.COMPASS){
					Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§6Spielauswahl");
					inv.setItem(1, Build.build(Material.DIAMOND_BOOTS, 1, 0, "§bJumpAndRun", "§6Erfarme dir Coins durch das Springen"));
					inv.setItem(3, Build.build(Material.DIAMOND_SWORD, 1, 0, "§bKämpfen", "§6Kämpfe mit deinem Equipment"));
					e.getPlayer().openInventory(inv);
				}
			}
		
		}catch(Exception e1){}
	}

}
