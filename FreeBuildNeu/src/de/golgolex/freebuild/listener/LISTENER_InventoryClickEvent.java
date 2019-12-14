package de.golgolex.freebuild.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class LISTENER_InventoryClickEvent implements Listener{
	
	 @EventHandler
	    public void onc(InventoryClickEvent e){
	    	try{
	    	Player p = (Player)e.getWhoClicked();
	    	if(e.getInventory().getName().equalsIgnoreCase("§2Spielerklärung")){
	    		e.setCancelled(true);
	    		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eCommands")){
	    			p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
	    			p.closeInventory();
	    			p.sendMessage("");
	    			p.sendMessage("§6HomeSystem §7» §e/SetHome & /Home");
	    			p.sendMessage("§6ClanSystem §7» §e/Clan");
	    			p.sendMessage("§6TPASystem §7» §e/TPA [Spieler]");
	    			p.sendMessage("§6SpawnSystem §7» §e/Spawn");
	    			return;
	    		}
	    		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTipps")){
	    			p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
	    			p.closeInventory();
	    			p.sendMessage("");
	    			p.sendMessage("§7Versuche deinen §eHome §7so versteckt wie möglich zu §ebauen§7, damit");
	    			p.sendMessage("§7andere §eSpieler §7deine Region nicht finden und §eZerstören §7können.");
	    			p.sendMessage("");
	    			p.sendMessage("§7Du musst umbedingt beim §eHandeln §7mit anderen §eSpielern §7aufpassen, sodass");
	    			p.sendMessage("§7du nicht §ebetrogen §7wirst!");
	    			return;
	    		}
	    		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Coins")){
	    			p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
	    			p.closeInventory();
	    			p.sendMessage("");
	    			p.sendMessage("§7Kaufe mit §eCoins §7neue §eItems §7am Spawn §b[/Spawn]");
	    			p.sendMessage("§eCoins §7erhältst §7du, indem du andere §eSpieler §7tötest.");
	    			p.sendMessage("§7Zudem kannst du §cRedstone§7, §bDiamanten§7, §bLapis-Lazuli §7und §aEmeralds §7abbauen, um");
	    			p.sendMessage("§eCoins §7zu erhalten!");
	    			return;
	    		}
	    	}
	    	}catch(Exception e1){}
	    }

}
