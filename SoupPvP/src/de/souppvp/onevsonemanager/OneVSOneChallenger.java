package de.souppvp.onevsonemanager;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.souppvp.data.Data;

public class OneVSOneChallenger implements Listener{
	public static HashMap<Player, Player> fight = new HashMap<>();


	@EventHandler(ignoreCancelled = true)
	public void on(EntityDamageByEntityEvent e){
		Player p = (Player) e.getEntity();
		Player t = (Player)e.getDamager();
		if(Data.OneVSOneJoin.contains(e.getDamager())){
			e.setCancelled(true);
				if(t.getItemInHand().getType() == Material.DIAMOND_SWORD){
					if(fight.containsKey(t)){
						if(fight.get(t) == p){
							t.sendMessage(Data.Prefix + "§cDu hast dem Spieler §e" + p.getName() + "§c bereits eine Anfrage gesendet!");
							p.playSound(p.getLocation(), Sound.FIRE, 1, 1);
						return;
						}
					}else{
						fight.put(t, p);
						t.sendMessage(Data.Prefix + "§eDu hast §6" + p.getName() + "§e zu einem Kampf herausgefordert!");
						p.sendMessage(Data.Prefix + "§6" + t.getName() + "§e hat dir eine Anfrage zu einem Kampf gesendet!");
						p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1, 1);
						t.playSound(t.getLocation(), Sound.NOTE_PIANO, 1, 1);

					}
					if(fight.get(p) == t){
						p.sendMessage(Data.Prefix + "§aDer Kampf beginnt nun!");
						t.sendMessage(Data.Prefix + "§aDer Kampf beginnt nun!");
						fight.remove(p);
						fight.remove(t);
						FightManager.startOneVSOne(p, t);
						return;
				}
		}
		}
		
	}
}
