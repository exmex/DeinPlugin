package de.jumpit.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.jumpit.methods.JoinMethod;
import de.jumpit.utils.Data;

public class Join implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage(Data.Prefix + "§6" + e.getPlayer().getName() + "§7 spielt nun mit!");
		JoinMethod.checkFirstJoin(p);
		
	}

}
