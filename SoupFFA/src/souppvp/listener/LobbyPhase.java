package souppvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import souppvp.data.Data;
import souppvp.methods.ItemCreator;
import souppvp.methods.Sounds;

public class LobbyPhase implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			if(e.getItem().getType() == Material.COMPASS){
				if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					if(Data.amspawn.contains(p)){
						Inventory inv = Bukkit.createInventory(null, 9, "§aWähle eine Map aus");
						inv.setItem(3, ItemCreator.CreateItemwhitMaterial(Material.GRASS, 0, 0, "§bSky", "§7Trete der Map §6Sky §7bei"));
						inv.setItem(5, ItemCreator.CreateItemwhitMaterial(Material.WOOD, 0, 0, "§eTripple", "§7Trete der Map §6Tripple §7bei"));
						p.openInventory(inv);
						Sounds.playKitPickSound(p);
						return;
					}
				}
			}
		}catch(Exception e1){}
		return;
	}
	@EventHandler
	public void onCli(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§aWähle eine Map aus")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.GRASS){
				Data.amspawn.remove(p);
				Data.mapsky.add(p);
				Data.nopickedkit.add(p);
				souppvp.methods.Inventory.setStandartItems(p);
				Sounds.playAdminAcceptSound(p);
				p.teleport(Data.sky);
				p.updateInventory();
				return;
			}
			if(e.getCurrentItem().getType() == Material.WOOD){
				Data.amspawn.remove(p);
				Data.maptripple.add(p);
				Data.nopickedkit.add(p);
				souppvp.methods.Inventory.setStandartItems(p);
				Sounds.playAdminAcceptSound(p);
				p.teleport(Data.tripple);
				p.updateInventory();
				return;
			}
		}
	}
}
