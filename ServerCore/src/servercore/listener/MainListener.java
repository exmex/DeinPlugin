package servercore.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import servercore.data.Data;

public class MainListener implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage(Data.Prefix + "§6" + p.getName() + "§e hat den Server betreten!");
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		e.setQuitMessage(Data.Prefix + "§6" + p.getName() + "§e hat den Server verlassen!");
	}

}
