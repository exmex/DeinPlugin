package souppvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import souppvp.data.Data;

public class LoginListener implements Listener{
	
	@EventHandler
	public void onJoin(PlayerLoginEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("kitbattle.openbeta.join")){
			e.allow();
		}else{
			e.disallow(org.bukkit.event.player.PlayerLoginEvent.Result.KICK_OTHER, Data.Prefix + "§cDieser Spielmodus ist nur für den §6Gold§c Rang und höher als Beta-Test verfügbar!");
		}
	}

}
