package de.leitung.cmdblock;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CMDBLOCK implements Listener{
	
	@EventHandler
	public void onP(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		if(e.getMessage().startsWith("/tell")){
			e.setCancelled(true);
			p.sendMessage("§cDieser Befehl ist nicht gestattet!");
		}else if(e.getMessage().startsWith("/me")){
			e.setCancelled(true);
			p.sendMessage("§cDieser Befehl ist nicht gestattet!");
		}else if(e.getMessage().startsWith("/bukkit")){
			e.setCancelled(true);
			p.sendMessage("§cDieser Befehl ist nicht gestattet!");
		}else if(e.getMessage().startsWith("/minecraft")){
			e.setCancelled(true);
			p.sendMessage("§cDieser Befehl ist nicht gestattet!");
		}
	}

}
