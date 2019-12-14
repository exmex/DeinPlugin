package spigotplugins.knockbackffa.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

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
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			if(e.getPlayer().getLocation().getY() > Main.SpawnY -2){
				if(e.getItem().getType() == Material.SNOW_BALL){
					if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					e.getPlayer().sendMessage(new Data().Prefix + "§cDu darfst keine Schneebälle werfen!");
					e.setCancelled(true);
					return;
				}
				}
				if(e.getItem().getType() == Material.BOW){
					if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					e.getPlayer().sendMessage(new Data().Prefix + "§cDu darfst hier keinen Bogen verwenden!");
					e.setCancelled(true);
					return;
				}
				}
				if(e.getItem().getType() == Material.FISHING_ROD){
					if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					e.getPlayer().sendMessage(new Data().Prefix + "§cDu darfst hier keine Angel verwenden!");
					e.setCancelled(true);
					return;
				}
				}
			}
		}catch(Exception e1){
		}
	}
}
