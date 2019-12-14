package lobby.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import lobby.data.Data;
import lobby.methods.ItemCreator;

public class QuickJoiner implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
		if(e.getItem().getType() == Material.ENDER_CHEST){
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				Player p = e.getPlayer();
				p.sendMessage(Data.Prefix + "§cDiese Funktion wird demnächst hinzugefügt!");
				p.playSound(p.getLocation(), Sound.ANVIL_USE, 1, 1);
				
			}
		}
	}catch(Exception e1){}
	}

}
