package souppvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropListener implements Listener{
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		if(
			       e.getItemDrop().getItemStack().getType() == Material.MUSHROOM_SOUP
				|| e.getItemDrop().getItemStack().getType() == Material.BOWL
				){
			if(e.getItemDrop().getItemStack().getType() == Material.BOWL){
				e.getItemDrop().getItemStack().setType(Material.AIR);
			}
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
			
	}

}
