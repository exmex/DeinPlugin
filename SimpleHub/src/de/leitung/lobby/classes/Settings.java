package de.leitung.lobby.classes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Settings implements Listener{
@EventHandler
public void onJoin(PlayerJoinEvent e){
	Player p = e.getPlayer();
}
}
