package de.golgolex.freebuild.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.golgolex.freebuild.methods.Data;

public class LISTENER_BlockBukkitCommands implements Listener{
	
	@EventHandler
	public void onB(PlayerCommandPreprocessEvent e){
		if (e.getMessage().startsWith("/tell") || e.getMessage().startsWith("/icanhasbukkit") || e.getMessage().startsWith("/gamemode")){
			if(e.getPlayer().hasPermission("claymc.admin")){
				e.setCancelled(false);
			}else{
				e.getPlayer().sendMessage(Data.noperm);
				e.setCancelled(true);
			}
		}

	}

}
