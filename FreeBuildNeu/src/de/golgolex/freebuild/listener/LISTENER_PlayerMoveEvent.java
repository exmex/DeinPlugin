package de.golgolex.freebuild.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.golgolex.freebuild.methods.Data;

public class LISTENER_PlayerMoveEvent implements Listener{
	
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (Data.teleport.contains(p)) {
        	Data.teleport.remove(p);
            p.sendMessage(Data.pr + "§7Der Teleportvorgang wurde beendet, weil du dich bewegt hast");
        }
    }

}
