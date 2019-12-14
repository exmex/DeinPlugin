package souppvp.listener;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SoupMethod implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		try{
			if(e.getItem().getType() == Material.MUSHROOM_SOUP){
				e.setCancelled(true);
				if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					ItemStack i = new ItemStack(Material.BOWL);
					ItemStack a = new ItemStack(Material.AIR);
					if(p.getHealth() == 20){
						return;
					}
					if(p.getHealth() > 12){
						p.setHealth(20);
						p.setItemInHand(a);
						p.setItemInHand(i);
						return;
					}else{
						p.setHealth(p.getHealth() +8);
						p.setItemInHand(a);
						p.setItemInHand(i);
						return;
					}
					
			}
				
			}
		}catch(Exception e1){}
	}
	

}
