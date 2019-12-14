package de.golgolex.freebuild.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class LISTENER_SignChangeEvent implements Listener{
	
	@EventHandler
    public void onS(SignChangeEvent e){
    	Player p = e.getPlayer();
    	if(e.getLine(0).equals("shop")){
    		if(p.hasPermission("claymc.admin")){
    			e.setLine(0, "§7§m----------");
    			e.setLine(1, "§6Coins");
    			e.setLine(2, "§6§lUMTAUSCH");
    			e.setLine(3, "§7§m----------");
    		}
    	}
    
    }

}
