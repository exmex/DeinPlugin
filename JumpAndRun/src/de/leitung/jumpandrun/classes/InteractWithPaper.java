package de.leitung.jumpandrun.classes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractWithPaper implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			
			Player p = e.getPlayer();
			
			if(e.getItem().getType() == Material.PAPER){
				Inventory inv = Bukkit.createInventory(null, 9 , "§7Compass");
				
				
				
				inv.setItem(0, createItem(Material.DIAMOND_SWORD, "§a§oFFA", 0, 0));
				
				inv.setItem(4, createItem(Material.EMERALD_BLOCK, "§e§oMap1", 0, 0));
				
				inv.setItem(8, createItem(Material.DIAMOND_BLOCK, "§e§oMap2", 0, 0));
				
				
				p.openInventory(inv);
	
			}
		}catch(Exception e1){
			
		}
	}
	
	@EventHandler
	public void onInv(InventoryClickEvent e) {
		
		try {
			
			
			if(e.getInventory().getName().equalsIgnoreCase("§7Compass")) {
				
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§oFFA")) {
					SpawnManager.getConfigLoc("FFA", SpawnManager.cfg);
				}
				
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§oMap1")) {
					SpawnManager.getConfigLoc("JumpenRun" + 1, SpawnManager.cfg);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§oMap2")) {
					SpawnManager.getConfigLoc("JumpenRun" + 2, SpawnManager.cfg);
				}
				
				
				
				
				
				
			}
			
			
			
		}catch (Exception e1) {}
		

		
		
		
		
	}
	
	
	
	
	
	
	
	public static ItemStack createItem(Material mat , String Displayname , int subid , int anzahl) {
		
		ItemStack item = new ItemStack(mat , anzahl , (short)subid);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(Displayname);
		item.setItemMeta(itemm);
		return item;
	}

}
