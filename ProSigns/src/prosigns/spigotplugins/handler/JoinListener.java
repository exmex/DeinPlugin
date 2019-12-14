package prosigns.spigotplugins.handler;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import prosigns.spigotplugins.data.Data;

public class JoinListener implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Data.createsign.put(e.getPlayer().getName(), false);
		
	}

}
