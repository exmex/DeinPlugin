package de.Niclas.EarlyHG;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;
import com.mewin.WGRegionEvents.events.RegionLeaveEvent;

public class ShopSystem implements Listener{
	
	@EventHandler
	public void p(RegionEnterEvent e){
		if(e.getRegion().getId().equalsIgnoreCase("spawn")){
			Player p = e.getPlayer();
			ItemStack i = new ItemStack(Material.NETHER_STAR);
			ItemMeta im = i.getItemMeta();
			im.setDisplayName("§6Kits");
			i.setItemMeta(im);
			p.getInventory().setItem(8, i);
			return;
		}
	}
	
	@EventHandler
	public void ap(RegionLeaveEvent e){
		if(e.getRegion().getId().equalsIgnoreCase("spawn")){
			Player p = e.getPlayer();
			ItemStack i = new ItemStack(Material.NETHER_STAR);
			p.getInventory().removeItem(i);
			return;
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kits")){
				Player p = e.getPlayer();
				p.sendMessage(Data.prefix + "§cDas Menü ist derzeit noch in Arbeit!");
				
			}
		}catch(Exception e1){
			
		}
	}
}
