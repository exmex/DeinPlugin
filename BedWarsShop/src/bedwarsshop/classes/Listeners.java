package bedwarsshop.classes;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Listeners implements Listener{

	
	@EventHandler
	public void onEnti(EntityDamageByEntityEvent e){
		if(e.getEntityType() == EntityType.VILLAGER){
			e.setCancelled(true);
		}
	}
}
