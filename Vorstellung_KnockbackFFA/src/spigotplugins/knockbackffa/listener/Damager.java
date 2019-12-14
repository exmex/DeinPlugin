package spigotplugins.knockbackffa.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import spigotplugins.knockbackffa.main.Main;
import spigotplugins.knockbackffa.storage.Data;

public class Damager implements Listener{

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		e.setDamage(0);
		if(e.getEntity().getLocation().getY() > Main.SpawnY -2){
			e.setCancelled(true);
			e.getDamager().sendMessage(new Data().Prefix + "§cDu darfst dich hier nicht schlagen...");
		}else{
			e.setCancelled(false);
		}
		if(e.getDamager().getLocation().getY() < Main.SpawnY && e.getEntity().getLocation().getY() >= Main.SpawnY){
			e.setCancelled(true);
			e.getDamager().sendMessage(new Data().Prefix + "§cDu darfst dich hier nicht schlagen...");
		}
		if(e.getEntity().getLocation().getY() < Main.SpawnY && e.getDamager().getLocation().getY() >= Main.SpawnY){
			e.setCancelled(true);
			e.getDamager().sendMessage(new Data().Prefix + "§cDu darfst dich hier nicht schlagen...");
		}
	}
}
