package de.ttt.game;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.ttt.gamestates.GameState;
import de.ttt.main.Main;
import de.ttt.utils.Data;

public class QuitMessage implements Listener{
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		if(Main.gs == GameState.LOBBY){
			e.setQuitMessage(Data.prefix + "§cDer Spieler §6" + p.getName() + "§c hat die Runde verlassen!");
			return;
			
		}
	}

}
