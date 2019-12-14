package skypvp.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class nw implements Listener{
	
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK){
			
			
			
			if(e.getItem().getType() == Material.NETHER_WARTS){
				p.playSound(p.getLocation(), Sound.NOTE_BASS, 1F, 1F);
				Inventory inv = Bukkit.createInventory(null, 27, "§bWähle eine Option!");
				
				ItemStack ih = new ItemStack(Material.NETHER_STAR);
				ItemMeta ihmeta = ih.getItemMeta();
				ihmeta.setDisplayName("§bWähle ein Kit");
				ih.setItemMeta(ihmeta);
				
				ItemStack is = new ItemStack(Material.BARRIER);
				ItemMeta ismeta = is.getItemMeta();
				ismeta.setDisplayName("§cComming Soon");
				is.setItemMeta(ismeta);
				
				ItemStack ic = new ItemStack(Material.NAME_TAG);
				ItemMeta icmeta = ic.getItemMeta();
				icmeta.setDisplayName("§bSetze dir einen Nicknamen");
				ic.setItemMeta(icmeta);
				
				ItemStack il = new ItemStack(Material.EYE_OF_ENDER);
				ItemMeta ilmeta = il.getItemMeta();
				ilmeta.setDisplayName("§bSchutzschild");
				il.setItemMeta(ilmeta);
				
				ItemStack db = new ItemStack(Material.FEATHER);
				ItemMeta dbmeta = db.getItemMeta();
				dbmeta.setDisplayName("§bFly-Mode");
				db.setItemMeta(dbmeta);
				
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§bWähle eine Option!")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.NETHER_STAR){
				Bukkit.dispatchCommand(p, "kit");
				p.closeInventory();
				
			}else if(e.getCurrentItem().getType() == Material.BARRIER){
				p.sendMessage(main.Prefix + "§cDiese Funktion gibt es noch nicht!");
				p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1F, 1F);
				p.closeInventory();
			}else if(e.getCurrentItem().getType() == Material.NAME_TAG)
		}
		
	}

}
