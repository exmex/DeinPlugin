package de.knockbackffa.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.knockbackffa.main.Main;

public class Join implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		if(Main.BungeeMode == true){
			String MainJoinMessage = Main.JoinMessage;
			String JoinMessage = MainJoinMessage.replace("%Player%", p.getName());
			e.setJoinMessage(JoinMessage);
			p.teleport(Main.MainSpawn);
			
		}
	}

}
