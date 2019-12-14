package de.golgolex.freebuild.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.golgolex.freebuild.methods.Data;
import de.golgolex.freebuild.methods.Stats;

public class LISTENER_PlayerDeathEvent implements Listener{
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		
		e.setDeathMessage(null);
			
		
		if(k != null){
			if(Data.deathcount.get(k) == null){
				Data.deathcount.put(k, p);
				Data.Coins.put(k.getName(), +16);
				Data.deathcount.put(k, p);
				k.sendMessage(Data.pr + "§7Du hast §a16 §7Coins erhalten, da du einen Spieler getötet hast");
			}else{
				Player cp = Data.deathcount.get(k);
				if(p.getName().contains(cp.getName())){
					k.sendMessage(Data.pr + "§7Du erhälst keine Coins, da du diesen Spieler erst kürzlich getötet hast");
				}else{
					Data.Coins.put(k.getName(), +16);
					Data.deathcount.put(k, p);
					k.sendMessage(Data.pr + "§7Du hast §a16 §7Coins erhalten, da du einen Spieler getötet hast");
				}
			}
		}
	}

}
