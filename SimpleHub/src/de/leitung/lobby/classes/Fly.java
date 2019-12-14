package de.leitung.lobby.classes;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Fly implements Listener{
	ArrayList<Player> list = new ArrayList<Player>();
	@EventHandler
	public void on(PlayerInteractEvent e){
		try{
			if(e.getItem().getType() == Material.SUGAR){
				Player p = e.getPlayer();
				if(p.hasPermission("claymc.gold")){
				if(list.contains(p)){
					list.remove(p);
					p.sendMessage(Main.Prefix + "§6Du hast den Flugmodus §cverlassen§6!");
					p.setAllowFlight(false);
					p.setFlying(false);
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
				}else{
					list.add(p);
					p.sendMessage(Main.Prefix + "§6Du kannst nun Fliegen!");
					p.setAllowFlight(true);
					p.setFlying(true);
					p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 1, 1);
				}
				}else{
					p.sendMessage(Main.Prefix + "§cDu benötigst mindestens den §6Gold §cRang, um auf der Lobby fliegen zu können!");
				}
			}
		}catch(Exception e1){}
	}

}
