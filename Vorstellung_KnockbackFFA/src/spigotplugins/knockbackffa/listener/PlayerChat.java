package spigotplugins.knockbackffa.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import spigotplugins.knockbackffa.main.StatsManager;

public class PlayerChat implements Listener{
	
	 @EventHandler
	 public void onWrite(AsyncPlayerChatEvent e){
		String Message = e.getMessage().replace("%", "Prozent");
		if(!e.getPlayer().hasPermission("knockbackffa.team")){
			e.setFormat("§b[§c" + StatsManager.Kills.get(e.getPlayer().getName()) + "§b] §7" + e.getPlayer().getName() + "§8 » §f" + Message);
		}else{
			e.setFormat("§b[§c" + StatsManager.Kills.get(e.getPlayer().getName()) + "§b] §c" + e.getPlayer().getName() + "§8 » §f" + Message);
		}
	 }

}
