package de.jumpit.itemfunctions;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CompassClickEvent implements Listener{
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		try{
		if(e.getInventory().getName().equalsIgnoreCase("§6Spielauswahl")){
			Player p = (Player)e.getWhoClicked();
			if(e.getCurrentItem().getType() == Material.DIAMOND_BOOTS){
				p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
				
			}
		}
		}catch(Exception e1){
			
		}
	}

}
