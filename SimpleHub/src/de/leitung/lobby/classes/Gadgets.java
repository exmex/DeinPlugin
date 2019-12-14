package de.leitung.lobby.classes;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tiger.Gadgets.Listener.InventoryClickListener;
import me.MrCodex.MySQLCloud.SQL.CoinsAPI;

public class Gadgets implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
		if(e.getItem().getType() == Material.CHEST){
			e.setCancelled(true);
			Player p = e.getPlayer();
			InventoryClickListener.openGadget(p);
		
		
		}
	}catch(Exception e1){
		
	}
	}
	@EventHandler
	public void onCl(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§6Shop")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.GOLD_BOOTS){
				p.closeInventory();
				Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§6Shop");
				ItemStack m = new ItemStack(build(Material.CHEST, 1, 0, "§6Meine Schuhe", "§7Wähle deine Schuhe aus"));
				ItemStack k = new ItemStack(build(Material.ENDER_CHEST, 1, 0, "§6Schuhe kaufen", "§7Kaufe dir Schuhe"));
				inv.setItem(1, m);
				inv.setItem(3, k);
				p.openInventory(inv);
				p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1, 1);
			}else if(e.getCurrentItem().getType() == Material.GOLDEN_CARROT){
				
			}else if(e.getCurrentItem().getType() == Material.DIAMOND_BARDING){
				
			}else if(e.getCurrentItem().getType() == Material.CHEST){
				if(UTILS.lava.contains(p)){
					
				}
			}
		}
	}

	public static ItemStack build(Material m, int anzahl, int sh, String name, String lore) {
	        ItemStack item = new ItemStack(m, anzahl, (short)sh);
	        ItemMeta itemm = item.getItemMeta();
	        itemm.setDisplayName(name);
	        ArrayList<String> list = new ArrayList<String>();
	        list.add(lore);
	        itemm.setLore(list);
	        item.setItemMeta(itemm);
	        return item;
	 }
}
