package de.leitung.lobby.classes;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class WaterKnockback implements Listener{

	
	 @EventHandler
	    public void onMove(PlayerMoveEvent e) {
	        Player p = e.getPlayer();
	        double x = p.getLocation().getX();
	        double y = p.getLocation().getY();
	        double z = p.getLocation().getZ();
	        Location loc = new Location(p.getLocation().getWorld(), x, y, z);
	        if(loc.add(0, -1, 0).getBlock().getType() == Material.STATIONARY_WATER){	           
	        	Vector v = p.getLocation().getDirection().multiply(1.5).setY(1.2);
	            p.setVelocity(v);
	        }
	    }
	 
	 
}
