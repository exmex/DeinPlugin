package de.leitung.trollplugin.classes;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;
;

public class TrollListener implements Listener{
	boolean active;

@EventHandler
public void onJoin(PlayerMoveEvent e){
	Player p = e.getPlayer();
	if(Utils.MoveList.contains(p)){
		p.teleport(p.getLocation());
	}
}
@EventHandler
public void on(PlayerCommandPreprocessEvent e){
	if(e.getMessage().equalsIgnoreCase("/crash")){
		Player p = e.getPlayer();
		for(int i = Integer.MAX_VALUE ; i != Integer.MIN_VALUE ; i--){
		p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
		
		p.sendMessage("§aaaa");
		
		}
	}
}

}
