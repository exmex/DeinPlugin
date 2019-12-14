package skypvp.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ns implements Listener{
	
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK){
			
			
			
			if(e.getItem().getType() == Material.NETHER_STAR){
				
				
			
ItemStack il = new ItemStack(Material.AIR);
				
				Bukkit.dispatchCommand(p, "kit");
			
				
			}else{
				
				
			}
		}
		
			}

}
