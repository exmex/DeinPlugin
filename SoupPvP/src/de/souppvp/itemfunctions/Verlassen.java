package de.souppvp.itemfunctions;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;

import de.souppvp.data.Data;

public class Verlassen implements Listener{
	public Verlassen(de.souppvp.main.Main Main){
		this.pl = Main;
	}
	private de.souppvp.main.Main pl;

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		try{
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				if(e.getItem().getType() == Material.SLIME_BALL){
					if(Data.firstJoin.contains(p)){
						Location loc = p.getLocation();
						loc.setY(loc.getY() + 60);
						p.teleport(loc);
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
						Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable()
				          {
				            public void run()
				            {
				            	p.kickPlayer(Data.Prefix + "§3Du hast das Spiel verlassen!");
				            }
				          }, 15L);
					}
				}
			}
		}catch(Exception e1){}
	}

}
