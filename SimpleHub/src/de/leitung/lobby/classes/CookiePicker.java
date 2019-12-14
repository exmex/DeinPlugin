package de.leitung.lobby.classes;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


public class CookiePicker implements Listener{
	public static ArrayList<Player>list = new ArrayList<Player>();
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			if(e.getItem().getType() == Material.COOKIE){
				if(list.contains(p)){
					list.remove(p);
					p.sendMessage(Main.Prefix + "§cDu hast deine §5Cookie-Boots§c abgelegt!");
					p.playSound(p.getLocation(), Sound.NOTE_STICKS, 1, 1);
				}else{
					list.add(p);
					p.playSound(p.getLocation(), Sound.NOTE_STICKS, 1, 1);
					p.sendMessage(Main.Prefix + "§6Du hast deine §5Cookie-Boots §6angelegt!");
				}
			}
		}catch(Exception e1){}
	}
	

}
