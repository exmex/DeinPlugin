package de.spigotplugins.freebuild.methods;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.spigotplugins.freebuild.data.Data;

public class HomeBlock implements Listener{

	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§9§l● §6Home-Konfiguration §9§l●")){
			p.sendMessage(Data.Prefix + "§eBitte konfiguriere deinen §6HomeBlock§e, um ihn entsprechend Nutzen zu können! §7[§aRechtsklick§7]");
			PlayerData.SettedHomeBlocksNotCompleted.put(p.getUniqueId(), e.getBlock().getLocation());
		}
	}
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(e.getBlock().getTypeId() == 137){
			if(PlayerData.SettedHomeBlocksNotCompleted.get(p.getUniqueId()) == e.getBlock().getLocation()){
				PlayerData.SettedHomeBlocksNotCompleted.remove(p.getUniqueId());
				p.sendMessage(Data.Prefix + "§cDu hast deinen §6Home-Block §czerstört, du bist nun Obdachlos!");
			}
		}
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			if(e.getItem().getTypeId() == 137){
				if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					if(e.getClickedBlock().getLocation().equals(PlayerData.SettedHomeBlocksNotCompleted.containsKey(p.getUniqueId()))){
						
					}else{
						p.sendMessage(Data.Prefix + "§cDieser §6HomeBlock §cgehört dir nicht...");
					}
				}
			}
		}catch(Exception e1){}
	}
}
