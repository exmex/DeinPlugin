package de.leitung.clayshandler.classes;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.MrCodex.MySQLCloud.SQL.CoinsAPI;

public class ClayHandler implements Listener{
	
	@EventHandler
	public void onDe(PlayerDeathEvent e){
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		if(k != null){
			CoinsAPI.addCoins(k.getName(), 2);
		}
	}
}

		
	

