package de.knockbackffa.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import de.knockbackffa.main.Main;

public class Damage implements Listener{
	
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if(Main.GetHitDamage = false){
		e.setDamage(0.0);
		}
	}
	
	
	@EventHandler
	public void onFallDamage(EntityDamageEvent e) {
		
		
		if(e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
			e.setCancelled(true);
		}
		
	}
	
	
	

}
