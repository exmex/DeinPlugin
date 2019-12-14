package de.golgolex.freebuild.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.connorlinfoot.titleapi.TitleAPI;
import com.mewin.WGRegionEvents.events.RegionEnterEvent;
import com.mewin.WGRegionEvents.events.RegionLeaveEvent;

import de.golgolex.freebuild.methods.Data;

public class LISTENER_WorldEnter implements Listener{
	
	 @SuppressWarnings("deprecation")
	@EventHandler
	    public void onRegion(RegionEnterEvent e) {
	        if (e.getRegion().getId().equalsIgnoreCase("spawn")) {
	            Player p = e.getPlayer();
	            p.sendMessage(Data.pr + "§7Du bist nun wieder am Spawn");
	            TitleAPI.sendFullTitle(p, 20, 40, 20, "§7Sicherheit", "§aSicher");
	            p.setHealth(20.0);
	            p.setFoodLevel(20);
	        	p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);

	        }
	        if (e.getRegion().getId().equalsIgnoreCase("unsicher")) {
	            Player p = e.getPlayer();
	            p.sendMessage(Data.pr + "§7Du bist nun wieder in der Zwischenzone");
	            TitleAPI.sendFullTitle(p, 20, 40, 20, "§7Sicherheit:", "§aSicher");
	            p.setHealth(20.0);
	            p.setFoodLevel(20);
	        	p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

	        }
	    }

	    @SuppressWarnings("deprecation")
		@EventHandler
	    public void onRegio1n(RegionLeaveEvent e) {
	        if (e.getRegion().getId().equalsIgnoreCase("spawn")) {
	            Player p = e.getPlayer();
	            p.sendMessage(Data.pr + "§7Laufe noch §a80 §7Blöcke nach vorne, um abbauen zu können");
	            TitleAPI.sendFullTitle(p, 20, 40, 20, "§7Sicherheit:", "§cUnsicher");
	        	p.playSound(p.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 10);

	            return;
	        }
	        if(e.getRegion().getId().equalsIgnoreCase("unsicher")){
	        	Player p = e.getPlayer();
	        	p.sendMessage(Data.pr + "§7Du bist nun für alle Gegner angreifbar und du kannst nun abbauen");
	        	TitleAPI.sendFullTitle(p, 20, 40, 20, "§9ClayMC.net", "§aPass auf dich auf");
	        	p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 10, 10);
	        }
	        
	    }

}
