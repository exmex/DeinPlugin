package spigotplugins.skywars.listener;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener{
	public static ArrayList<Player> move = new ArrayList<>();
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		if(move.contains(e.getPlayer())){
			Player p = e.getPlayer();
			Location to = e.getTo();
			Location from = e.getFrom();
			
			if(from.getX() != to.getX() || from.getZ() != to.getZ()) {
				p.teleport(from);
			}
		}
	}

}
