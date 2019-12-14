package lobby.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import lobby.methods.ItemCreator;
import lobby.methods.Sounds;

public class Freunde implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
		if(e.getItem().getType() == Material.SKULL_ITEM){
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
		Player p = e.getPlayer();
		Inventory inv = Bukkit.createInventory(null, 9, "§6Freunde");
		inv.setItem(4, ItemCreator.CreateItemwhitMaterial(Material.BARRIER, 0, 1, "§c» §cDas FreundeSystem ist in Arbeit", "§7Verwalte deine Freundschaftsanfragen"));
		p.openInventory(inv);
		Sounds.playOpenInventorySound(p);
	}
		}
		}catch(Exception e1){}
	}
	@EventHandler
	public void onClick(InventoryClickEvent e){
		if(e.getInventory().getName().equalsIgnoreCase("§6Freunde")){
			e.setCancelled(true);
		}
	}
}
