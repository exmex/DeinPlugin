package de.souppvp.feast;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class KitFunctions implements Listener{
	 
	@EventHandler
	public void onF(PlayerInteractEvent e){
		Player p = e.getPlayer();
		try{
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				if(e.getItem().getType() == Material.FIREWORK){
					if(FeastData.KANGAROO_KIT.contains(p)){
						e.setCancelled(true);
						Block b = p.getLocation().getBlock();
			            if (b.getType() != Material.AIR || b.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
			                if(!(p.isSneaking())){
			                    p.setFallDistance(-(4F + 1));
			                    Vector vector = p.getEyeLocation().getDirection();
			                    vector.multiply(0.6F);
			                    vector.setY(4F / 4F);
			                    p.setVelocity(vector);
			                    p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
			                    } else {
			                        p.setFallDistance(-(4F + 1));
			                        Vector vector = p.getEyeLocation().getDirection();
			                        vector.multiply(1.2F);
			                        vector.setY(0.8);
			                        p.setVelocity(vector);
				                    p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);

			                    }
			            }
			        
					}
				}
				if(e.getItem().getType() == Material.LEATHER){
					if(FeastData.SUPPENMEISTER_KIT.contains(p)){
						Inventory inv = Bukkit.createInventory(null, 27, "§6Suppenmeister");
						ItemStack Suppe = new ItemStack(Material.MUSHROOM_SOUP);
						ItemMeta sm = Suppe.getItemMeta();
						sm.setDisplayName("§3Suppe");
						Suppe.setItemMeta(sm);
						for(int i = 0; i < 27 ; i++){
							inv.setItem(i, Suppe);
						}
						p.openInventory(inv);
	                    p.playSound(p.getLocation(), Sound.CHEST_OPEN, 10, 10);
					}
				}
			}
		}catch(Exception e1){}
	}

}
