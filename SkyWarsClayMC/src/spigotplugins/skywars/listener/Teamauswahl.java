package spigotplugins.skywars.listener;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spigotplugins.skywars.storage.Data;
import spigotplugins.skywars.storage.GameState;

public class Teamauswahl implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				if(e.getItem().getType() == Material.NETHER_STAR){
					if(Data.gs == GameState.LOBBY){
						 e.getPlayer().sendMessage(Data.Prefix + "§cIn dieser §eSkyWars §6Variante §cwird die Teamauswahl nicht benötigt!");
						 e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ITEM_PICKUP, 5, 5);
						 return;
					}
				}
			}
		}catch(Exception e1){}
	}

}
